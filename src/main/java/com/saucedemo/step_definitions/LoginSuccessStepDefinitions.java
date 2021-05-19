package com.saucedemo.step_definitions;

import com.saucedemo.controller.LoginController;
import com.saucedemo.manager_conection.Manager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginSuccessStepDefinitions {

    private WebDriver driver;
    private final String urlBase = "https://www.saucedemo.com/";
    private Manager manager = new Manager(driver);
    private static final Logger LOGGER = LogManager.getLogger(LoginSuccessStepDefinitions.class);

    @Given(": I'm on the page that allows me to start the session")
    public void i_m_on_the_page_that_allows_me_to_start_the_session() {
        driver = manager.selectBrowser("chrome", "90.0.4430.212");
        driver.manage().window().maximize();
        driver.get(urlBase);
        System.out.println("1");
        LOGGER.info("Url activa");
    }

    @When("I enter my username and password blocked")
    public void i_enter_my_username_and_password_blocked() {
        LoginController loginController = new LoginController(driver);
        loginController.loginWithUserBlocked();
        LOGGER.info("Logica usuario bloqueado");

    }

    @Then("I should see an alert abducting that I cannot log in successfully")
    public void i_should_see_an_alert_abducting_that_i_cannot_log_in_successfully() {
        System.out.println("3");
        LoginController loginController = new LoginController(driver);
        assertEquals("Epic sadface: Sorry, this user has been locked out.",
                loginController.alert());
        manager.teardown();
        LOGGER.info("Url Cerrada");
    }

    @When("I enter invalid username and password")
    public void i_enter_invalid_username_and_password() {
        LoginController loginController = new LoginController(driver);
        loginController.loginFailInvalidUSer();
        LOGGER.info("Logica usuario bloqueado");
    }

    @Then("I should see an alert abducting that there is an error")
    public void i_should_see_an_alert_abducting_that_there_is_an_error() {
        System.out.println("3");
        LoginController loginController = new LoginController(driver);
        assertEquals("Epic sadface: Username and password do not match any user in this service",
                loginController.alert());
        manager.teardown();
        LOGGER.info("Url Cerrada");
    }

    @When("I enter my username and password correctly and validly")
    public void i_enter_my_username_and_password_correctly_and_validly() {
        LoginController loginController = new LoginController(driver);
        loginController.loginSuccessful();
        LOGGER.info("Logica usuario bloqueado");
    }

    @Then("should be on the products page and I can log out")
    public void should_be_on_the_products_page_and_i_can_log_out() {
        LoginController loginController = new LoginController(driver);
        loginController.logOut();
        manager.teardown();
        LOGGER.info("Url Cerrada");
    }
}
