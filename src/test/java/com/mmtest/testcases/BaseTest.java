package com.mmtest.testcases;

import com.mmtest.factories.DriverFactory;
import com.mmtest.pages.BasePage;
import com.mmtest.utilities.Action;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BaseTest {
    static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

    @Parameters("browser")
    @BeforeMethod
    public void setup(String browser) {
        DriverFactory.initBrowser(browser);
        threadLocalDriver.set(DriverFactory.getDriver());
    }

    static WebDriver getDriver() {
        return threadLocalDriver.get();
    }

    @AfterMethod
    void tearDown() {
        Action.sleep(3000);
        getDriver().quit();
        System.out.println("After test thread id: " + Thread.currentThread().getId());
        threadLocalDriver.remove();
    }

}
