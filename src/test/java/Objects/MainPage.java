package Objects;

import org.openqa.selenium.WebDriver;

public class MainPage {
    private final WebDriver driver;
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void beforeTest(){
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
    }

    public void afterTest(){
        driver.quit();
    }
}
