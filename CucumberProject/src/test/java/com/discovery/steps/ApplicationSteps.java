package com.discovery.steps;

import com.discovery.webdriver.WebConnector;

import cucumber.api.java.en.Then;

public class ApplicationSteps {

	WebConnector con;

	public ApplicationSteps(WebConnector con) {
		this.con = con;
	}

	@Then("^Navigation to the DiscoveryGO page should be (.*)$")
	public void ValidateDiscoveryGoPage(String expectedResult) {
		con.validateDiscoveryGoPage(expectedResult);
	}

	@Then("^(.*) should be visible in myvideos (.*)$")
	public void ValidateMyVideos(String expectedResult,String locatorkey) {
		con.isTextPresent(expectedResult,locatorkey);	
	}
}
