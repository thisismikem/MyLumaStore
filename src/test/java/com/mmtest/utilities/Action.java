package com.mmtest.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Action {
    WebDriver driver;
    Duration duration = Duration.ofSeconds(Long.parseLong(Config.CONFIG.getString("WEB_DRIVER_WAIT_SECONDS")));

    public Action(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement waitForElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, duration);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    private WebElement waitForTextElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(ExpectedConditions.visibilityOf(element));

        return element;
    }

    private WebElement waitForTextElementByLocation(final By by) {
        WebDriverWait wait = new WebDriverWait(driver, duration);

        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                WebElement element = driver.findElement(by);
                String text = element.getText();

                if(text != null && !text.equals(""))
                    return true;
                else
                    return false;
            }
        });

        return driver.findElement(by);
    }

    public void click(WebElement element) {
        WebElement element1 = waitForElement(element);
        element1.click();
    }

    public void input(WebElement element, String value) {
        element = waitForElement(element);
        element.clear();
        element.sendKeys(value);
    }

    public String getText(WebElement element) {
        element = waitForTextElement(element);
        return element.getText();
    }

    public String getTextByLocation(By by) {
        WebElement element = waitForTextElementByLocation(by);
        return element.getText();
    }

    public static void sleep(long l) {
        try {
            Thread.sleep(l);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
