package com.mmtest.pages;

import com.mmtest.utilities.Action;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommonPage extends BasePage {

    @FindBy(className = "logo")
    WebElement logo;

    @FindBy(xpath = "//a[@class='action showcart']")
    WebElement cart;

    @FindBy(xpath = "//a[@class='subtitle empty']")
    WebElement cartEmpty;

    @FindBy(className = "counter-number")
    WebElement cartCount;

    @FindBy(id = "search")
    WebElement searchField;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement searchButton;

    @FindBy(linkText = "Sign In")
    WebElement signInLink;

    @FindBy(linkText = "Create an Account")
    WebElement createAccountLink;

    CommonPage(WebDriver driver) {
        super(driver);
    }

    public HomePage clickOnLogo() {
        action.click(logo);
        return new HomePage(driver);
    }

    public LoginPage clickOnSignIn() {
        action.click(signInLink);
        return new LoginPage(driver);
    }

    public CreateNewAccountPage clickOnCreateAccount() {
        action.click(createAccountLink);
        return new CreateNewAccountPage(driver);
    }

}
