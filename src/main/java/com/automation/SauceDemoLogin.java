package com.automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SauceDemoLogin {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();

        options.addArguments("--disable-notifications");
        options.addArguments("--disable-save-password-bubble");

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);

        options.setExperimentalOption("prefs", prefs);

        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        String Title = driver.getTitle();
        System.out.println("Title is : " +Title);
        if (driver.getTitle().equals(Title)){
            System.out.println("Title is correct");
        }

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        Thread.sleep(300);

        Thread.sleep(30);

        driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']/following-sibling::div//button")).click();

        /*String productName = "Sauce Labs Fleece Jacket";

        WebElement product = driver.findElement(By.xpath("//div[text()='"+productName+"']/ancestor::div[@class='inventory_item']//button"));
        System.out.println(product.getText());
        product.click();

        String price = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']/ancestor::div[@class='inventory_item']//div[@class='inventory_item_price']")).getText();
        System.out.println(price);

        List<WebElement> buttons = driver.findElements(By.xpath("//button[text()='Add to cart']"));
        System.out.println(buttons.size());

        for ( WebElement btn : buttons){
            btn.click();
        }

        Thread.sleep(50);

        List<WebElement> names = driver.findElements(By.xpath("//div[@class='inventory_item_name ']"));
        for(WebElement name: names){
            System.out.println(name.getText());
        }*/




    }
}
