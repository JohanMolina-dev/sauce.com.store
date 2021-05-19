package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class HomePage {
    WebDriver driver;
    @FindBy(className = "inventory_item_img")
    List<WebElement> elemtentos;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> listaEl(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfAllElements(elemtentos));
        List<WebElement> elements = new ArrayList<>();
        for (int i = 0; i < elemtentos.size(); i++ ){
        elements.add(elemtentos.get(i));
        }
        return elements;
}

}
