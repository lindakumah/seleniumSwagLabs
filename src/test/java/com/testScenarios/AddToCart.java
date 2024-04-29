package com.testScenarios;

import Objects.AddToCartPage;
import Objects.LoginPage;
import Objects.LogoutPage;
import Objects.MainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.List;

public class AddToCart {
    WebDriver driver = new ChromeDriver();
    MainPage main = new MainPage(driver);
    LoginPage login = new LoginPage(driver);
    LogoutPage logout = new LogoutPage(driver);
    AddToCartPage addToCart = new AddToCartPage(driver);

    @BeforeMethod
    public void beforeTest() {
        main.beforeTest();
        login.loginUser("standard_user", "secret_sauce");
    }

    @Test
    public void addToCartAndCheckout() {
        addToCart.addToCart();
        addToCart.checkOutItems("Rose", "Davis", "233 Ghana");
        addToCart.checkTotalNumberOfItems(1);
        addToCart.completeCheckOut("Thank you for your order!");
        logout.logoutUser();
    }

    @Test
    public void addTwoItemsToCartAndCheckout() {
        addToCart.addItemsToCart();
        addToCart.checkOutItems("Rose", "Davis", "233 Ghana");
        addToCart.checkTotalNumberOfItems(2);
        addToCart.completeCheckOut("Thank you for your order!");
    }

    @AfterTest
    public void afterTest() {
        main.afterTest();
    }
}
