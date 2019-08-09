package com.discovery.steps;

import com.discovery.webdriver.WebConnector;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
// pico container
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class GenericSteps {

	WebConnector con;

	public GenericSteps(WebConnector con) {
		this.con = con;
	}

	@Before
	public void before(Scenario s) {

		con.initReports(s.getName());
		con.infoLog("Initializing Reports " + s.getName());
	}

	@After
	public void after() {
		con.quit();
		con.infoLog("Quitting Browser ");
	}

	@Given("^I open (.*)$")
	public void openBrowser(String browserName) {
		con.infoLog("Opening Browser " + browserName);
		con.openBrowser(browserName);
	}

	@And("^I go to (.*)$")
	public void navigate(String url) {
		con.infoLog("Navigating to " + url);
		con.navigate(url);
	}

	@And("^I type (.*) in (.*) field$")
	public void type(String data, String locatorKey) {
		con.infoLog("Typing in " + locatorKey + ". Data " + data);
		con.type(locatorKey, data);
	}

	@And("^I clear (.*)$")
	public void clear(String locatorKey) {
		con.infoLog("Clearing in " + locatorKey);
		con.clear(locatorKey);
	}

	@And("^I click on (.*)$")
	public void click(String locatorKey) {
		con.infoLog("Clicking on " + locatorKey);
		con.click(locatorKey);
	}
	
	@And("^I execute clicking on hidden (.*)$")
	public void clickHidden(String locatorKey) {
		con.infoLog("Clicking on hidden " + locatorKey);
		con.clickHidden(locatorKey);
	}

	@And("^I scrollFull to (.*)$")
	public void scrollFull(String locatorKey) throws InterruptedException {

		con.infoLog("Scrolling To " + locatorKey);	
		con.scrollDownFullHeight();
	}
	
	@And("^I scrollHalf to (.*)$")
	public void scrollHals(String locatorKey) throws InterruptedException {

		con.infoLog("Scrolling To " + locatorKey);	
		con.scrollDownHalfPage();
	}
	
	@And("^I navigate back to previous page$")
	public void navigateback() {
		con.getDriver().navigate().back();
	}
	

	@And("^I hover over (.*)$")
	public void mousehover(String locatorKey) {
		con.infoLog("Hovering Over " + locatorKey);
		con.mousehover(locatorKey);
	}

	@And("^I click (.*) and wait for (.*)$")
	public void clickAndWait(String src, String target) {
		con.infoLog("Clicking on " + src);
		con.clickAndWait(src, target, 20);
	}

	@And("I select (.*) from (.*)")
	public void select(String data, String locatorKey) {
		con.infoLog("Selecting from " + locatorKey);
		con.select(locatorKey, data);
	}

	@And("^I wait for page to load$")
	public void waitForPageToLoad() {
		con.waitForPageToLoad();
	}

	@When("^I accept alert$")
	public void iAcceptAlert() {
		con.acceptAlertIfPresent();
	}

}
