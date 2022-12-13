package com.herokuapp.internet.testsuite;

import com.herokuapp.internet.pages.LoginPage;
import com.herokuapp.internet.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {
    LoginPage loginPage;

    @BeforeMethod(alwaysRun = true)
    public void init() {
        loginPage = new LoginPage();
    }

    @Test(groups = {"sanity","regression"})
    public void UserShouldLoginSuccessfullyWithValidCredentials() {
        loginPage.enterUsername("tomsmith");
        loginPage.enterPassword("SuperSecretPassword!");
        loginPage.clickOnLoginButton();
        String expectedText = "Secure Area";
        Assert.assertEquals(loginPage.getSecureAreaText(), expectedText, "Secure area text is not displayed");
    }

    @Test(groups = {"smoke","regression"})
    public void verifyTheUsernameErrorMessage() {
        loginPage.enterUsername("tomsmith1");
        loginPage.enterPassword("SuperSecretPassword!");
        loginPage.clickOnLoginButton();
        String expectedText = "Your username is invalid!\n" +
                "×";
        Assert.assertEquals(loginPage.getInvalidUsernameText(), expectedText, "Username error message is not displayed");
    }

    @Test(groups = {"regression"})
    public void verifyThePasswordErrorMessage() {
        loginPage.enterUsername("tomsmith");
        loginPage.enterPassword("SuperSecretPassword");
        loginPage.clickOnLoginButton();
        String expectedText = "Your password is invalid!\n" +
                "×";
        Assert.assertEquals(loginPage.getInvalidPasswordText(), expectedText, "Password error message is not displayed");
    }
}
