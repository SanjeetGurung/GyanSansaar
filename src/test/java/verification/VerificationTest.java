package verification;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.RegisterPage;
import pages.VerificationPage;

import java.util.Scanner;

public class VerificationTest extends BaseTest {

  protected RegisterPage registerPage;
  @Test
  public void testSuccessfulVerification(){
      //Initialize the Verification Page
      VerificationPage verificationPage =  registerPage.clickSignUpButton();

      // Take input of the verification code from the user
      Scanner scanner = new Scanner(System.in);
      System.out.println("Enter the verification code: ");
      String verificationcode = scanner.nextLine();
      scanner.close();

      //Call the methods
      verificationPage.setVerificationCode(verificationcode);
      LoginPage loginPage = verificationPage.clickVerifyButton();
      // Wait for a few seconds to observe the result
      try {
          Thread.sleep(5000);
      } catch (InterruptedException e) {
          e.printStackTrace();
      }
      /*// Verify the result
      if () {
          System.out.println("Verification code test passed!");
      } else {
          System.out.println("Verification code test failed!");
      }*/


  }
}
