package com.saucedemo.controller;

import com.saucedemo.pages.ProductPage;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductPageController {
    WebDriver driver;

    public ProductPageController(WebDriver driver) {
        this.driver = driver;
    }
    public void addAllItems(){
        var productPage = new ProductPage(driver);
        productPage.addJacket();
        productPage.addOnesie();
        productPage.addBoltTShirt();
        productPage.addBackpack();
        productPage.addTShirtRed();
        productPage.addBikeLight();
        productPage.suppressBikeLight();
    }
    public void addTwoItems(){
        var productPage = new ProductPage(driver);
        productPage.addBackpack();
        productPage.addBikeLight();
    }
    public void compareTotalItems(String expected){
        var productPage = new ProductPage(driver);
        assertEquals(expected, productPage.getCounterText());
    }
    public void checkAddCartItems(){
        var productPage = new ProductPage(driver);
        productPage.addBackpack();
        productPage.addBikeLight();

    }
    public void checkSameProducts(){
        var productPage = new ProductPage(driver);
        productPage.intoCartShopping();
        assertEquals("Sauce Labs Bike Light",productPage.getLinkTextBikeLight());
        assertEquals("Sauce Labs Backpack",productPage.getLinkTextBackPack());
    }
}
