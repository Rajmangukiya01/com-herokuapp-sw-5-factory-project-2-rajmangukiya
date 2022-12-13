package com.herokuapp.internet.pages;

import com.herokuapp.internet.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class LoginPage extends Utility {

    @CacheLookup
    @FindBy(name = "username")
    WebElement username;

    @CacheLookup
    @FindBy(name = "password")
    WebElement password;

    @CacheLookup
    @FindBy(xpath = "//i[contains(@class,'fa fa-2x')]")
    WebElement loginButton;

    @CacheLookup
    @FindBy(xpath = "//body[1]/div[2]/div[1]/div[1]/h2[1]")
    WebElement secureAreaText;

    @CacheLookup
    @FindBy(xpath = "//div[@class='flash error']")
    WebElement invalidUsername;

    @CacheLookup
    @FindBy(id = "flash")
    WebElement invalidPassword;


    public void enterUsername(String text) {
        Reporter.log("Enter username " + username.toString());
        sendTextToElement(username, text);
    }

    public void enterPassword(String text) {
        Reporter.log("Enter password " + password.toString());
        sendTextToElement(password, text);
    }

    public void clickOnLoginButton() {
        Reporter.log("Click on login button" + loginButton.toString());
        clickOnElement(loginButton);
    }

    public String getSecureAreaText() {
        Reporter.log("Get Secure area text" + secureAreaText.toString());
        return getTextFromElement(secureAreaText);
    }

    public String getInvalidUsernameText() {
        Reporter.log("Get invalid username text" + invalidUsername.toString());
        return getTextFromElement(invalidUsername);
    }

    public String getInvalidPasswordText() {
        Reporter.log("Get invalid password text" + invalidPassword.toString());
        return getTextFromElement(invalidPassword);
    }
}
