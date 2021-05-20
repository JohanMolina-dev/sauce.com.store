package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class ProductPage {
    private WebDriver driver;
    //Btn add item
    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement btnBackpack;
    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    WebElement btnBikeLight;
    @FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
    WebElement btnBoltTShirt;
    @FindBy(id = "add-to-cart-sauce-labs-fleece-jacket")
    WebElement btnJacket;
    @FindBy(id = "add-to-cart-sauce-labs-onesie")
    WebElement btnOnesie;
    @FindBy(id = "add-to-cart-test.allthethings()-t-shirt-(red)")
    WebElement btnTShirtRed;
    //Btn Remove item
    @FindBy(id = "remove-sauce-labs-backpack")
    WebElement removeBackpack;
    @FindBy(id = "remove-sauce-labs-bike-light")
    WebElement removeBikeLight;
    @FindBy(id = "remove-sauce-labs-bolt-t-shirt")
    WebElement removeBoltTShirt;
    @FindBy(id = "remove-sauce-labs-fleece-jacket")
    WebElement removeJacket;
    @FindBy(id = "remove-sauce-labs-onesie")
    WebElement removeOnesie;
    @FindBy(id = "remove-test.allthethings()-t-shirt-(red)")
    WebElement removeTShirtRed;
    //Counter
    @FindBy(css = "div#shopping_cart_container span")
    WebElement counterCartShopping;
    //Links
    @FindBy(linkText = "Sauce Labs Backpack")
    WebElement linkSauceLabsBackpack;
    @FindBy(linkText = "Sauce Labs Bike Light")
    WebElement linkSauceLabsBikeLight;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    //Methods append items
    public void addBackpack(){
        btnBackpack.click();

    }
    public void addBikeLight(){
        btnBikeLight.click();
    }
    public void addBoltTShirt(){
        btnBoltTShirt.click();
    }
    public void addJacket(){
        btnJacket.click();
    }
    public void addOnesie (){
        btnOnesie.click();
    }
    public void addTShirtRed(){
        btnTShirtRed.click();
    }

    //Methods Remove items
    public void suppressBackpack(){
        removeBackpack.click();

    }
    public void suppressBikeLight(){
        removeBikeLight.click();
    }
    public void suppressBoltTShirt(){
        removeBoltTShirt.click();
    }
    public void suppressJacket(){
        removeJacket.click();
    }
    public void suppressOnesie (){
        removeOnesie.click();
    }
    public void suppressTShirtRed(){
        removeTShirtRed.click();
    }
    public String getCounterText(){
        return counterCartShopping.getText();
    }
    public String getLinkTextBackPack(){
        return linkSauceLabsBackpack.getText();
    }
    public String getLinkTextBikeLight(){
        return linkSauceLabsBikeLight.getText();
    }
    public void intoCartShopping(){
        counterCartShopping.click();
    }


}

