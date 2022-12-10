package com.tvn.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxTest {
    /**
     * Open browser
     * Navigate to https://the-internet.herokuapp.com/checkboxes
     * Check on “checkbox1”
     * Verify “checkbox1” is checked
     * Check on “checkbox2”
     * Verify “checkbox2” is checked
     */

    @Test
    void verifyCheckBoxIsSelected(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        String locator = "//input[@type='checkbox'][%d]";

        check(driver.findElement(By.xpath(String.format(locator,1))));
        Assert.assertTrue(driver.findElement(By.xpath(String.format(locator,1))).isSelected());

        check(driver.findElement(By.xpath(String.format(locator,2))));
        Assert.assertTrue(driver.findElement(By.xpath(String.format(locator,2))).isSelected());
    }

    //Single RESPONSIBILITY >> SELENIUM OWNER METHODS
    private static void check(WebElement element){
        if(!element.isSelected()){
            element.click();
        }
    }

    private static void uncheck(WebElement element){
        if(element.isSelected()){
            element.click();
        }
    }
}
