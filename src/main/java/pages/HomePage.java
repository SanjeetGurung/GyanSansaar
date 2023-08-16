package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    private By loginLink = By.linkText("login");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }
    public LoginPage clickLogin(){
        driver.findElement(loginLink).click();
        return new LoginPage(driver);
    }
}
