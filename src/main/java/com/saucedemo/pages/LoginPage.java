package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class LoginPage {
    @FindBy(id = "user-name")
    WebElement fieldUserName;
    @FindBy(id="password")
    WebElement fieldPassword;
    @FindBy (css ="input#login-button")
    WebElement btnLogin;
    @FindBy (css="div#login_button_container h3")
    WebElement alertUserBlock;
    @FindBy (id = "react-burger-menu-btn")
    WebElement burgerMenu;
    @FindBy(linkText = "LOGOUT")
    WebElement logout;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    public void inputUserName(String pUserName){
        fieldUserName.sendKeys(pUserName);
    }
    public void inputPassword(String pPassword){
        fieldPassword.sendKeys(pPassword);
    }
    public void clickButtonLogin(){
        btnLogin.click();
    }
    public String getAlertUserBlock(){
        return alertUserBlock.getText();
    }
    public void clickBurgerMenu(){
        burgerMenu.click();
    }
    public void clickLogout(){
        logout.click();
    }


}
