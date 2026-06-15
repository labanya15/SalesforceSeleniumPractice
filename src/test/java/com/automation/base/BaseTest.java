package com.automation.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public void setUp(){

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--user-data-dir=C:\\Automation\\chrome-profile");
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-save-password-bubble");
        options.addArguments("--disable-infobars");

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        driver.get("https://orgfarm-e28db64dfe-dev-ed.develop.lightning.force.com/lightning/n/devedapp__Welcome");

    }
    public void tearDown(){
        driver.quit();
    }
}
