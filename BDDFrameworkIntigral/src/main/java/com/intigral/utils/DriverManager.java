package com.intigral.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.apache.commons.codec.binary.Base64;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.screenrecording.CanRecordScreen;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class DriverManager extends TestUtils {
	public static ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();
	private static ThreadLocal<AppiumDriverLocalService> server = new ThreadLocal<>();
	Properties props = new PropertyManager().getProps();
	private static FileInputStream fis;

	public AppiumDriver getDriver() {
		return driver.get();
	}

	public void setDriver(AppiumDriver driver2) {
		driver.set(driver2);
	}

	public void initializeDriver() throws Exception {
		AppiumDriver driver = null;

		// for browser stack
		if (props.getProperty("Cucumber_Profile_BrowserStack").equalsIgnoreCase("Y")){
			String userName = props.getProperty("BROWSERSTACK_USERNAME");
			String accessKey = props.getProperty("BROWSERSTACK_ACCESS_KEY");
			String buildName = props.getProperty("BROWSERSTACK_BUILD_NAME");
			String app = props.getProperty("BROWSERSTACK_APP_ID");
			JSONObject deviceObj = null;
			if (props.getProperty("AppType").equalsIgnoreCase("android")) {
				deviceObj = new JSONObject(JsonParser.parse("Devices.json").getJSONObject("1").toString());
			} else {
				deviceObj = new JSONObject(JsonParser.parse("Devices.json").getJSONObject("2").toString());

			}

			DesiredCapabilities caps = new DesiredCapabilities();

			caps.setCapability("device", deviceObj.getString("device"));
			caps.setCapability("os_version", deviceObj.getString("os_version"));
			caps.setCapability("project", "Testing mobile app");
			caps.setCapability("build", buildName);
			caps.setCapability("name", "Browser stack Testing mobile app");
			caps.setCapability("app", app);

			URL url = new URL("https://" + userName + ":" + accessKey + "@hub-cloud.browserstack.com/wd/hub");

			if (props.getProperty("AppType").equalsIgnoreCase("android")) {
				driver = new AndroidDriver(url, caps);

			} else if (props.getProperty("AppType").equalsIgnoreCase("ios")) {
				driver = new IOSDriver(url, caps);
			} else {
				throw new IllegalStateException("invalid device id");
			}

			setDriver(driver);
		}

		else {
			GlobalParams params = new GlobalParams();

			if (driver == null) {
				try {
					log().info("initializing Appium driver");
					switch (params.getPlatformName()) {
					case "Android":
						driver = new AndroidDriver(getServer().getUrl(), getCaps());
						break;
					case "iOS":
						driver = new IOSDriver(getServer().getUrl(), getCaps());
						break;
					}
					if (driver == null) {
						throw new Exception("driver is null. ABORT!!!");
					}
					log().info("Driver is initialized");
					this.driver.set(driver);
				} catch (IOException e) {
					e.printStackTrace();
					log().fatal("Driver initialization failure. ABORT !!!!" + e.toString());
					throw e;
				}
			}

		}

	}

	public AppiumDriverLocalService getServer() {
		return server.get();
	}

	public void startServer() {
		log().info("starting appium server");
		AppiumDriverLocalService server = WindowsGetAppiumService();
		server.start();
		if (server == null || !server.isRunning()) {
			log().fatal("Appium server not started. ABORT!!!");
			throw new AppiumServerHasNotBeenStartedLocallyException("Appium server not started. ABORT!!!");
		}
//        server.clearOutPutStreams();
		this.server.set(server);
		log().info("Appium server started");
	}

	public AppiumDriverLocalService getAppiumServerDefault() {
		return AppiumDriverLocalService.buildDefaultService();
	}

	public AppiumDriverLocalService WindowsGetAppiumService() {
		GlobalParams params = new GlobalParams();
		return AppiumDriverLocalService.buildService(new AppiumServiceBuilder().usingAnyFreePort()
				.withArgument(GeneralServerFlag.SESSION_OVERRIDE).withLogFile(new File(
						params.getPlatformName() + "_" + params.getDeviceName() + File.separator + "Server.log")));
	}

	public DesiredCapabilities getCaps() throws IOException {
		GlobalParams params = new GlobalParams();

		try {
			log().info("getting capabilities");
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability(MobileCapabilityType.PLATFORM_NAME, params.getPlatformName());
			caps.setCapability(MobileCapabilityType.UDID, params.getUDID());
			caps.setCapability(MobileCapabilityType.DEVICE_NAME, params.getDeviceName());

			switch (params.getPlatformName()) {
			case "Android":
				caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, props.getProperty("androidAutomationName"));
				caps.setCapability("appPackage", props.getProperty("androidAppPackage"));
				caps.setCapability("appActivity", props.getProperty("androidAppActivity"));
				caps.setCapability("systemPort", params.getSystemPort());
				caps.setCapability("chromeDriverPort", params.getChromeDriverPort());
				// String androidAppUrl =
				// getClass().getResource(props.getProperty("androidAppLocation")).getFile();
				String androidAppUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
						+ File.separator + "resources" + File.separator + "apps" + File.separator
						+ "Android.SauceLabs.Mobile.Sample.app.2.2.1.apk";
				log().info("appUrl is" + androidAppUrl);
				caps.setCapability("app", androidAppUrl);
				break;
			case "iOS":
				caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, props.getProperty("iOSAutomationName"));
				// String iOSAppUrl =
				// getClass().getResource(props.getProperty("iOSAppLocation")).getFile();
				String iOSAppUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
						+ File.separator + "resources" + File.separator + "apps" + File.separator
						+ "SwagLabsMobileApp.app";
				log().info("appUrl is" + iOSAppUrl);
				caps.setCapability("bundleId", props.getProperty("iOSBundleId"));
				caps.setCapability("wdaLocalPort", params.getWdaLocalPort());
				caps.setCapability("webkitDebugProxyPort", params.getWebkitDebugProxyPort());
				caps.setCapability("app", iOSAppUrl);
				break;
			}
			return caps;
		} catch (Exception e) {
			e.printStackTrace();
			log().fatal("Failed to load capabilities. ABORT!!" + e.toString());
			throw e;
		}
	}

	public void startRecording() {
		((CanRecordScreen) getDriver()).startRecordingScreen();

	}

	public void stopRecording(String scenarioName) throws IOException {
		GlobalParams params = new GlobalParams();
		String media = ((CanRecordScreen) getDriver()).stopRecordingScreen();
		String dirPath = params.getPlatformName() + "_" + params.getDeviceName() + File.separator + "Videos";

		File videoDir = new File(dirPath);

		synchronized (videoDir) {
			if (!videoDir.exists()) {
				videoDir.mkdirs();
			}
		}
		FileOutputStream stream = null;
		try {
			stream = new FileOutputStream(videoDir + File.separator + scenarioName + ".mp4");
			stream.write(Base64.decodeBase64(media));
			stream.close();
			log().info("video path: " + videoDir + File.separator + scenarioName + ".mp4");
		} catch (Exception e) {
			log().error("error during video capture" + e.toString());
		} finally {
			if (stream != null) {
				stream.close();
			}
		}
	}

	@Override
	public void logout() {
		// TODO Auto-generated method stub

	}

	@Override
	public void validateLogin() {
		// TODO Auto-generated method stub

	}

	@Override
	public void validateTitle(String expectedTitle) {
		// TODO Auto-generated method stub

	}

	@Override
	public void validateText(By locator, String expectedText) {
		// TODO Auto-generated method stub

	}

	@Override
	public void validateElementPresence(By locator) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isElementPresent(By locator) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void initializeGlobalParams() {
		// TODO Auto-generated method stub

	}

}
