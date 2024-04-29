package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPage {

    private final WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    private WebElement getEmailField (){
        return driver.findElement(By.id("user-name"));
    }
    private WebElement getPasswordField (){
        return driver.findElement(By.id("password"));
    }
    private WebElement getLoginBtn (){
        return driver.findElement(By.id("login-button"));
    }
    private WebElement getAppTitle (){
        return driver.findElement(By.className("app_logo"));
    }

    private String getUrl(){
        return driver.getCurrentUrl();
    }

    public String getSwagLabsText() {
        return driver.findElement(By.className("app_logo")).getText();
    }

    public String getSignInErrorMessage() {
        return driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
    }


    //Locator

    public void loginUser (String username, String password) {
        getEmailField().sendKeys(username);
        getPasswordField().sendKeys(password);
        getLoginBtn().click();
    }

    public void verifyUrlAfterSignIn(String expectedUrl){
        Assert.assertEquals(getUrl(), expectedUrl);
    }

    public void verifySignInTest(String expectedText, String actualText){
        Assert.assertEquals(actualText, expectedText);
    }




}
