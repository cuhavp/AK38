package com.tvn.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenFirefoxBrowserTest {
    @Test
    void openSeleniumHomePage() {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://selenium.dev");
        Assert.assertEquals(driver.getTitle(),"Selenium");
        driver.quit();
    }

    @Test
    void openSeleniumHomePageInHeadlessMode(){

        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setHeadless(true);

        WebDriver driver = new FirefoxDriver(firefoxOptions);

        driver.get("https://selenium.dev");
        Assert.assertEquals(driver.getTitle(),"Selenium");
        driver.quit();
    }
}
