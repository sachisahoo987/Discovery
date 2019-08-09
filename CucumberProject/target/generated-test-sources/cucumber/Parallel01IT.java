import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        features = {"C:/Users/nec/Documents/sachi/Selenium_Code/code/Cucumber Framework/CucumberProject/src/test/resources/com/discovery/videos/Favourites.feature:44"},
        plugin = {"json:C:/Users/nec/Documents/sachi/Selenium_Code/code/Cucumber Framework/CucumberProject/target/cucumber-parallel/1.json", "html:C:/Users/nec/Documents/sachi/Selenium_Code/code/Cucumber Framework/CucumberProject/target/cucumber-parallel/1"},
        monochrome = true,
        glue = {"com.qtpselenium.steps"})
public class Parallel01IT {
}
