package com.saucedemo.controller;

import com.github.javafaker.Faker;
import com.saucedemo.dto.CustomerDto;
import com.saucedemo.pages.CheckoutPage;
import db.Mapping;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckoutController {
    private final WebDriver driver;
    Faker faker = new Faker();
    String nameUser = faker.name().firstName();
    String lastnameUser = faker.name().lastName();
    String zipCode = faker.address().zipCode();


    public CheckoutController(WebDriver driver) {
        this.driver = driver;
    }

    public void sendInputFieldWithOutZipCode(){
        var checkoutPage = new CheckoutPage(driver);
        checkoutPage.clickCart();
        checkoutPage.clickCheckout();
        checkoutPage.sendMyInfo(nameUser,lastnameUser,"");
    }
    public void checkAlertError(){
        var checkoutPage = new CheckoutPage(driver);
        assertEquals("Error: Postal Code is required",checkoutPage.getErrorAlert());
    }
    public void sendInputFieldWrongOutZipCode(){
        var checkoutPage = new CheckoutPage(driver);
        checkoutPage.clickCart();
        checkoutPage.clickCheckout();
        checkoutPage.sendMyInfo(nameUser,lastnameUser,"02");
    }
    public void submitMyCorrectInformation(){
        var checkoutPage = new CheckoutPage(driver);
        checkoutPage.clickCart();
        checkoutPage.clickCheckout();
        checkoutPage.sendMyInfo(nameUser,lastnameUser, zipCode);
    }
    public void checkTransaction(){
        var checkoutPage = new CheckoutPage(driver);
        assertEquals("Total: $129.55", checkoutPage.getTotal());
        checkoutPage.clickBtnFinish();
        assertEquals("THANK YOU FOR YOUR ORDER", checkoutPage.getMessage());
    }

    public String getUserNameDb(){
        var mapping = new Mapping();
        List<CustomerDto> customerDtoList = mapping.createDTO();
        String username;
        return username = customerDtoList.get(2).getUserName();

    }
    public String getLastNameDb(){
        var mapping = new Mapping();
        List<CustomerDto> customerDtoList = mapping.createDTO();
        String user_lastname;
        return user_lastname = customerDtoList.get(2).getUserLastName();

    }
    public String getZipCodeDb(){
        var mapping = new Mapping();
        List<CustomerDto> customerDtoList = mapping.createDTO();
        String user_zipcode;
        return user_zipcode = customerDtoList.get(2).getUserZipCode();
    }
}
