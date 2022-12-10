package com.tvn.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class GoogleSearchTest {

    //TODO: Explore search text box properties
    /*
        1. Tag name:input (OK)
        2. Attributes:
               name = q (ok)
               title = Tìm kiếm (ok)
               aria-label = tìm kiếm
        3. Text :N/A
     */
    @Test
    void searchBoxShouldBeReturn(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com.vn");

        // name -> tag name > css > xpath
        driver.findElement(By.name("q")).sendKeys("selenium");
        driver.findElement(By.tagName("input")).sendKeys("selenium");
        driver.findElement(By.cssSelector("input")).sendKeys("selenium");
        driver.findElement(By.cssSelector("[name=q]")).sendKeys("selenium");
        driver.findElement(By.cssSelector("input[name=q]")).sendKeys("selenium");
        driver.findElement(By.cssSelector("[title=Search]")).sendKeys("selenium");
        driver.findElement(By.xpath("//input")).sendKeys("selenium");
        driver.findElement(By.cssSelector("[aria-label=Search]")).sendKeys("selenium");
        driver.findElement(By.cssSelector("input[title=Search]")).sendKeys("selenium");
        driver.findElement(By.xpath("//*[@name='q']")).sendKeys("selenium");
        driver.findElement(By.cssSelector("input[aria-label=Search]")).sendKeys("selenium");
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("selenium");
        driver.findElement(By.xpath("//*[@title='Search']")).sendKeys("selenium");
        driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("selenium");
        driver.findElement(By.xpath("//*[@aria-label='Search']")).sendKeys("selenium");
        driver.findElement(By.xpath("//*[@aria-label='Search']")).sendKeys("selenium");
        driver.findElement(By.xpath("//input[@aria-label='Search']")).sendKeys("selenium");
        driver.findElement(By.xpath("//*[contains(@title,'Search')]")).sendKeys("selenium");
        driver.findElement(By.xpath("//input[contains(@title,'Search')]")).sendKeys("selenium");


    }

}
