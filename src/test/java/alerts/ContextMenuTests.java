package alerts;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ContextMenuTests extends BaseTests {

    @Test
    public void testContextClick(){
        var contextMenuPage = homePage.clickContextMenu();
        contextMenuPage.rightClickOnBox();
        assertEquals(contextMenuPage.alert_getText(),"You selected a context menu", "Wrong message is displayed");
        contextMenuPage.alert_acceptAlert();
    }
}
