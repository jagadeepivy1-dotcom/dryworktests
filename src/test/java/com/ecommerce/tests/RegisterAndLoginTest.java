package com.ecommerce.tests;

import java.util.UUID;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ecommerce.pages.LoginPage;
import com.ecommerce.pages.RegisterPage;
import com.ecommerce.util.WebDriverUtil;

public class RegisterAndLoginTest {
    private WebDriver driver;
    private String baseUrl = "https://ecommerce-playground.lambdatest.io/index.php";
    private String testEmail;
    private String testPassword = "Test@1234";

    @BeforeClass
    public void setUp() {
        boolean headless = Boolean.parseBoolean(System.getProperty("headless", "false"));
        driver = WebDriverUtil.getDriver(headless);
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void registerNewUser() {
        driver.get(baseUrl + "/?route=account/register");
        RegisterPage registerPage = new RegisterPage(driver);
        String fname = "Test";
        String lname = "User";
        testEmail = "testuser_" + UUID.randomUUID() + "@example.com";
        String phone = "1234567890";
        registerPage.register(fname, lname, testEmail, phone, testPassword);
        String successMsg = registerPage.getSuccessMessage();
        Assert.assertTrue(successMsg.contains("Your Account Has Been Created!"), "Registration failed!");
    }

    @Test(priority = 2, dependsOnMethods = "registerNewUser")
    public void loginUser() {
        driver.get(baseUrl + "/?route=account/login");
        // Wait for the login form to be present
        new org.openqa.selenium.support.ui.WebDriverWait(driver, java.time.Duration.ofSeconds(15))
            .until(org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated(org.openqa.selenium.By.id("input-email")));
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(testEmail, testPassword);
        String header = loginPage.getAccountHeader();
        Assert.assertTrue(header.contains("My Account"), "Login failed!");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
