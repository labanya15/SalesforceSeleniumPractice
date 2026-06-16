package com.automation.pages;

import com.automation.utils.WaitUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CommonPage {
    WebDriver driver;
    WaitUtil wait;

    By profileIcon = By.xpath("//div[contains(@class,'profileTrigger')]");
    By logoutBtn = By.cssSelector("a[class*='logout']");


    public CommonPage(WebDriver driver){
        this.driver=driver;
        wait=new WaitUtil(driver);
    }
    public void logOut(){
        wait.waitForClickable(profileIcon).click();
        wait.waitForClickable(logoutBtn).click();

    }
}
