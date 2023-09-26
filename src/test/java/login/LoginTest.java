package login;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.RegisteredUserHomePage;

public class LoginTest extends BaseTest {
    @Test
    public void testSuccessfulLogin(){
        LoginPage loginPage = homePage.clickLogin();
        String Email = "gsftest@yopmail.com";
        String Password = "12345678";

        loginPage.setEmail(Email);
        loginPage.setPassword(Password);
        RegisteredUserHomePage SignIn = loginPage.clickSignIn();
    }
}
