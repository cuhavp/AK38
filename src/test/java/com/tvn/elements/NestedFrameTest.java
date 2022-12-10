package com.tvn.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NestedFrameTest {
    WebDriver driver;

    @BeforeClass
    void setUp(){
        driver = new ChromeDriver(); // origin
        driver.get("https://the-internet.herokuapp.com/nested_frames");
    }

    @BeforeMethod
    void backToOriginContent(){
        driver.switchTo().defaultContent(); // back to origin
    }

    @Test
    void validateTextPresentOnLeftFrame(){
        driver.switchTo().frame("frame-top"); // frame-top
        driver.switchTo().frame("frame-left"); // frame-left
        String content = driver.findElement(By.xpath("html/body")).getText();
        Assert.assertEquals(content,"LEFT");
    }

    @Test
    void validateTextPresentOnMiddleFrame(){
        driver.switchTo().frame("frame-top"); // frame-top
        driver.switchTo().frame("frame-middle"); //frame-middle
        String content = driver.findElement(By.id("content")).getText();
        Assert.assertEquals(content,"MIDDLE");
    }

    @Test
    void validateTextPresentOnRightFrame(){
        driver.switchTo().frame("frame-top"); // frame-top
        driver.switchTo().frame("frame-right"); // frame-right
        String content = driver.findElement(By.xpath("html/body")).getText();
        Assert.assertEquals(content,"RIGHT");
    }

    @Test
    void validateTextPresentOnBottomFrame(){
        driver.switchTo().frame("frame-bottom"); // frame-bottom
        String content = driver.findElement(By.xpath("html/body")).getText();
        Assert.assertEquals(content,"BOTTOM");
    }

    @AfterClass
    void tearDown(){
        driver.quit();
    }
}
