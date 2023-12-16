package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/html-reports/report2.html",
                "json:target/json-reports/cucumber.json",
                "junit:target/xml-report/cucumber.xml"},
        features = "src/test/resources/features", // Where are the Feature/Scenario files?
        glue = "stepdefinitions",    // Where are the codes for Feature/Scenario?
        tags = "@wip",  // Which Feature/Scenario will be executed?
        dryRun = false // If set to true, it checks missing steps without running the test
        // During actual test execution, dryRun should be false
)

public class Runner {

}

