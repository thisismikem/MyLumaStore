package com.mmtest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends CommonPage {
    final String welcomeHeaderXPath = "//span[@class='logged-in']";

    @FindBy(xpath = welcomeHeaderXPath)
    WebElement welcomeHeader;


    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    public String getWelcomeMessage() {
        return action.getTextByLocation(By.xpath(welcomeHeaderXPath));
    }

    public String getWelcomeHeaderXPath() {
        return welcomeHeaderXPath;
    }

}
