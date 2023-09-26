package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    final WebDriver driver;
    final WebDriverWait wait;
    final By email = By.xpath("//*[@id=\"email\"]");
    final By password = By.xpath("//*[@id=\"password\"]");
    final By forgetPassword = By.xpath("//*[@id=\"app\"]/div/div[1]/div/div/div[1]/div/div[2]/form/div[3]/a");
    final By rememberMe = By.xpath("//*[@id=\"app\"]/div/div[1]/div/div/div[1]/div/div[2]/form/div[4]/input");
    final By signIn = By.xpath("//*[@id=\"app\"]/div/div[1]/div/div/div[1]/div/div[2]/form/div[5]/button");
    final By clickRegister = By.xpath("//div[@class='text-center']");
    final By backToHome = By.xpath("//*[@id=\"app\"]/div/div[1]/div/div/div[2]/a");

    public LoginPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Initialize WebDriverWait
    }
    public void setEmail(String email1){
        wait.until(ExpectedConditions.elementToBeClickable(email)).sendKeys(email1);
    }
    public void setPassword(String password1){
        wait.until(ExpectedConditions.elementToBeClickable(password)).sendKeys(password1);
    }
    public ForgetPasswordPage forgetPasswordPage(){
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(forgetPassword));
        element.click();
        return new ForgetPasswordPage(driver);
    }
    public void setRememberMe(){
        wait.until(ExpectedConditions.elementToBeClickable(rememberMe)).click();
    }
    public RegisteredUserHomePage clickSignIn(){
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(signIn));
        element.click();
        return new RegisteredUserHomePage(driver);
    }
    public RegisterPage registerLink(){
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(clickRegister));
        element.click();
        return new RegisterPage(driver);
    }
    public HomePage clickBackToHome(){
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(backToHome));
        element.click();
        return new HomePage(driver);
    }
}
