package com.mmtest.pages;

import com.mmtest.factories.DriverFactory;
import com.mmtest.utilities.Action;
import com.mmtest.utilities.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    WebDriver driver;
    Action action;

    BasePage(WebDriver driver) {
        this.driver = driver;
        action = new Action(driver);
        PageFactory.initElements(driver, this);
    }

}
