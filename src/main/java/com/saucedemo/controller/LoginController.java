package com.saucedemo.controller;

import com.saucedemo.pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class LoginController {
    WebDriver driver;

    public LoginController(WebDriver driver) {
        this.driver = driver;
    }


    public void loginSuccessful(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputUserName("standard_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickButtonLogin();
    }
    public void loginWithUserBlocked(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputUserName("locked_out_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickButtonLogin();
    }
    public void loginFailInvalidUSer(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputUserName("js@mail.com");
        loginPage.inputPassword("123456789");
        loginPage.clickButtonLogin();
    }
    public String alert(){
        LoginPage loginPage = new LoginPage(driver);
        return loginPage.getAlertUserBlock();
    }
    public void logOut(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickBurgerMenu();
        loginPage.clickLogout();
    }

}
