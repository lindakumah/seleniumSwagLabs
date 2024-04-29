package com.testScenarios;

import Objects.AddToCartPage;
import Objects.LoginPage;
import Objects.LogoutPage;
import Objects.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddToCart {
    WebDriver driver = new ChromeDriver();
    MainPage main = new MainPage(driver);
    LoginPage login = new LoginPage(driver);
    LogoutPage logout = new LogoutPage(driver);
    AddToCartPage addToCart = new AddToCartPage(driver);

    @BeforeTest
    public void beforeTest() {
        main.beforeTest();
        login.loginUser("standard_user", "secret_sauce");
    }

    @Test
    public void addToCartAndCheckout() {
        addToCart.addToCart();
        addToCart.completeCheckOut("Rose", "Mensah", "233 Ghana");
    }

    @AfterTest
    public void afterTest() {
        main.afterTest();
    }
}
