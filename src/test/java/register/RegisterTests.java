package register;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.RegisterPage;
import pages.VerificationPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class RegisterTests extends BaseTest {
    @Test
    public void testSuccessfulRegister(){
        LoginPage loginPage = homePage.clickLogin();
        var registerPage = loginPage.registerLink();

        String CollegeOption = "Saptagandaki Multiple Campus";
        String CourseOption = "BSc.CSIT (Tribhuvan University)";
        registerPage.selectFromDropdownCollege(CollegeOption);
        var selectedOptionsCollege= registerPage.getSelectedOptionsCollege();
        assertEquals(selectedOptionsCollege.size(),1,"Incorrect number of selection");
        assertTrue(selectedOptionsCollege.contains(CollegeOption),"Option not selected");

        registerPage.selectFromDropdownCourse(CourseOption);
        var selectedOptionsCourse= registerPage.getSelectedOptionsCourse();
        assertEquals(selectedOptionsCourse.size(),1,"Incorrect number of selection");
        assertTrue(selectedOptionsCourse.contains(CourseOption),"Option not selected");

        registerPage.setGivenName("Sanjeet");
        registerPage.setFamilyName("Test");
        registerPage.setEmail("testSan@yopmail.com");
        registerPage.setPhone("1234567891");
        registerPage.setPassword("12345678");
        VerificationPage verificationPage = registerPage.clickSignUpButton();

    }
}
