package com.automation.pages;

import com.automation.utils.WaitUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AppLauncherPage {

    WebDriver driver;
    WaitUtil wait;

    By appLauncher = By.xpath("//button[@title='App Launcher']");
    By viewAll = By.xpath("//button[text()='View All']");
    By search = By.xpath("//input[@placeholder='Search apps or items...']");
    By salesConsole = By.xpath("//one-app-launcher-app-tile//a//p[normalize-space()='Sales Console']");

    public AppLauncherPage(WebDriver driver){
        this.driver = driver;
        wait = new WaitUtil(driver);
    }

    public void openSalesConsole(){
        wait.waitForClickable(appLauncher).click();
        wait.waitForClickable(viewAll).click();
        WebElement searchbar = wait.waitForVisible(search);
        searchbar.sendKeys("Sales");
        wait.waitForClickable(salesConsole).click();

    }

}
