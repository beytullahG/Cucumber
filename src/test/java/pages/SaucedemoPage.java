package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SaucedemoPage {

    public SaucedemoPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@placeholder='Username']")
    public WebElement usernameBox;
    @FindBy(xpath = "//input[@placeholder='Password']")
    public WebElement paswordBox;
    @FindBy(id = "login-button")
    public WebElement loginButton;
    @FindBy(id = "item_4_title_link")
    public WebElement firstProductElement;
    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    public WebElement addButton;
    @FindBy(xpath = "//*[@class='shopping_cart_link']")
    public WebElement shoppingCartButton;
    @FindBy(xpath = "//*[@class='inventory_item_name']")
    public WebElement elemetInCart;

}
