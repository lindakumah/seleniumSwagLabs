package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogoutPage {
    private final WebDriver driver;
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
        getLogoutBtn().click();
    }

}
