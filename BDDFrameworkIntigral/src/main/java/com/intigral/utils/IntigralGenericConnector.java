package com.intigral.utils;

import java.io.IOException;

import org.openqa.selenium.By;


public interface IntigralGenericConnector {
	
	public void initializeDriver() throws Exception;
	public void initializeGlobalParams();
	public void startRecording();
	public void stopRecording(String scenarioName) throws IOException;
	
}
