package com.ecommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {
    private WebDriver driver;
    private By firstName = By.id("input-firstname");
    private By lastName = By.id("input-lastname");
    private By email = By.id("input-email");
    private By telephone = By.id("input-telephone");
    private By password = By.id("input-password");
    private By confirmPassword = By.id("input-confirm");
    private By privacyPolicyLabel = By.cssSelector("label[for='input-agree']");
    private By continueBtn = By.cssSelector("input[type='submit'][value='Continue']");
    private By successMsg = By.cssSelector("#content h1");
    private By loginBtn = By.cssSelector("input[type='submit'][value='Login']");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void register(String fname, String lname, String emailStr, String phone, String pwd) {
        driver.findElement(firstName).sendKeys(fname);
        driver.findElement(lastName).sendKeys(lname);
        driver.findElement(email).sendKeys(emailStr);
        driver.findElement(telephone).sendKeys(phone);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(confirmPassword).sendKeys(pwd);
        driver.findElement(privacyPolicyLabel).click();
        driver.findElement(continueBtn).click();
    }

    public String getSuccessMessage() {
        return driver.findElement(successMsg).getText();
    }

    public void login(String emailStr, String pwd) {
        new WebDriverWait(driver, java.time.Duration.ofSeconds(10))
            .until(ExpectedConditions.visibilityOfElementLocated(email));
        driver.findElement(email).sendKeys(emailStr);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(loginBtn).click();
    }
}
