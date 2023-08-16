package register;

import base.BaseTest;
import pages.LoginPage;
import pages.RegisterPage;

public class RegisterTests extends BaseTest {
    public void testSuccessfulRegister(){
        LoginPage loginPage = homePage.clickLogin();
        RegisterPage registerPage = loginPage.registerLink();

    }
}
