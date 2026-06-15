package com.automation.pages;

import com.automation.utils.WaitUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

public class AccountPage {
    WebDriver driver;
    WaitUtil wait;

    By navMenu = By.cssSelector("button[title='Show Navigation Menu']");
    By menuItem = By.cssSelector("a[role='menuitem']");
    By newBtn = By.xpath("//a[@title='New']");
    By accName = By.xpath("//div[@class='slds-template__container']//input[@name='Name']");
    By saveBtn = By.xpath("//button[text()='Save' and @name='SaveEdit']");

    public AccountPage(WebDriver driver){
        this.driver=driver;
        wait = new WaitUtil(driver);
    }
    public void openAccounts(){
        driver.findElement(navMenu).click();

        String objectName = "Accounts";

        List<WebElement> navItems = wait.waitForAllVisible(menuItem);

        for (WebElement item : navItems){
            String objectLabel = item.getAttribute("data-label");

            if (objectLabel.equals(objectName)){
                item.click();
                break;
            }
        }
    }
    public String createAccount(){
        wait.waitForVisible(newBtn).click();
        WebElement accountNameField = wait.waitForClickable(accName);
        Random rand = new Random();
        int randomNum = rand.nextInt(10000);
        accountNameField.sendKeys("TestAccount"+randomNum);
        wait.waitForClickable(saveBtn).click();

        wait.waitForClickable(By.xpath("//ul[@class='slds-tabs_default__nav']//li[@title='Details']")).click();
        WebElement accountNameValue = wait.waitForVisible(By.xpath("//records-record-layout-item[@field-label='Account Name']//lightning-formatted-text[@slot='outputField']"));
        String accNameText = accountNameValue.getText();
        System.out.println(accNameText);

        

        return accNameText;

    }
    public boolean verifyAccountInList(String accNameText){
        openAccounts();
        WebElement accountSearchbar = wait.waitForClickable(By.xpath("//input[@type='search' and @name='Account-search-input']"));
        accountSearchbar.sendKeys(accNameText);
        accountSearchbar.sendKeys(Keys.ENTER);

        WebElement accVisible = wait.waitForVisible(By.xpath("//table//tr//th[@data-label='Account Name']//a[@title='"+accNameText+"']"));
        System.out.println(accNameText.equals(accVisible.getAttribute("title")));

        return accVisible.isDisplayed();

    }
}
