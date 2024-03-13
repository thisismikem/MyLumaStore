package com.mmtest.factories;

import com.mmtest.utilities.Config;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    private static WebDriver driver;

    public static void initBrowser(String browserName) {

        String webDriverLocation = Config.CONFIG.getString("WEB_DRIVER_LOCATION");

        if ("server".equalsIgnoreCase(webDriverLocation)) {

        } else {
            if ("FireFox".equalsIgnoreCase("browserName")) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            } else if ("Edge".equalsIgnoreCase("browserName")) {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            } else {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
        }

        getDriver().manage().deleteAllCookies();
    }

    public static WebDriver getDriver() {
        return driver;
    }

}
