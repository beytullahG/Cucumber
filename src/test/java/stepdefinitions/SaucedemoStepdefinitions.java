package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.SaucedemoPage;
import utilities.ConfigReader;
import utilities.Driver;

public class SaucedemoStepdefinitions {
    SaucedemoPage saucedemoPage = new SaucedemoPage();
    String firstproductName;

    @Given("types {string} into the saucedemo username box")
    public void types_sauceUrl_into_the_saucedemo_username_box(String username) {
        saucedemoPage.usernameBox.sendKeys(username);
    }

    @Then("types {string} into the saucedemo password box")
    public void types_into_the_saucedemo_password_box(String password) {
        saucedemoPage.paswordBox.sendKeys(password);
    }

    @Then("clicks on the saucedemo login button")
    public void clicks_on_the_saucedemo_login_button() {
        saucedemoPage.loginButton.click();
    }

    @Then("records the name of the first product and goes to its page")
    public void records_the_name_of_the_first_product_and_goes_to_its_page() {
        firstproductName = saucedemoPage.firstProductElement.getText();
        saucedemoPage.firstProductElement.click();
    }

    @When("clicks on the saucedemo add to Cart button")
    public void clicks_on_the_saucedemo_add_to_cart_button() {
        saucedemoPage.addButton.click();
    }

    @Then("clicks on the saucedemo shopping cart")
    public void clicks_on_the_saucedemo_shopping_cart() {
        saucedemoPage.shoppingCartButton.click();
    }

    @Then("tests that the selected product has been successfully added to the cart")
    public void tests_that_the_selected_product_has_been_successfully_added_to_the_cart() {
        String elementNameInCart = saucedemoPage.elemetInCart.getText();
        Assert.assertEquals(firstproductName, elementNameInCart);
    }

}
