package com.intigral.pages;

import org.openqa.selenium.By;

import com.intigral.utils.DriverManager;
import com.intigral.utils.GlobalParams;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class ProductsPage extends MenuPage {
	DriverManager utils = new DriverManager();

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Menu\"]/android.view.ViewGroup/android.widget.ImageView")
	private MobileElement menu;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Modal Selector Button\"]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView")
	private MobileElement filter;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.ImageView")
	protected MobileElement cart;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Toggle\"]/android.widget.ImageView")
	private MobileElement toggleview;

	@AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"])[1]/android.widget.TextView")
	private MobileElement addtocart;
	

	@AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"])[2]/android.widget.TextView")
	private MobileElement addtocart2;
	
	@AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"test-REMOVE\"])[1]/android.widget.TextView")
	private MobileElement removetocart;

	@AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"test-REMOVE\"])[2]/android.widget.TextView")
	private MobileElement removetocart2;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.TextView")
	private MobileElement cartnotification;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Cart drop zone\"]/android.view.ViewGroup/android.widget.TextView")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"test-Toggle\"]/parent::*[1]/preceding-sibling::*[1]")
	private MobileElement titleTxt;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"test-PRODUCTS\"]/XCUIElementTypeScrollView")
	private MobileElement iOSSCrollView;

	public String getTitle() {
		return getText(titleTxt, "product page title is - ");
	}

	public String getProductTitle(String title) throws Exception {
		switch (new GlobalParams().getPlatformName()) {
		case "Android":
			return getText(andScrollToElementUsingUiScrollable("text", title), "product title is: " + title);
		case "iOS":
			return getText(iOSScrollToElementUsingMobileScrollParent(iOSSCrollView, "label == '" + title + "'"),
					"product title is: " + title);
		default:
			throw new Exception("Invalid platform name");
		}
	}

	public By defProductPrice(String title) throws Exception {
		switch (new GlobalParams().getPlatformName()) {
		case "Android":
			return By.xpath("//*[@text=\"" + title + "\"]/following-sibling::*[@content-desc=\"test-Price\"]");
		case "iOS":
			return By.xpath("//XCUIElementTypeOther[@name=\"" + title
					+ "\"]/following-sibling::*[1]/child::XCUIElementTypeStaticText[@name=\"test-Price\"]");
		default:
			throw new Exception("Invalid platform name");
		}
	}

	public String getProductPrice(String title, String price) throws Exception {
		return getText(scrollToElement(defProductPrice(title), "up"), "product price is: " + price);
	}

	public ProductDetailsPage pressProductTitle(String title) throws Exception {
		switch (new GlobalParams().getPlatformName()) {
		case "Android":
			click(andScrollToElementUsingUiScrollable("text", title), "press " + title + " link");
			return new ProductDetailsPage();
		case "iOS":
			click(iOSScrollToElementUsingMobileScrollParent(iOSSCrollView, "label == '" + title + "'"),
					"press " + title + " link");
			return new ProductDetailsPage();
		default:
			throw new Exception("Invalid platform name");
		}
	}

	public void validatemetadata() {
     waitForVisibility(menu);
     waitForVisibility(toggleview);
     waitForVisibility(filter);
     waitForVisibility(addtocart);
     waitForVisibility(addtocart2);
	}
	
	public void addSingleproductTocart() {
		click(addtocart);

	}

	public void addmultipleproductTocart() {
		click(addtocart);
		click(addtocart2);
	}

	public void removeSingleproductTocart() {
		click(removetocart);

	}

	public void removemultipleproductTocart() {
		click(removetocart);
		click(removetocart2);

	}
	
	public void validatemultipleaddtocart() {
		waitForVisibility(removetocart);
		waitForVisibility(removetocart2);

	}

	
	public void validatemultipleremovetocart() {
		waitForVisibility(addtocart);
		waitForVisibility(addtocart2);

	}
	
	public void validatesingleaddtocart() {
		waitForVisibility(removetocart);

	}
	
	public void validatesingleremovetocart() {
		waitForVisibility(addtocart);

	}
	
	public void validatenotification() {
		waitForVisibility(cartnotification);

	}

}
