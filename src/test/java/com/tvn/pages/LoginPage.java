package com.tvn.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.How;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        visit("https://the-internet.herokuapp.com/login");
    }

    public void submitCredentials(String username, String password) {
        fill(By.id("username"),username);
        fill(By.id("password"),password);
        click(By.cssSelector("button[type=submit]"));
    }

    public String getFlashMessage() {
        return text(How.ID,"flash-messages");
    }

    public boolean isErrorMessageDisplayed() {
        return isDisplayed(How.CLASS_NAME,"error");
    }

}
