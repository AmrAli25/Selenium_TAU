package forgotPassword;

import base.BaseTests;
import org.testng.annotations.*;
import pages.HomePage;

import static org.testng.Assert.*;

public class ForgotPasswordTests extends BaseTests {
    @Test
    public void retrievePassword(){
        var forgetPassPage = homePage.clickForgetPassword();  // create variable for the forget page and click the field to enter the email
        var emailSentPage = forgetPassPage.enterEmailAndSubmit("test@tes.com"); // enter the email address in the field
        assertTrue(emailSentPage.getMessage().contains("Internal Server Error"),"The test is wrong try again" ); // assertion for the provided data true or false
    }
}
