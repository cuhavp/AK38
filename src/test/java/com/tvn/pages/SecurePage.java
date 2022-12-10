package com.tvn.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecurePage extends BasePage{
    public SecurePage(WebDriver driver) {
        super(driver);
    }

    public String getFlashMessage(){
        return driver.findElement(By.id("flash-messages")).getText();
    }
    public boolean isSuccessMessageDisplayed(){
        return driver.findElement(By.className("success")).isDisplayed();
    }

    @Override
    public void open() {
        driver.get("https://the-internet.herokuapp.com/secure");
    }
}
