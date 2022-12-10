package com.tvn.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropDownTest {

    /*
    Open browser
    Navigate to https://the-internet.herokuapp.com/dropdown
    Select “option 1”
    Validate “option 1” is selected

     */
    @Test
    void validateOption1IsSelected(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dropdown");

        Select select = new Select(driver.findElement(By.id("dropdown")));
        
        select.selectByIndex(1);

        Assert.assertTrue(driver.findElement(By.xpath("//option[text()='Option 1']")).isSelected());
    }

    @Test
    void multipleSelect() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://output.jsbin.com/osebed/2");
        Select fruits = new Select(driver.findElement(By.id("fruits")));
        Assert.assertTrue(fruits.isMultiple());
        fruits.selectByVisibleText("Banana");
        fruits.selectByVisibleText("Orange");
        Thread.sleep(5000);
        fruits.deselectByVisibleText("Banana");

        Thread.sleep(5000);

    }
}
