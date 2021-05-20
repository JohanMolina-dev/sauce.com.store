package com.saucedemo.manager_conection;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Manager {
    private WebDriver driver;

    public Manager(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver selectBrowser(String browser, String version) {

        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().driverVersion(version).setup();
            return driver = new ChromeDriver();

        } else {
            WebDriverManager.firefoxdriver().driverVersion(version).setup();
            return driver = new FirefoxDriver();
        }
    }
    public void teardown(){
        driver.quit();
    }
}
