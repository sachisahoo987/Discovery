import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        features = {"D:/Whizdom-Trainings/Online Training Workspace/Recording_Dec17/CucumberProject/src/test/resources/com/qtpselenium/rediff/Portfolio.feature:39"},
        plugin = {"json:D:/Whizdom-Trainings/Online Training Workspace/Recording_Dec17/CucumberProject/target/cucumber-parallel/4.json", "html:D:/Whizdom-Trainings/Online Training Workspace/Recording_Dec17/CucumberProject/target/cucumber-parallel/4"},
        monochrome = true,
        glue = {"com.qtpselenium.steps"})
public class Parallel04IT {
}
