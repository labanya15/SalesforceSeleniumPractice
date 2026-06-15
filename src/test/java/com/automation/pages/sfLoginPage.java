package com.automation.pages;

import com.automation.utils.WaitUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class sfLoginPage {

    WebDriver driver;
    WaitUtil wait;

    By username = By.cssSelector("input[id='username']");
    By password = By.id("password");
    By loginBtn = By.xpath("//input[@name='Login']");

    public sfLoginPage(WebDriver driver){
        this.driver=driver;
        wait = new WaitUtil(driver);
    }
    public void login(String user, String pass){
        driver.findElement(username).clear();
        driver.findElement(username).sendKeys("labanyahota15.14aaa31f1437@agentforce.com");
        driver.findElement(password).clear();
        driver.findElement(password).sendKeys("Test@123");
        driver.findElement(loginBtn).click();

    }

}
