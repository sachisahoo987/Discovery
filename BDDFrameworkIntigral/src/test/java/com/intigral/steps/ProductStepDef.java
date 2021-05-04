package com.intigral.steps;

import com.intigral.pages.LoginPage;
import com.intigral.pages.ProductDetailsPage;
import com.intigral.pages.ProductsPage;
import com.intigral.utils.DriverManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ProductStepDef {
	
	DriverManager con;

	public ProductStepDef(DriverManager con) {
		this.con = con;
	}
	
	@Then("I validate single cart addition")
	public void singlecardaddition() {
		new ProductsPage().addSingleproductTocart();
		new ProductsPage().validatesingleaddtocart();
	}
	
	
	@Then("I validate notification badge")
	public void validateNotification() {
		new ProductsPage().validatenotification();
	}
	
	@Then("I validate single cart removal")
	public void singlecardremoval() {
		new ProductsPage().removeSingleproductTocart();
		new ProductsPage().validatesingleremovetocart();
	}
	
	
	@Then("I validate multiple cart addition")
	public void multicardaddition() {
		new ProductsPage().addSingleproductTocart();
		new ProductsPage().validatemultipleaddtocart();
	}
	@Then("I validate multiple cart removal")
	public void multicardremoval() {
		new ProductsPage().removemultipleproductTocart();
		new ProductsPage().validatemultipleremovetocart();
	}

	@Given("^I'm logged in$")
	public void iMLoggedIn() throws InterruptedException {
		new LoginPage().login("standard_user", "secret_sauce");
	}

	@Then("^the product is listed with title \"([^\"]*)\" and price \"([^\"]*)\"$")
	public void theProductIsListedWithTitleAndPrice(String title, String price) throws Exception {
		Boolean titleCheck = new ProductsPage().getProductTitle(title).equalsIgnoreCase(title);
		Boolean priceCheck = new ProductsPage().getProductPrice(title, price).equalsIgnoreCase(price);
		Assert.assertTrue("titleCheck = " + titleCheck + ", priceCheck = " + priceCheck, titleCheck & priceCheck);
	}

	@When("^I click product title \"([^\"]*)\"$")
	public void iClickProductTitle(String title) throws Exception {
		new ProductsPage().pressProductTitle(title);
	}

	@Then("^I should be on product details page with title \"([^\"]*)\", price \"([^\"]*)\" and description \"([^\"]*)\"$")
	public void iShouldBeOnProductDetailsPageWithTitlePriceAndDescription(String title, String price,
			String description) throws Exception {
		ProductDetailsPage productDetailsPage = new ProductDetailsPage();
		boolean titleCheck = productDetailsPage.getTitle().equalsIgnoreCase(title);
		boolean descCheck = productDetailsPage.getDesc().equalsIgnoreCase(description);
		boolean priceCheck = productDetailsPage.getPrice().equalsIgnoreCase(price);
		Assert.assertTrue("titleCheck = " + titleCheck + ", descCheck = " + descCheck + ", priceCheck = " + priceCheck,
				titleCheck & descCheck & priceCheck);
	}
}
