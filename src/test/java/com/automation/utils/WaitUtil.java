package com.automation.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WaitUtil {

    WebDriverWait wait;

    public WaitUtil(WebDriver driver){
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }
    public WebElement waitForVisible(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public WebElement waitForClickable(By locator){
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public List<WebElement> waitForAllVisible(By locator){
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

}
