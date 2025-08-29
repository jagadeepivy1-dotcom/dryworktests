package com.ecommerce.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private WebDriver driver;
    private By email = By.id("input-email");
    private By password = By.id("input-password");
    private By loginBtn = By.cssSelector("input[type='submit'][value='Login']");
    private By accountHeader = By.cssSelector("#content h2");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String emailStr, String pwd) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.visibilityOfElementLocated(email));
        driver.findElement(email).sendKeys(emailStr);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(loginBtn).click();
    }

    public String getAccountHeader() {
        return driver.findElement(accountHeader).getText();
    }
}

