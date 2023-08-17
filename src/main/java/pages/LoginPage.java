package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private WebElement element;
    private WebDriverWait wait;
    private By clickRegister = By.xpath("//div[@class='text-center']");
    public LoginPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Initialize WebDriverWait

    }
    public RegisterPage registerLink(){
        element = wait.until(ExpectedConditions.elementToBeClickable(clickRegister));
        element.click();
        return new RegisterPage(driver);
    }


}
