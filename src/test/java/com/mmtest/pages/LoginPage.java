package com.mmtest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends CommonPage {

    @FindBy(id = "email")
    WebElement emailField;

    @FindBy(id = "pass")
    WebElement passwordField;

    @FindBy(xpath = "//button[@class='action login primary']")
    WebElement signInButton;

    @FindBy(xpath = "//a[@class='action remind']")
    WebElement forgotPasswordLink;

    @FindBy(xpath = "//button[@class='action create primary']")
    WebElement createAccountButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterEmail(String email) {
        action.input(emailField, email);
    }

    public void enterPassword(String password) {
        action.input(passwordField, password);
    }
}
