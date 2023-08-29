package crossbrowser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserTest {
    WebDriver driver;
    FirefoxOptions firefoxOptions = new FirefoxOptions();
    ChromeOptions chromeOptions =new ChromeOptions();
    EdgeOptions edgeOptions = new EdgeOptions();
    SafariOptions safariOptions = new SafariOptions();

    @Parameters("browser")
    @BeforeTest
    public void initialize(String browser){
        if(browser.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            System.out.println("Firefox is launched");
        }
        else if(browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            System.out.println("Chrome is launched");
        }
        else if(browser.equalsIgnoreCase("edge")){
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            System.out.println("Edge is launched");
        }
        else if(browser.equalsIgnoreCase("safari")){
            WebDriverManager.safaridriver().setup();
            driver = new SafariDriver();
            System.out.println("Safari is launched");
        }
    }

    @Test
    public void gsfHome(){
        driver.get("http://gsf.kasturisanjaal.com/app/index");
        String actualTitle = driver.getTitle();
        String expect = "Gyansansaar";
        Assert.assertEquals(actualTitle.contains("Gyansansaar"),expect.contains("Gyansansaar"));
    }
    @AfterTest
    public void endTest(){
        driver.quit();
    }
}
