package com.saucedemo.step_definitions;

import com.saucedemo.controller.CheckoutController;
import com.saucedemo.controller.LoginController;
import com.saucedemo.controller.ProductPageController;
import com.saucedemo.manager_conection.Manager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class BuyItemsStep {
    private WebDriver driver;
    private final Manager manager = new Manager(driver);
    private static final Logger LOGGER = LogManager.getLogger(CartAppendStep .class);
    @Given(": I'm on the products page and I have my products added to the shopping cart")
    public void i_m_on_the_products_page_and_i_have_my_products_added_to_the_shopping_cart() {

        try {
            driver = manager.selectBrowser("chrome", "90.0.4430.212");
            driver.manage().window().maximize();
            var urlBase = "https://www.saucedemo.com/";
            driver.get(urlBase);
            LOGGER.info("Active url CartAppendStep class");
            var loginController = new LoginController(driver);
            loginController.loginSuccessful();
            var productPageController = new ProductPageController(driver);
            productPageController.addAllItems();
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.warn("Failed to start BuyItemsStep");
        }
    }


    @When("check out my products, I enter my first and last name without the zip code")
    public void check_out_my_products_i_enter_my_first_and_last_name_without_the_zip_code() {
        CheckoutController checkoutController = new CheckoutController(driver);
        checkoutController.sendInputFieldWithOutZipCode();
    }

    @Then("I should see error message")
    public void i_should_see_error_message() {

        try{
            CheckoutController checkoutController = new CheckoutController(driver);
            checkoutController.checkAlertError();
            manager.teardown();
            LOGGER.info("browser closed, driver removed BuyItems class");
        }catch(Exception e){
            e.printStackTrace();
            LOGGER.warn("Error closing the browser");
        }
    }

    @When("check out my products, I enter my first and last name and I entered a wrong zip code, nonexistent")
    public void check_out_my_products_i_enter_my_first_and_last_name_and_i_entered_a_wrong_zip_code_nonexistent() {
        CheckoutController checkoutController = new CheckoutController(driver);
        checkoutController.sendInputFieldWrongOutZipCode();
    }
    @Then("I should see error message zip code")
    public void i_should_see_error_message_zip_code() {
        try {
            CheckoutController checkoutController = new CheckoutController(driver);
            checkoutController.checkAlertError();
            manager.teardown();
            LOGGER.info("browser closed, driver removed BuyItems class");
        }catch (Exception e){
            e.printStackTrace();
            manager.teardown();
            LOGGER.info("browser closed, driver removed BuyItems class,The result is not what was expected ");
        }
    }

    @When("check out my products, I enter my first and last name and I entered a correct zip code")
    public void check_out_my_products_i_enter_my_first_and_last_name_and_i_entered_a_correct_zip_code() {
        CheckoutController checkoutController = new CheckoutController(driver);
        checkoutController.submitMyCorrectInformation();
    }

    @Then("I should see the total of my purchase plus taxes and should be able to finish the purchase")
    public void i_should_see_the_total_of_my_purchase_plus_taxes_and_should_be_able_to_finish_the_purchase() {
        try {
            CheckoutController checkoutController = new CheckoutController(driver);
            checkoutController.checkTransaction();
            manager.teardown();
            LOGGER.info("browser closed, driver removed BuyItems class");
        }catch (Exception e){
            e.printStackTrace();
            manager.teardown();
            LOGGER.info("browser closed, driver removed BuyItems class, Fail The assertion !!");
    }
    }
}
