package com.saucedemo.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class HomePage {
    WebDriver driver;
    @FindBy(className = "inventory_item_img")
    List<WebElement> elementos;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> listaEl(){
        var wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfAllElements(elementos));
        List<WebElement> elements = new ArrayList<>();
        for (int i = 0; i < elementos.size(); i++ ){
        elements.add(elementos.get(i));
        }
        return elements;
}

}
