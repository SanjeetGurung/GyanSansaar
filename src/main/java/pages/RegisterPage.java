package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class RegisterPage {
    final WebDriver driver;
    final WebDriverWait wait;
    final By dropdownCollege = By.id("college");
    final By dropdownCourse = By.id("course");
    final By givenName = By.xpath("(//input[@class='form-control' and following-sibling::label[@for='floatingInput']])[1]");
    final By familyName = By.xpath("(//input[@class='form-control' and following-sibling::label[@for='floatingInput']])[2]");
    final By email = By.xpath("(//input[@class='form-control' and following-sibling::label[@for='floatingInput']])[3]");
    final By phone = By.xpath("(//input[@class='form-control' and following-sibling::label[@for='floatingInput']])[4]");
    final By password = By.xpath("//input[@class='form-control' and following-sibling::label[@for='floatingPassword']]");
    final By confirmPassword = By.xpath("//*[@id=\"app\"]/div/div[1]/div/div/div[1]/div/div[2]/form/div[8]/input");
    final By signUpButton = By.xpath("//button[@class='btn btn-primary text-uppercase']");
    public RegisterPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void selectFromDropdownCollege(String optionCollege){
        findDropdownCollege().selectByVisibleText(optionCollege);
    }
    public List<String> getSelectedOptionsCollege(){
        List<WebElement> selectedElementsCollege = findDropdownCollege().getAllSelectedOptions();
        return selectedElementsCollege.stream().map(WebElement::getText).collect(Collectors.toList());
    }
    private Select findDropdownCollege(){
        return new Select(wait.until(ExpectedConditions.elementToBeClickable(dropdownCollege)));
    }
    public void selectFromDropdownCourse(String optionCourse){
        findDropdownCourse().selectByVisibleText(optionCourse);
    }
    public List<String> getSelectedOptionsCourse(){
        List<WebElement> selectedElementsCourse = findDropdownCourse().getAllSelectedOptions();
        return selectedElementsCourse.stream().map(WebElement::getText).collect(Collectors.toList());
    }
    private Select findDropdownCourse(){
        return new Select(wait.until(ExpectedConditions.elementToBeClickable(dropdownCourse)));
    }

    public void setGivenName(String givename){
        wait.until(ExpectedConditions.elementToBeClickable(givenName)).sendKeys(givename);
    }
    public void setFamilyName(String familyname){
        wait.until(ExpectedConditions.elementToBeClickable(familyName)).sendKeys(familyname);
    }
    public void setEmail(String emailAddress){
        wait.until(ExpectedConditions.elementToBeClickable(email)).sendKeys(emailAddress);
    }
    public void setPhone(String phoneNumber){
        wait.until(ExpectedConditions.elementToBeClickable(phone)).sendKeys(phoneNumber);
    }
    public void setPassword(String passWord){
        wait.until(ExpectedConditions.elementToBeClickable(password)).sendKeys(passWord);
    }
    public void setConfirmPassword(String confirmPassword1){
        wait.until(ExpectedConditions.elementToBeClickable(confirmPassword)).sendKeys(confirmPassword1);
    }
    public VerificationPage clickSignUpButton(){
        wait.until(ExpectedConditions.elementToBeClickable(signUpButton)).click();
        return new VerificationPage(driver);
    }

}
