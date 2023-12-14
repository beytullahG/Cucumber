package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = "html:target/cucumber-reports/report1.html",
        features = "src/test/resources/features", // Where are the Feature/Scenario files?
        glue = "stepdefinitions",    // Where are the codes for Feature/Scenario?
        tags = "@wip",  // Which Feature/Scenario will be executed?
        dryRun = false // If set to true, it checks missing steps without running the test
        // During actual test execution, dryRun should be false
)

public class Runner {

}

/*
    The Runner class can be likened to TestNG's XML files.
    Through the Runner, we can run individual or multiple Feature/Scenarios.

    The Runner class not only runs our tests but also ensures
    the necessary files for our framework are in the right places,
    automating the build process.

    The Runner class should not contain actual code; it is an empty class.
    The main tasks are handled by two annotations.

    The @CucumberOptions annotation manages the build process.

 */
