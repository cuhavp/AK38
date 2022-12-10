package com.tvn.elements;

import com.tvn.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoadingTest extends BaseTest {
    @BeforeMethod
    void navigateToPage(){
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
    }

    @Test
    void waitForLoading() {
        wait.until(ExpectedConditions
                        .elementToBeClickable(
                                By.xpath("//button[text()='Start']")))
                .click();

        String result = wait.until(ExpectedConditions
                        .visibilityOfElementLocated(
                                By.id("finish")))
                .getText();
        Assert.assertEquals(result, "Hello World!");
    }
}