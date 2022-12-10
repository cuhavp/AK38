package com.tvn.elements;

import com.tvn.BaseTest;
import com.tvn.pages.LoginPage;
import com.tvn.pages.SecurePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    LoginPage loginPage;

    @BeforeMethod
    void init() {
        loginPage = new LoginPage(driver);
        loginPage.open();
    }

    @Test
    void successfullyWithValidCredentials() {
        loginPage.submitCredentials("tomsmith", "SuperSecretPassword!");

        SecurePage securePage = new SecurePage(driver);
        Assert.assertEquals(securePage.getCurrentUrl(), "https://the-internet.herokuapp.com/secure");
        String message = securePage.getFlashMessage();
        Assert.assertTrue(message.contains("You logged into a secure area!"));
        Assert.assertTrue(securePage.isSuccessMessageDisplayed());
    }

    @Test
    void errorWithInvalidPassword() {
        loginPage.submitCredentials("tomsmith", "SuperSecretPassword");

        Assert.assertEquals(loginPage.getCurrentUrl(), "https://the-internet.herokuapp.com/login");
        String message = loginPage.getFlashMessage();
        Assert.assertTrue(message.contains("Your password is invalid!"));
        Assert.assertTrue(loginPage.isErrorMessageDisplayed());
    }

    @Test
    void errorWithInvalidUsername() {
        loginPage.submitCredentials("toms", "SuperSecretPassword!");
        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/login");
        String message = loginPage.getFlashMessage();
        Assert.assertTrue(message.contains("Your username is invalid!"));
        Assert.assertTrue(loginPage.isErrorMessageDisplayed());
    }

}
