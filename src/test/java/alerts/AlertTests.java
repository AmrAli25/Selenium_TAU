package alerts;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AlertTests extends BaseTests {
    @Test
    public void acceptAlertTest(){
        var alertPage = homePage.clickAlertsPage();
        alertPage.clickJsAlert();
        alertPage.alert_AcceptAlert();
        assertEquals(alertPage.getResultHint(),"You successfully clicked an alert","Wrong alert message is displayed");
    }

    @Test
    public void cancelAlertTest(){
        var alertPage = homePage.clickAlertsPage();
        alertPage.clickJsConfirm();
        String text = alertPage.alert_GetAlertText();
        alertPage.alert_DismissAlert();
        assertEquals(text,"I am a JS Confirm", "Wrong one clicked");
    }

    @Test
    public void enterTextForAlert(){
        var alertPage = homePage.clickAlertsPage();
        alertPage.clickJsPrompt();
        alertPage.alert_EnterTextForAlert("Automation is Good");
        alertPage.alert_AcceptAlert();
        assertEquals(alertPage.getResultHint(),"You entered: Automation is Good", "wrong message is entered");
    }
}
