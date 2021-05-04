package com.intigral.steps;

import java.io.IOException;

import org.openqa.selenium.OutputType;

import com.intigral.utils.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    @Before
    public void initialize() throws Exception {
        new DriverManager().startRecording();
    }

    @After
    public void quit(Scenario scenario) throws IOException {
        if(scenario.isFailed()){
            byte[] screenshot = new DriverManager().getDriver().getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }

        new DriverManager().stopRecording(scenario.getName());
    }
}
