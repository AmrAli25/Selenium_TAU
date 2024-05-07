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
@Story("Context Menu Tests")
@Listeners(TestngListener.class)
public class ContextMenuTests extends BaseTests {

    @Test
    public void testContextClick() {
        var contextMenuPage = homePage.clickContextMenu();
        contextMenuPage.rightClickOnBox();
        assertEquals(contextMenuPage.alert_getText(), "You selected a context menu", "Wrong message is displayed");
        contextMenuPage.alert_acceptAlert();
    }
}
