package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.TestAutomationPage;
import utilities.ConfigReader;
import utilities.Driver;

public class TestAutomationStepDefinitions {
    TestAutomationPage testAutomationPage = new TestAutomationPage();

    @Given("the user goes to the Test Automation homepage")
    public void the_user_goes_to_the_test_automation_homepage() {
        Driver.getDriver().get(ConfigReader.getProperty("taUrl"));
    }

    @Then("types phone in the search box and presses ENTER")
    public void types_phone_in_the_search_box_and_presses_ENTER() {
        testAutomationPage.searchBox.sendKeys("phone" + Keys.ENTER);
    }

    @Then("closes the page")
    public void closes_the_page() {
        Driver.closeDriver();
    }

    @And("tests that a product can be found in the search results")
    public void tests_that_a_product_can_be_found_in_the_search_results() {
        int resultCount = testAutomationPage.foundProductElementsList.size();
        Assert.assertTrue(resultCount > 0);
    }

    @And("waits for a moment")
    public void waits_for_a_moment() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("types shoes in the search box and presses ENTER")
    public void types_shoes_in_the_search_box_and_presses_ENTER() {
        testAutomationPage.searchBox.sendKeys("shoes" + Keys.ENTER);
    }

    @Then("types nutella in the search box and presses ENTER")
    public void types_nutella_in_the_search_box_and_presses_ENTER() {
        testAutomationPage.searchBox.sendKeys("nutella" + Keys.ENTER);
    }

    @And("tests that no product is found in the search results")
    public void tests_that_no_product_is_found_in_the_search_results() {
        int resultCount = testAutomationPage.foundProductElementsList.size();
        Assert.assertEquals(0, resultCount);
    }

    @Then("types {string} in the search box and presses ENTER")
    public void types_product_name_in_the_search_box_and_presses_ENTER(String desiredProduct) {
        testAutomationPage.searchBox.sendKeys(desiredProduct + Keys.ENTER);
    }

    @And("waits for {int} seconds")
    public void waits_for_seconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Given("the user goes to the homepage by navigating to {string}")
    public void the_user_goes_to_the_specified_homepage(String targetUrl) {
        Driver.getDriver().get(ConfigReader.getProperty(targetUrl));
    }

    @Then("clicks on the account button")
    public void clicks_on_the_account_button() {
        testAutomationPage.accountLink.click();
    }

    @Then("enters the email as {string}")
    public void enters_the_email_as(String emailType) {
        testAutomationPage.emailBox.sendKeys(ConfigReader.getProperty(emailType));
    }

    @Then("enters the password as {string}")
    public void enters_the_password_as(String passwordType) {
        testAutomationPage.passwordBox.sendKeys(ConfigReader.getProperty(passwordType));
    }

    @Then("clicks on the signIn button")
    public void clicks_on_the_sign_in_button() {
        testAutomationPage.loginButton.click();
    }

    @Then("tests that successful login is possible")
    public void tests_that_successful_login_is_possible() {
        Assert.assertTrue(testAutomationPage.logoutLink.isDisplayed());
    }

    @And("tests that the user cannot log into the system")
    public void tests_that_login_is_unsuccessful() {
        Assert.assertTrue(testAutomationPage.emailBox.isDisplayed());
    }
}
