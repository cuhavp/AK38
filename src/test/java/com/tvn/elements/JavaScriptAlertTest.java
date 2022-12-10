package com.tvn.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JavaScriptAlertTest {
    WebDriver driver;

    @BeforeMethod
    void setUp() {
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @BeforeTest
    void beforeTest(){
        System.out.println("===================");
        System.out.println("BEFORE TEST");
        System.out.println("===================");
    }

    @Test
    void clickForJSAlert() {
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        driver.switchTo().alert().accept();

        String result = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(result, "You successfully clicked an alert");
    }

    @Test
    void clickForJSDismiss() {
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        driver.switchTo().alert().dismiss();

        String result = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(result, "You clicked: Cancel");
    }

    @Test
    void clickForJSPrompt() {
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();

        driver.switchTo().alert().sendKeys("hello JS Alert");
        driver.switchTo().alert().accept();

        String result = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(result, "You entered: hello JS Alert");
    }

    @AfterMethod
    void tearDown() {
        driver.quit();
    }
}