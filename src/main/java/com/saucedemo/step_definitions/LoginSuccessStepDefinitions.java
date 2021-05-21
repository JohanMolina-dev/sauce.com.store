package com.saucedemo.step_definitions;
import com.saucedemo.controller.LoginController;
import com.saucedemo.manager_conection.Manager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import screenshot.TakeScreenshot;

public class LoginSuccessStepDefinitions {

    private WebDriver driver;
    private final Manager manager = new Manager(driver);
    private static final Logger LOGGER = LogManager.getLogger(LoginSuccessStepDefinitions.class);

    @Given(": I'm on the page that allows me to start the session")
    public void i_m_on_the_page_that_allows_me_to_start_the_session() {
        driver = manager.selectBrowser("", "0.29.0");
        driver.manage().window().maximize();
        var urlBase = "https://www.saucedemo.com/";
        driver.get(urlBase);
        LOGGER.info("Active url LoginSuccess class");
    }

    @When("I enter my username and password blocked")
    public void i_enter_my_username_and_password_blocked() {
        var takeScreenshot = new TakeScreenshot(driver);
        var loginController = new LoginController(driver);
        loginController.loginWithUserBlocked();
        takeScreenshot.takeScreenshot();
    }

    @Then("I should see an alert abducting that I cannot log in successfully")
    public void i_should_see_an_alert_abducting_that_i_cannot_log_in_successfully() {
        var loginController = new LoginController(driver);
        var takeScreenshot = new TakeScreenshot(driver);
        loginController.assertAlerts("Epic sadface: Sorry, this user has been locked out.");
        takeScreenshot.takeScreenshot();
        manager.teardown();
        LOGGER.info("browser closed, driver removed LoginSuccess class");
    }

    @When("I enter invalid username and password")
    public void i_enter_invalid_username_and_password() {
        var takeScreenshot = new TakeScreenshot(driver);
        var loginController = new LoginController(driver);
        loginController.loginFailInvalidUSer();
        takeScreenshot.takeScreenshot();
    }

    @Then("I should see an alert abducting that there is an error")
    public void i_should_see_an_alert_abducting_that_there_is_an_error() {
        var takeScreenshot = new TakeScreenshot(driver);
        var loginController = new LoginController(driver);
        loginController.assertAlerts("Epic sadface: Username and password do not match any user in this service");
        takeScreenshot.takeScreenshot();
        manager.teardown();
        LOGGER.info("browser closed, driver removed LoginSuccess class");
    }

    @When("I enter my username and password correctly and validly")
    public void i_enter_my_username_and_password_correctly_and_validly() {
        var takeScreenshot = new TakeScreenshot(driver);
        var loginController = new LoginController(driver);
        loginController.loginSuccessful();
        takeScreenshot.takeScreenshot();
    }

    @Then("should be on the products page and I can log out")
    public void should_be_on_the_products_page_and_i_can_log_out() {
        var loginController = new LoginController(driver);
        var takeScreenshot = new TakeScreenshot(driver);
        loginController.logOut();
        takeScreenshot.takeScreenshot();
        manager.teardown();
        LOGGER.info("browser closed, driver removed LoginSuccess class");
    }
}
