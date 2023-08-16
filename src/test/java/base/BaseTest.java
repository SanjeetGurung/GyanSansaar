package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.HomePage;

public class BaseTest {
    private WebDriver driver;
    protected HomePage homePage;
    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver-win64/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://gsf.kasturisanjaal.com/app/index");

        homePage = new HomePage(driver);

    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
