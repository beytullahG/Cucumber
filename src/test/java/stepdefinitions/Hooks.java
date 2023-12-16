package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Driver;

public class Hooks {

    @After
    public void tearDown(Scenario scenario){

        // This method runs after each scenario in the Cucumber feature.

        // Checks if the scenario has failed
        if (scenario.isFailed()) {
            // Takes a screenshot of the current state of the web page
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);

            // Attaches the screenshot to the Cucumber report
            scenario.attach(screenshot, "image/png", "screenshots");

            // Closes the WebDriver instance
            Driver.closeDriver();
        }
    }
}
