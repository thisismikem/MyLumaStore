package com.mmtest.testcases;

import com.mmtest.pages.CreateNewAccountPage;
import com.mmtest.pages.HomePage;
import com.mmtest.pages.MyAccountPage;
import com.mmtest.utilities.Action;
import com.mmtest.utilities.Message;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;


public class CreateNewAccountTest extends BaseTest {
    Faker faker = new Faker();;

//    @Test(threadPoolSize = 3, invocationCount = 5)
//    @Test(invocationCount = 10)
    @Parameters("URL")
    void testCreateNewAccountPass(String url) {
        String firstname = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password(10, 12, true, true, true);

        WebDriver driver = getDriver();
        HomePage homePage = new HomePage(driver);
        driver.get(url);
        CreateNewAccountPage createNewAccountPage = homePage.clickOnCreateAccount();
        Assert.assertEquals(driver.getTitle(), "Create New Customer Account");

        createNewAccountPage.enterFirstName(firstname);
        createNewAccountPage.enterLastName(lastName);
        createNewAccountPage.enterEmail(email);
        createNewAccountPage.enterPassword(password);
        createNewAccountPage.reEnterPassword(password);
        MyAccountPage myAccountPage = createNewAccountPage.clickOnCreateAccountButton();

        Assert.assertEquals(myAccountPage.getWelcomeMessage(), "Welcome, " + firstname + " " + lastName + "!");
        Assert.assertEquals(driver.getTitle(), "My Account");

    }

    @Test(threadPoolSize = 3, invocationCount = 5)
    @Parameters("URL")
    void testFailPasswordMessage(String url) {
        String firstname = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password(8, 10);

        WebDriver driver = getDriver();
        HomePage homePage = new HomePage(driver);
        driver.get(url);
        CreateNewAccountPage createNewAccountPage = homePage.clickOnCreateAccount();
        Assert.assertEquals(driver.getTitle(), "Create New Customer Account");

        createNewAccountPage.enterFirstName(firstname);
        createNewAccountPage.enterLastName(lastName);
        createNewAccountPage.enterEmail(email);
        createNewAccountPage.enterPassword(password);
        createNewAccountPage.reEnterPassword(password);

        Assert.assertEquals(createNewAccountPage.getPasswordErrorMessage(), Message.PASSWORD_ERROR_MESSAGE);
    }

    @Test(enabled = false)
    @Parameters("URL")
    void testDifferentPasswordMessage(String url) {
        String firstname = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String password1 = faker.internet().password(10, 12, true, true, true);
        String password2 = faker.internet().password(10, 12, true, true, true);

        WebDriver driver = getDriver();
        HomePage homePage = new HomePage(driver);
        driver.get(url);
        CreateNewAccountPage createNewAccountPage = homePage.clickOnCreateAccount();
        Assert.assertEquals(driver.getTitle(), "Create New Customer Account");

        createNewAccountPage.enterFirstName(firstname);
        createNewAccountPage.enterLastName(lastName);
        createNewAccountPage.enterEmail(email);
        createNewAccountPage.enterPassword(password1);
        createNewAccountPage.reEnterPassword(password2);
        createNewAccountPage.clickOnCreateAccountButton();

        Assert.assertEquals(createNewAccountPage.getPasswordConfirmationErrorMessage(), Message.PASSWORD_CONFIRMATION_ERROR_MESSAGE);
    }

    @Test(enabled = false)
    @Parameters("URL")
    void testFirstNameRequiredMessage(String url) {

        WebDriver driver = getDriver();
        HomePage homePage = new HomePage(driver);
        driver.get(url);
        CreateNewAccountPage createNewAccountPage = homePage.clickOnCreateAccount();
        Assert.assertEquals(driver.getTitle(), "Create New Customer Account");

        createNewAccountPage.clickOnCreateAccountButton();

        Assert.assertEquals(createNewAccountPage.getFirstNameErrorMessage(), Message.REQUIRED_ERROR_MESSAGE);
        Assert.assertEquals(createNewAccountPage.getPasswordErrorMessage(), Message.REQUIRED_ERROR_MESSAGE);
        Assert.assertEquals(createNewAccountPage.getPasswordConfirmationErrorMessage(), Message.REQUIRED_ERROR_MESSAGE);
    }

}
