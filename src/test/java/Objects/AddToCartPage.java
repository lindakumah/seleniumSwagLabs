package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class AddToCartPage {
    private final WebDriver driver;
    public AddToCartPage(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getBackPackAddToCartBtn (){
        return driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
    }

    public WebElement getBoltShirtAddToCartBtn (){
        return driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt"));
    }
    private WebElement getAddToCartBtn() {
        return driver.findElement(By.xpath("//a[@data-test='shopping-cart-link']"));
    }

    private WebElement getCheckOutBtn() {
        return driver.findElement(By.id("checkout"));
    }

    private WebElement getCheckOutInfoFirstName() {
        return driver.findElement(By.id("first-name"));
    }

    private WebElement getCheckOutInfoLastName() {
        return driver.findElement(By.id("last-name"));
    }

    private WebElement getCheckOutInfoPostalCode() {
        return driver.findElement(By.id("postal-code"));
    }

    private WebElement getContinueBtn() {
        return driver.findElement(By.id("continue"));
    }

    private WebElement getFinishBtn() {
        return driver.findElement(By.id("finish"));
    }
    //add code to verify items in cart

    private int getNumberOfItemsInCart(){
        return driver.findElements(By.xpath("//div[@data-test='inventory-item']")).size();
    }
    private String getCompleteCheckOutText() {
        return driver.findElement(By.xpath("//h2[@data-test='complete-header']")).getText();
    }


    public void addToCart () {
        getBackPackAddToCartBtn().click();
    }

    public void addItemsToCart() {
        getBackPackAddToCartBtn().click();
        getBoltShirtAddToCartBtn().click();
    }

    public void checkOutItems (String firstName, String lastName, String postCode) {
        getAddToCartBtn().click();
        getCheckOutBtn().click();
        getCheckOutInfoFirstName().sendKeys(firstName);
        getCheckOutInfoLastName().sendKeys(lastName);
        getCheckOutInfoPostalCode().sendKeys(postCode);
        getContinueBtn().click();
    }

    public void checkTotalNumberOfItems(int number){
        Assert.assertEquals(getNumberOfItemsInCart(), number);
    }

    public void completeCheckOut(String checkOutText){
        getFinishBtn().click();
        Assert.assertEquals(getCompleteCheckOutText(), checkOutText);
    }

}
