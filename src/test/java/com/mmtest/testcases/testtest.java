package com.mmtest.testcases;


import com.github.javafaker.Faker;
import com.mmtest.utilities.Action;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class testtest {
    Faker faker = new Faker();;
    WebDriver driver;

    @Test
    void testCreateNewAccountPass() {
        String firstname = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password(10, 12, true, true, true);

        driver = new ChromeDriver();
        driver.get("https://magento.softwaretestingboard.com/customer/account/create/");

        driver.findElement(By.id("firstname")).sendKeys(firstname);
        driver.findElement(By.id("lastname")).sendKeys(lastName);
        driver.findElement(By.id("email_address")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("password-confirmation")).sendKeys(password);

        driver.findElement(By.xpath("//button[@class='action submit primary']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        final By by = By.xpath("//span[@class='logged-in']");

        wait.until(ExpectedConditions.visibilityOfElementLocated(by));

        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                By by = By.xpath("//span[@class='logged-in']");
                WebElement element = driver.findElement(by);
                String text = element.getText();

                System.out.println("text = " + text);

                if(text != null && !text.equals(""))
                    return true;
                else
                    return false;
            }
        });

        WebElement element = driver.findElement(by);

        Assert.assertEquals(element.getText(), "Welcome, " + firstname + " " + lastName + "!");
        Assert.assertEquals(driver.getTitle(), "My Account");

    }

    @AfterTest
    void tearDown() {
        driver.quit();
    }
}
