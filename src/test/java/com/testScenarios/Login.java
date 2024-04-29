package com.testScenarios;

import Objects.LogoutPage;
import Objects.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Objects.LoginPage;
import java.util.concurrent.TimeUnit;

public class Login {
    WebDriver driver = new ChromeDriver();
    MainPage main = new MainPage(driver);
    LoginPage login = new LoginPage(driver);
    LogoutPage logout = new LogoutPage(driver);

    @BeforeTest
    public void beforeTest() {
        //WebDriverManager.chromedriver().setup();

        main.beforeTest();
    }

    @Test
    public void loginWithValidCredentials() {
        login.loginUser("standard_user", "secret_sauce");
        login.verifyUrlAfterSignIn("https://www.saucedemo.com/inventory.html");
        login.verifySignInTest(login.getSwagLabsText(),"Swag Labs");
        logout.logoutUser();
    }

    @Test
    public void loginWithValidInvalidCredentials() {
        login.loginUser("invalid_user123", "secret_sauce");
        login.verifySignInTest(login.getSignInErrorMessage(),"Epic sadface: Username and password do not match any user in this service");
    }

    @AfterTest
    public void afterTest() {
        main.afterTest();
    }
}


