package com.discovery.webdriver;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.discovery.reports.ExtentManager;

public class WebConnector {

	private WebDriver driver;
	public String name;
	public Properties prop;
	public ExtentReports rep;
	public ExtentTest scenario;
	public String objectKey;
	public Hashtable<String, String> data;
	public String dataKey;

	public WebConnector() {

		if (prop == null) {

			try {
				prop = new Properties();
				FileInputStream fs = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\project.properties");
				prop.load(fs);
			} catch (Exception e) {
				e.printStackTrace();
				// report
			}
		}
	}

	public void openBrowser(String browserName) {
		if (prop.getProperty("gridRun").equals("Y")) {
			// invoke browser through grid
			DesiredCapabilities cap = null;
			if (browserName.equals("Mozilla")) {
				cap = DesiredCapabilities.firefox();
				cap.setJavascriptEnabled(true);
				cap.setPlatform(Platform.WINDOWS);
			} else if (browserName.equals("Chrome")) {
				cap = DesiredCapabilities.chrome();
				cap.setJavascriptEnabled(true);
				cap.setPlatform(Platform.WINDOWS);
			}

			try {
				setDriver(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap));
			} catch (MalformedURLException e) {

				e.printStackTrace();
			}
		} else {
			if (browserName.equals("Mozilla")) {
				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + "\\BrowseDrivers\\geckodriver.exe");
				driver = new FirefoxDriver();
			} else if (browserName.equals("Chrome")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\BrowseDrivers\\chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browserName.equals("IE")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\BrowseDrivers\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			} else if (browserName.equals("Edge")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\BrowseDrivers\\msedgedriver.exe");
				driver = new EdgeDriver();
			}
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);

		driver.manage().window().maximize();
		infoLog("Opened Browser");
	}

	public void navigate(String urlKey) {
		driver.get(prop.getProperty(urlKey));
	}

	public void click(String objectKey) {
		getObject(objectKey).click();
	}
	
	public void clickHidden(String objectKey) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", getObject(objectKey));
	}
	
	public void scrolltoView(String objectKey) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getObject(objectKey));
	}
	
	public void scrollDownFullHeight() {
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,3300)");
	}
	
	public void scrollDownHalfPage() {
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)");
	}

	public void mousehover(String objectKey) {
		WebElement e1= null;
		System.out.println("--------------------------------"+objectKey);
		System.out.println("--------------------------------"+prop.getProperty(objectKey));
		e1 = driver.findElement(By.xpath(prop.getProperty(objectKey)));
		Actions actions = new Actions(driver);
		actions.moveToElement(e1);
		actions.build().perform();
	}

	public void type(String objectKey, String data) {
		getObject(objectKey).sendKeys(data);
	}

	public void select(String objectKey, String data) {
		Select s = new Select(getObject(objectKey));
		s.selectByVisibleText(data);
	}

	public void clear(String objectKey) {
		getObject(objectKey).clear();
	}

	// central function to extract objects
	public WebElement getObject(String objectKey) {
		WebElement e = null;
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);

		try {
			if (objectKey.endsWith("_xpath")) {
				e = getDriver().findElement(By.xpath(prop.getProperty(objectKey)));// present
				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(prop.getProperty(objectKey))));
			} else if (objectKey.endsWith("_id")) {
				e = getDriver().findElement(By.id(prop.getProperty(objectKey)));// present
				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id(prop.getProperty(objectKey))));
			} else if (objectKey.endsWith("_name")) {
				e = getDriver().findElement(By.name(prop.getProperty(objectKey)));// present
				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name(prop.getProperty(objectKey))));
			} else if (objectKey.endsWith("_css")) {
				e = getDriver().findElement(By.cssSelector(prop.getProperty(objectKey)));// present
				wait.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(By.cssSelector(prop.getProperty(objectKey))));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			//// reportFailure("Unable to extract Object " + objectKey);
		}
		return e;
	}

	// true - present
	// false - not present

	public boolean isElementInList() {
		// validate whether value is present in dropdown
		List<WebElement> options = new Select(getObject(objectKey)).getOptions();
		for (int i = 0; i < options.size(); i++) {
			if (options.get(i).getText().equals(data.get(dataKey)))
				return true;
		}

		return false;
	}

	public boolean isTextPresent(String text, String locatorKey) {
		try {
			boolean b = getDriver().getPageSource().contains(text);

			String Actual = driver.findElement(By.xpath(prop.getProperty(locatorKey))).getText();
			String Expected = text;
			if (b) {
				//// System.out.println("----------------------------------------ExpectedResult is found in the page ");
				////infoLog("ExpectedResult is found in the page "+"Actual"+Actual+"matches with"+"Expected"+Expected);
				infoLog("ExpectedResult is found in the page --  "+ text);
				return true;
			} else {
				
				//// System.out.println("----------------------------------------ExpectedResult not found in the page ");				
				reportFailure("ExpectedResult is not found in the page "+"Actual-- "+Actual+"does not match with"+"Expected--"+Expected);
				return false;
			}

		} catch (Exception e) {
			return false;
		}

	}

	public boolean isElementPresent(String objectKey) {
		List<WebElement> e = null;

		if (objectKey.endsWith("_xpath")) {
			e = getDriver().findElements(By.xpath(prop.getProperty(objectKey)));// present
		} else if (objectKey.endsWith("_id")) {
			e = getDriver().findElements(By.id(prop.getProperty(objectKey)));// present
		} else if (objectKey.endsWith("_name")) {
			e = getDriver().findElements(By.name(prop.getProperty(objectKey)));// present
		} else if (objectKey.endsWith("_css")) {
			e = getDriver().findElements(By.cssSelector(prop.getProperty(objectKey)));// present
		}
		try {
			if (e.isEmpty())
				return false;
			else
				return true;
		} catch (java.lang.NullPointerException E) {
			return false;
		}
	}

	public void validateDiscoveryGoPage(String expectedResult) {
		boolean result = isElementPresent("exploreAllNew_xpath");
		String actualResult = "";

		if (result)
			actualResult = "success";
		else
			actualResult = "failure";

		infoLog("ExpectedResult was " + expectedResult);
		infoLog("Got actualt Result as " + actualResult);
		if (!expectedResult.equals(actualResult)) {
			reportFailure("Scenario Failure"); // reporting failure
		}
	}

	public void acceptAlertIfPresent() {
		try {
			WebDriverWait wait = new WebDriverWait(getDriver(), 15);
			wait.until(ExpectedConditions.alertIsPresent());
			getDriver().switchTo().alert().accept();
			getDriver().switchTo().defaultContent();
		} catch (Exception e) {
			// not present
		}
	}

	public void clickAndWait(String xpathExpTarget, String xpathExpWait, int maxTime) {
		for (int i = 0; i < maxTime; i++) {
			// click
			getObject(xpathExpTarget).click();
			// check presence of other ele
			if (isElementPresent(xpathExpWait)
					&& getDriver().findElement(By.id(prop.getProperty(xpathExpWait))).isDisplayed()) {
				// if present - success.. return
				return;
			} else {
				// else wait for 1 sec
				wait(1);
			}

		}
		// 10 seconds over - for loop - comes here
		reportFailure("Target element coming after clicking on " + xpathExpTarget);
	}

	public void waitForPageToLoad() {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		int i = 0;

		while (i != 10) {
			String state = (String) js.executeScript("return document.readyState;");

			if (state.equals("complete"))
				break;
			else
				wait(2);

			i++;
		}
		i = 0;
		while (i != 10) {

			Long d = (Long) js.executeScript("return jQuery.active;");

			if (d.longValue() == 0)
				break;
			else
				wait(2);
			i++;

		}

	}

	public void wait(int time) {
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	/********** logging **************/
	public void infoLog(String msg) {
		scenario.log(Status.PASS, msg);
	}

	public void reportFailure(String errMsg) {
		// fail in extent reports
		scenario.log(Status.FAIL, errMsg);
		takeSceenShot();
		// take screenshot and put in repots
		// fail in cucumber as well
		assertThat(false);
	}

	public void takeSceenShot() {
		// fileName of the screenshot
		Date d = new Date();
		String screenshotFile = d.toString().replace(":", "_").replace(" ", "_") + ".png";
		// take screenshot
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			// get the dynamic folder name
			FileUtils.copyFile(srcFile, new File(ExtentManager.screenshotFolderPath + screenshotFile));
			// put screenshot file in reports
			scenario.log(Status.FAIL, "Screenshot-> "
					+ scenario.addScreenCaptureFromPath(ExtentManager.screenshotFolderPath + screenshotFile));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/************** Reporting ******************/
	public void quit() {
		if (rep != null)
			rep.flush();
		if (driver != null)
			driver.quit();
	}

	public void initReports(String scenarioName) {
		String reportPath=System.getProperty("user.dir") + "\\testreports\\";
		rep = ExtentManager.getInstance(reportPath);
		scenario = rep.createTest(scenarioName);
		scenario.log(Status.INFO, "Starting " + scenarioName);
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
}
