package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class CheckoutPage {
    @FindBy (css = "div#shopping_cart_container > a")
    WebElement cartShopping;
    @FindBy (id = "checkout")
    WebElement btnCheckout;
    @FindBy (id = "first-name")
    WebElement fieldFirstName;
    @FindBy (id = "last-name")
    WebElement fieldLastName;
    @FindBy (id = "postal-code")
    WebElement fieldZipCode;
    @FindBy (id = "continue")
    WebElement btnContinue;
    @FindBy (css = "div#checkout_summary_container div.summary_total_label")
    WebElement total;
    @FindBy(id = "finish")
    WebElement btnFinish;
    @FindBy(css = "div#checkout_complete_container > h2")
    WebElement displayMessage;
    @FindBy(css = "div#checkout_info_container h3")
    WebElement alertZipCode;

    public CheckoutPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void clickCart(){
        cartShopping.click();
    }
    public void clickCheckout(){
        btnCheckout.click();
    }
    public void sendMyInfo(String firstName, String lastName, String zipCode){
        fieldFirstName.sendKeys(firstName);
        fieldLastName.sendKeys(lastName);
        fieldZipCode.sendKeys(zipCode);
        btnContinue.click();
    }
    public String getTotal(){
        return total.getText();
    }
    public void clickBtnFinish(){
        btnFinish.click();
    }
    public String getMessage(){
        return displayMessage.getText();
    }
    public String getErrorAlert(){
        return alertZipCode.getText();
    }


}
