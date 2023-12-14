package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.HerokuappPage;

public class HerokuappStepdifinitions {
    HerokuappPage herokuappPage=new HerokuappPage();
    @When("the user clicks on the Add Element button")
    public void the_user_clicks_on_the_add_element_button() {
        herokuappPage.addElementButton.click();
    }
    @When("tests that the Delete button is visible")
    public void tests_that_the_delete_button_is_visible() {
        Assert.assertTrue(herokuappPage.deleteElementButton.isDisplayed());
    }
    @Then("the user clicks the Delete button")
    public void the_user_clicks_the_delete_button() {
       herokuappPage.deleteElementButton.click();
    }
    @And("tests that the Add Remove Elements text is visible")
    public void testsThatTheAddRemoveElementsTextIsVisible() {
        Assert.assertTrue(herokuappPage.addElementButton.isDisplayed());
    }
}
