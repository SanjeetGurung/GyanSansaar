package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
//import java.util.Scanner;

public class VerificationPage {
    final WebDriver driver;
    final WebDriverWait wait;

    final By verificationCode = By.id("verification_pin");
    final By verifyButton = By.xpath("//div[@class=\"d-grid gap-2\"]/button[@class=\"btn btn-primary text-uppercase\"]");

    public VerificationPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void setVerificationCode(String verificationcode1){
        wait.until(ExpectedConditions.elementToBeClickable(verificationCode)).sendKeys(verificationcode1);
    }
    public LoginPage clickVerifyButton(){
        wait.until(ExpectedConditions.elementToBeClickable(verifyButton)).click();
        return new LoginPage(driver);
    }


}
