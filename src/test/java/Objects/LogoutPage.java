package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LogoutPage {
    private final WebDriver driver;
    //driver.manage().timeOuts().implicitlyWait(Duration.ofSeconds(5));
    public LogoutPage(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement getBurgerBtn () {
        return driver.findElement(By.id("react-burger-menu-btn"));
    }

    private WebElement getLogoutBtn () {
        return driver.findElement(By.id("logout_sidebar_link"));
    }

    public void logoutUser() {
        getBurgerBtn().click();
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(d -> getLogoutBtn().isDisplayed());
        getLogoutBtn().click();
    }

}
