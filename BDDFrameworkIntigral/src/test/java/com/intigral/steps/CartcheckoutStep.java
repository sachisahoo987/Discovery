package com.intigral.steps;

import com.intigral.pages.CartPage;
import com.intigral.pages.LoginPage;
import com.intigral.pages.ProductDetailsPage;
import com.intigral.pages.ProductsPage;
import com.intigral.utils.DriverManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CartcheckoutStep {
	
	DriverManager con;

	public CartcheckoutStep(DriverManager con) {
		this.con = con;
	}
	    
    
    @Then("I click on cart")
	public void clickonCart() {
		new CartPage().navigateCartpage();
	
	}
    
    @Then("I click on checkout")
   	public void clickonCheckout() {
    	new CartPage().navigateCheckoutpage();
   	
   	}
    
    @Then("I continue to final page")
   	public void continueCheckout() throws InterruptedException {
    	new CartPage().enterDetails();
    	new CartPage().navigateContinuepage();
   	
   	}
    
    @Then("I click on finish to finish the order checkout")
   	public void finishCheckout() throws Exception {
    	new CartPage().checkoutFinsh();
   	
   	}
    
    
    @Then("I validate if order checkout is sucess")
   	public void validateCheckoutsuccess() {
    	new CartPage().checkoutSucess();
   	
   	}
    
    @Then("I Navigate back to homepage")
   	public void navigatebackHome() {
    new CartPage().backTohome();
   	
   	}
    
    @Then("I click on cancel on final page and validate if order got cancelled")
   	public void cancelcheckout() {
    	new CartPage().checkoutCancel();
   	
   	}
    
    @Then("I validate if order got cancelled")
   	public void navigateHome() {
    	new CartPage().backTohome();
   	
   	}
    
  
}
