package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    final WebDriver driver;
    final WebDriverWait wait; // Declare WebDriverWait

    final By clickLogin = By.xpath("(//a[@class='nav-link icon-nav-link'])[5]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Initialize WebDriverWait
    }

    public LoginPage clickLogin() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(clickLogin));
        element.click();
        return new LoginPage(driver);
    }
}

