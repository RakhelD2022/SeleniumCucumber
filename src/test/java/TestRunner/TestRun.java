package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions
        (
                features = ".//Features/AutomationPractice.feature",
                glue = "StepDefinitions",
                dryRun = false,
                plugin = {"pretty", "html:test-output"}
        )
public class TestRun {

}
