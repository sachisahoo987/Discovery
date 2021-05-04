package com.intigral.steps;

import com.intigral.pages.LoginPage;
import com.intigral.pages.ProductsPage;
import com.intigral.utils.DriverManager;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDef {
	DriverManager con;

	public LoginStepDef(DriverManager con) {
		this.con = con;
	}


    @When("^I enter username as \"([^\"]*)\"$")
    public void iEnterUsernameAs(String username) throws InterruptedException {
        new LoginPage().enterUserName(username);
    }

    @When("^I enter password as \"([^\"]*)\"$")
    public void iEnterPasswordAs(String password) {
        new LoginPage().enterPassword(password);
    }

    @When("^I login$")
    public void iLogin() {
        new LoginPage().pressLoginBtn();
    }

    @Then("^login should fail with an error \"([^\"]*)\"$")
    public void loginShouldFailWithAnError(String err) {
        Assert.assertEquals(new LoginPage().getErrTxt(), err);
    }
    
    @Then("I should see Products page with title {string}")
    public void iShouldSeeMetadataInProductsPageWithTitle(String title) {
    	  Assert.assertEquals(new ProductsPage().getTitle(), title);
    }
    
    @Then("I should see metadata in Products page")
    public void validatemetadata() {
        new ProductsPage().validatemetadata();
    }
    
}
