package com.saucedemo.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartAppendStep {
    @Given("I am a user with a correct Login and I am on the products page")
    public void iAmAUserWithACorrectLoginAndIAmOnTheProductsPage() {

    }

    @When("I add {int} items that I want to buy")
    public void iAddItemsThatIWantToBuy(Integer int1) {

    }

    @Then("the shopping cart counter is {int}")
    public void theShoppingCartCounterIs(Integer int1) {

    }

    @When("I add {int} items to the shopping cart and remove one")
    public void iAddItemsToTheShoppingCartAndRemoveOne(Integer int1) {

    }

    @Then("The shopping cart counter should be {int} and only {int} items should appear inside it")
    public void theShoppingCartCounterShouldBeAndOnlyItemsShouldAppearInsideIt(Integer int1, Integer int2) {

    }

    @When("I add the item to the shopping cart")
    public void iAddTheItemToTheShoppingCart() {

    }

    @Then("I can see the same product that I select in the shopping cart")
    public void iCanSeeTheSameProductThatISelectInTheShoppingCart() {

    }
}
