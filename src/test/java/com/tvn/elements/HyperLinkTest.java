package com.tvn.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HyperLinkTest {

    @Test
    void hyperLinkTest()
    {
        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/status_codes");

        driver.findElement(By.xpath("//a[@href='status_codes/200']")).click();
        String message = driver.findElement(By.className("example")).getText();
        Assert.assertTrue(message.contains("This page returned a 200 status code."));
        driver.navigate().back();

        driver.findElement(By.linkText("301")).click();
        String message2 = driver.findElement(By.className("example")).getText();
        Assert.assertTrue(message2.contains("This page returned a 301 status code."));
        driver.navigate().back();

        driver.findElement(By.linkText("404")).click();
        String message3 = driver.findElement(By.className("example")).getText();
        Assert.assertTrue(message3.contains("This page returned a 404 status code."));
        driver.navigate().back();

        driver.findElement(By.linkText("500")).click();
        String message4 = driver.findElement(By.className("example")).getText();
        Assert.assertTrue(message4.contains("This page returned a 500 status code."));
        driver.navigate().back();
    }
}

