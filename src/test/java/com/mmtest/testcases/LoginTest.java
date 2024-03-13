package com.mmtest.testcases;

import com.mmtest.pages.CreateNewAccountPage;
import com.mmtest.pages.HomePage;
import com.mmtest.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest {

    @Test
    @Parameters("URL")
    void testSignInClick(String url) {
        WebDriver driver = getDriver();
        HomePage homePage = new HomePage(driver);
        driver.get(url);
        LoginPage loginPage = homePage.clickOnSignIn();
        Assert.assertEquals(driver.getTitle(), "Customer Login");

        loginPage.enterEmail("thisisatest7086@gmail.com");
        loginPage.enterPassword("JJfjj123~!");
    }

}
