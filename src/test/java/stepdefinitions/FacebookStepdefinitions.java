package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.FacebookPage;
import utilities.Driver;

public class FacebookStepdefinitions {

    FacebookPage facebookPage = new FacebookPage();

    @Then("accepts Facebook cookies")
    public void accepts_facebook_cookies() {
        facebookPage.acceptCookiesButton.click();
    }

    @Then("clicks on the create new account button on Facebook")
    public void clicks_on_the_create_new_account_button_on_facebook() {
        facebookPage.createNewAccountButton.click();
    }

    @When("fills out the Facebook registration form with information from the Faker class")
    public void fills_out_the_facebook_registration_form_with_information_from_the_faker_class() {
        Actions actions = new Actions(Driver.getDriver());
        Faker faker = new Faker();
        String fakeEmail = faker.internet().emailAddress();

        actions.sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(fakeEmail)
                .sendKeys(Keys.TAB)
                .sendKeys(fakeEmail)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("12")
                .sendKeys(Keys.TAB)
                .sendKeys("Şub")
                .sendKeys(Keys.TAB)
                .sendKeys("1991")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_RIGHT)
                .perform();
    }

    @Then("clicks on the Facebook sign-up button")
    public void clicks_on_the_facebook_sign_up_button() {
        facebookPage.signUpButton.click();
    }
}
