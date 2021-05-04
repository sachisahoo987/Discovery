package com.intigral.pages;

import org.openqa.selenium.By;

import com.intigral.utils.DriverManager;
import com.intigral.utils.GlobalParams;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class CartPage extends ProductsPage {
	DriverManager utils = new DriverManager();

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-CHECKOUT\"]/android.widget.TextView")
	private MobileElement checkout;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='test-CANCEL']/android.widget.TextView")
	private MobileElement checkoutcancel;

	@AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"test-First Name\"]")
	private MobileElement firstName;

	@AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"test-Last Name\"]")
	private MobileElement lastNAme;

	@AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"test-Zip/Postal Code\"]")
	private MobileElement pinCode;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-CONTINUE\"]")
	private MobileElement checkoutcontinue;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-CANCEL\"]/android.widget.TextView")
	private MobileElement checkoutfinalcancel;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-FINISH\"]/android.widget.TextView")
	private MobileElement checkoutfinish;

	@AndroidFindBy(xpath = "//android.widget.ScrollView[@content-desc=\"test-CHECKOUT: COMPLETE!\"]/android.view.ViewGroup/android.widget.TextView[1]")
	private MobileElement checkoutsuccess;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-BACK HOME\"]")
	private MobileElement backTohome;
	
	@AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"])[1]/android.widget.TextView")
	private MobileElement addtocart;

	
	@AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"test-REMOVE\"])[1]/android.widget.TextView")
	private MobileElement removetocart;

	public void navigateCartpage() {
		click(cart);
		waitForVisibility(checkout);
	}

	public void navigateCheckoutpage() {
		click(checkout);
		waitForVisibility(checkoutcontinue);

	}

	public void enterDetails() {
		sendKeys(firstName, "test");
		sendKeys(lastNAme, "user");
		sendKeys(pinCode, "100200");
		waitForVisibility(checkoutcontinue);

	}

	public void navigateContinuepage() throws InterruptedException {
		click(checkoutcontinue);
		scrollDown();

	}

	public void checkoutFinsh() throws Exception {
		scrollDown();
		click(checkoutfinish);

	}

	public void checkoutSucess() {
		waitForVisibility(checkoutsuccess);
		waitForVisibility(backTohome);

	}
	
	public void backTohome() {
		click(backTohome);
		waitForVisibility(addtocart);

	}

	public void checkoutCancel() {
		scrollDown();
		click(checkoutfinalcancel);
		waitForVisibility(removetocart);
		

	}

}
