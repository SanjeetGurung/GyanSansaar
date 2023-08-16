package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private By clickRegister = By.linkText("Register new account.");
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }
    public RegisterPage registerLink(){
        driver.findElement(clickRegister).click();
        return new RegisterPage(driver);
    }


}
