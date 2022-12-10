package com.tvn.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenSafariBrowserTest {
    @Test
    void openSeleniumHomePage() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://selenium.dev");
        Assert.assertEquals(driver.getTitle(),"Selenium");
        driver.quit();
    }
}
