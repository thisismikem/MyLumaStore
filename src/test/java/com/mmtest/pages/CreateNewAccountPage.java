package com.mmtest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateNewAccountPage extends CommonPage {

    @FindBy(id = "firstname")
    WebElement firstNameField;

    @FindBy(id = "firstname-error")
    WebElement firstNameErrorMessage;

    @FindBy(id = "lastname")
    WebElement lastNameField;

    @FindBy(id = "email_address")
    WebElement emailField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(id = "password-confirmation")
    WebElement confirmPasswordField;

    @FindBy(xpath = "//button[@class='action submit primary']")
    WebElement createAccountButton;

    @FindBy(id = "password-error")
    WebElement passwordErrorMessage;

    @FindBy(id = "password-confirmation-error")
    WebElement passwordConfirmationErrorMessage;

    public CreateNewAccountPage(WebDriver driver) {
        super(driver);
    }

    public void enterFirstName(String firstName) {
        action.input(firstNameField, firstName);
    }

    public void enterLastName(String lastName) {
        action.input(lastNameField, lastName);
    }

    public void enterEmail(String email) {
        action.input(emailField, email);
    }

    public void enterPassword(String password) {
        action.input(passwordField, password);
    }

    public void reEnterPassword(String password) {
        action.input(confirmPasswordField, password);
    }

    public MyAccountPage clickOnCreateAccountButton() {
        action.click(createAccountButton);
        return new MyAccountPage(driver);
    }

    public String getPasswordErrorMessage() {
        return action.getText(passwordErrorMessage);
    }

    public String getPasswordConfirmationErrorMessage() {
        return action.getText(passwordConfirmationErrorMessage);
    }

    public String getFirstNameErrorMessage() {
        return action.getText(passwordConfirmationErrorMessage);
    }

}
