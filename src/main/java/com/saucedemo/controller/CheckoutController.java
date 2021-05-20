package com.saucedemo.controller;

import com.saucedemo.pages.CheckoutPage;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckoutController {
    private WebDriver driver;

    public CheckoutController(WebDriver driver) {
        this.driver = driver;
    }

    public void sendInputFieldWithOutZipCode(){
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.clickCart();
        checkoutPage.clickCheckout();
        checkoutPage.sendMyInfo("Johan","Molina","");
    }
    public void checkAlertError(){
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        assertEquals("Error: Postal Code is required",checkoutPage.getErrorAlert());
    }
    public void sendInputFieldWrongOutZipCode(){
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.clickCart();
        checkoutPage.clickCheckout();
        checkoutPage.sendMyInfo("Johan","Molina","02");
    }
    public void submitMyCorrectInformation(){
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.clickCart();
        checkoutPage.clickCheckout();
        checkoutPage.sendMyInfo("Johan","Molina", "110111");
    }
    public void checkTransaction(){
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        assertEquals("Total: $129.55", checkoutPage.getTotal());
        checkoutPage.clickBtnFinish();
        assertEquals("THANK YOU FOR YOUR ORDER", checkoutPage.getMessage());
    }

}
