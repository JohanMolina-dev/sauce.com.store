package com.saucedemo.step_definitions;
import com.saucedemo.controller.LoginController;
import com.saucedemo.controller.ProductPageController;
import com.saucedemo.manager_conection.Manager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class CartAppendStep {
    private WebDriver driver;
    private final Manager manager = new Manager(driver);
    private static final Logger LOGGER = LogManager.getLogger(CartAppendStep .class);

    @Given("I am a user with a correct Login and I am on the products page")
    public void iAmAUserWithACorrectLoginAndIAmOnTheProductsPage() {
        driver = manager.selectBrowser("chrome", "90.0.4430.212");
        driver.manage().window().maximize();
        var urlBase = "https://www.saucedemo.com/";
        driver.get(urlBase);
        LOGGER.info("Active url CartAppendStep class");
        var loginController = new LoginController(driver);
        loginController.loginSuccessful();
    }

    @When("I add two items that I want to buy")
    public void iAddItemsThatIWantToBuy() {
        var productPageController = new ProductPageController(driver);
        productPageController.addTwoItems();
    }

    @Then("the shopping cart counter is two")
    public void theShoppingCartCounterIs() {
        var productPageController = new ProductPageController(driver);
        productPageController.compareTotalItems("2");
        manager.teardown();
    }

    @When("I add six items to the shopping cart and remove one")
    public void iAddItemsToTheShoppingCartAndRemoveOne() {
        var productPageController = new ProductPageController(driver);
        productPageController.addAllItems();
    }

    @Then("The shopping cart counter should be five and only five items should appear inside it")
    public void theShoppingCartCounterShouldBeAndOnlyItemsShouldAppearInsideIt() {
        var productPageController = new ProductPageController(driver);
        productPageController.compareTotalItems("5");
    manager.teardown();
    }

    @When("I add the item to the shopping cart")
    public void iAddTheItemToTheShoppingCart() {
        var productPageController = new ProductPageController(driver);
        productPageController.checkAddCartItems();
    }

    @Then("I can see the same product that I select in the shopping cart")
    public void iCanSeeTheSameProductThatISelectInTheShoppingCart() {
        var productPageController = new ProductPageController(driver);
        productPageController.checkSameProducts();
        manager.teardown();
        LOGGER.info("browser closed, driver removed CartAppend class");
    }
}
