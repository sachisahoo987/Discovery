package com.intigral.utils;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.events.EventFiringWebDriver;


public interface GenericConnector extends IntigralGenericConnector {

	void logout();
	void validateLogin();	
	void validateTitle(String expectedTitle);
	void validateText(By locator,String expectedText);
	void validateElementPresence(By locator);
	boolean isElementPresent(By locator);
	
	
}
