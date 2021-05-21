package com.saucedemo.controller;

import com.saucedemo.dto.CustomerDto;
import com.saucedemo.pages.CheckoutPage;
import db.Mapping;
import org.openqa.selenium.WebDriver;

import java.util.List;

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

    public String getUserNameDb(){
        Mapping mapping = new Mapping();
        List<CustomerDto> customerDtoList = mapping.createDTO();
        String username;
        return username = customerDtoList.get(2).getUserName();

    }
    public String getLastNameDb(){
        Mapping mapping = new Mapping();
        List<CustomerDto> customerDtoList = mapping.createDTO();
        String user_lastname;
        return user_lastname = customerDtoList.get(2).getUserLastName();

    }
    public String getZipCodeDb(){
        Mapping mapping = new Mapping();
        List<CustomerDto> customerDtoList = mapping.createDTO();
        String user_zipcode;
        return user_zipcode = customerDtoList.get(2).getUserZipCode();
    }
}
