package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.TestAutomationPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class TestAutomationStepDefinitions {
    TestAutomationPage testAutomationPage = new TestAutomationPage();
    Sheet sheet2;
    int actualStockAmount;

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

    @When("enters {string} as the email from the list")
    public void entersAsTheEmailFromTheList(String givenEmail) {
        testAutomationPage.emailBox.sendKeys(givenEmail);
    }

    @And("enters {string} as the password from the list")
    public void entersAsThePasswordFromTheList(String givenPassword) {
        testAutomationPage.passwordBox.sendKeys(givenPassword);
    }

    @Then("finds the stock quantity of the product in the {string} row in the Excel")
    public void findsTheStockQuantityOfTheProductInTheRowInTheExcel(String rowNo) {
        String filePath = "src/test/resources/stock.xlsx";
        Workbook workbook;
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            workbook = new XSSFWorkbook(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        sheet2 = workbook.getSheet("Sheet2");
        String satirdakiUrunIsmi = sheet2.getRow(Integer.parseInt(rowNo) - 1).getCell(0).toString();

        testAutomationPage.searchBox.sendKeys(satirdakiUrunIsmi + Keys.ENTER);
        actualStockAmount = testAutomationPage.foundProductElementsList.size();
    }

    @And("tests that the stock quantity in the {string} row is greater than the given stock quantity")
    public void testsThatTheStockQuantityInTheRowIsGreaterThanTheGivenStockQuantity(String givenRow) {
        String filePath = "src/test/resources/stock.xlsx";
        Workbook workbook;
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            workbook = new XSSFWorkbook(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Sheet sheet2 = workbook.getSheet("Sheet2");

        String minStockAmountStr = sheet2
                .getRow(Integer.parseInt(givenRow) - 1).getCell(1).toString();
        System.out.println(minStockAmountStr);
        int minStockAmount = (int) Double.parseDouble(minStockAmountStr);

        Assert.assertTrue(actualStockAmount >= minStockAmount);

    }

    @Then("lists all the products in the stock excel that have increased, and have stock equal to or greater than the min stock quantity")
    public void listsAllTheProductsInTheStockExcelThatHaveIncreasedAndHaveStockEqualToOrGreaterThanTheMinStockQuantity() {

        String filePath = "src/test/resources/stock.xlsx";
        Workbook workbook;

        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            workbook = new XSSFWorkbook(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        sheet2 = workbook.getSheet("Sheet2");

        int lastRowNumber = sheet2.getLastRowNum();

        String productName;
        int minStock;
        int foundProductCount;
        List<String> sufficientStockProducts = new ArrayList<>();
        List<String> insufficientStockProducts = new ArrayList<>();

        for (int i = 1; i <= lastRowNumber; i++) {
            productName = sheet2.getRow(i).getCell(0).toString();
            minStock = (int) Double.parseDouble(sheet2.getRow(i).getCell(1).toString());

            testAutomationPage.searchBox.sendKeys(productName + Keys.ENTER);
            foundProductCount = testAutomationPage.foundProductElementsList.size();

            if (foundProductCount >= minStock) {
                sufficientStockProducts.add(productName);
            } else {
                insufficientStockProducts.add(productName);
            }
        }

        System.out.println("Products with sufficient stock: " + sufficientStockProducts);
        System.out.println("Products with insufficient stock: " + insufficientStockProducts);

    }
}
