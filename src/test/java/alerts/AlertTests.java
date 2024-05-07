package alerts;

import base.BaseTests;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.TestngListener;

import static org.testng.Assert.assertEquals;
@Epic("Automation Exercise using Selenium - TAU")
@Feature("Interacting with Alerts")
@Story("Alerts Tests")
@Listeners(TestngListener.class)
public class AlertTests extends BaseTests {
    @Test(description = "Accept the alert that comes as javascript")
    public void acceptAlertTest(){
        var alertPage = homePage.clickAlertsPage();
        alertPage.clickJsAlert();
        alertPage.alert_AcceptAlert();
        assertEquals(alertPage.getResultHint(),"You successfully clicked an alert","Wrong alert message is displayed");
    }

    @Test(description = "Cancel the alert that comes as javascript")
    public void cancelAlertTest(){
        var alertPage = homePage.clickAlertsPage();
        alertPage.clickJsConfirm();
        String text = alertPage.alert_GetAlertText();
        alertPage.alert_DismissAlert();
        assertEquals(text,"I am a JS Confirm", "Wrong one clicked");
    }

    @Test(description = "InterActing and adding text to the alert")
    public void enterTextForAlert(){
        var alertPage = homePage.clickAlertsPage();
        alertPage.clickJsPrompt();
        alertPage.alert_EnterTextForAlert("Automation is Good");
        alertPage.alert_AcceptAlert();
        assertEquals(alertPage.getResultHint(),"You entered: Automation is Good", "wrong message is entered");
    }
}
