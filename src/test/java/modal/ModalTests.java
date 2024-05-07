package modal;

import base.BaseTests;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.TestngListener;

import static org.testng.Assert.assertEquals;

@Epic("Automation Exercise using Selenium - TAU")
@Feature("Interacting with Modals")
@Story("Modal Tests")
@Listeners(TestngListener.class)
public class ModalTests extends BaseTests {

    @Test
    public void testModalInteractions() {
        var entryAdPage = homePage.clickEntryAd();
        assertEquals(entryAdPage.getModalTitle(), "THIS IS A MODAL WINDOW", "wrong title");
        entryAdPage.clickCloseFromModal();
    }
}
