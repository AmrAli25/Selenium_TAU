package forgotPassword;

import base.BaseTests;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.TestngListener;

import static org.testng.Assert.assertTrue;

@Epic("Automation Exercise using Selenium - TAU")
@Feature("Interacting with ForgetPassword")
@Story("Forget Password Tests")
@Listeners(TestngListener.class)
public class ForgotPasswordTests extends BaseTests {
    @Test
    public void retrievePassword() {
        var forgetPassPage = homePage.clickForgetPassword();  // create variable for the forget page and click the field to enter the email
        var emailSentPage = forgetPassPage.enterEmailAndSubmit("test@tes.com"); // enter the email address in the field
        assertTrue(emailSentPage.getMessage().contains("Internal Server Error"), "The test is wrong try again"); // assertion for the provided data true or false
    }
}
