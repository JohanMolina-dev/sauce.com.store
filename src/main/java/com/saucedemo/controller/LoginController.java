package com.saucedemo.controller;

import com.github.javafaker.Faker;
import com.saucedemo.pages.LoginPage;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginController {
    WebDriver driver;
    Faker faker = new Faker();
    String email = faker.internet().emailAddress();
    String password = faker.internet().password(2,12);
    public LoginController(WebDriver driver) {
        this.driver = driver;
    }


    public void loginSuccessful(){
        var loginPage = new LoginPage(driver);
        loginPage.inputUserName("standard_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickButtonLogin();
    }
    public void loginWithUserBlocked(){
        var loginPage = new LoginPage(driver);
        loginPage.inputUserName("locked_out_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickButtonLogin();
    }
    public void loginFailInvalidUSer(){
        var loginPage = new LoginPage(driver);
        loginPage.inputUserName(email);
        loginPage.inputPassword(password);
        loginPage.clickButtonLogin();
    }
    public String alert(){
        var loginPage = new LoginPage(driver);
        return loginPage.getAlertUserBlock();
    }
    public void logOut(){
        var loginPage = new LoginPage(driver);
        loginPage.clickBurgerMenu();
        loginPage.clickLogout();
    }
    public void assertAlerts(String message){
        assertEquals(message,alert());
    }




}
