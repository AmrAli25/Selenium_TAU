package modal;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ModalTests extends BaseTests {

    @Test
    public void testModalInteractions(){
        var entryAdPage = homePage.clickEntryAd();
        assertEquals(entryAdPage.getModalTitle(),"THIS IS A MODAL WINDOW","wrong title");
        entryAdPage.clickCloseFromModal();
    }
}
