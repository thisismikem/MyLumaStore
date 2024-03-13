package com.mmtest.testcases;

import com.mmtest.pages.CreateNewAccountPage;
import com.mmtest.pages.HomePage;
import com.mmtest.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class CommonPageElementsTest extends BaseTest {

    @Test
    @Parameters("URL")
    void testLogoClick(String url) {
        WebDriver driver = getDriver();
        HomePage homePage = new HomePage(driver);
        driver.get(url);
        homePage = homePage.clickOnLogo();
        Assert.assertEquals(driver.getTitle(), "Home Page");
    }

}
