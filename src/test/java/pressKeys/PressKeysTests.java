package pressKeys;

import base.BaseTests;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class PressKeysTests extends BaseTests {

    @Test
    public void testBackSpace(){
        var keyPage = homePage.clickKeyPresses();
        keyPage.enterText("A" + Keys.BACK_SPACE);
        assertEquals(keyPage.getResultText(),"You entered: BACK_SPACE","Wrong result text");
    }
    @Test
    public void testPi(){
        var keyPage = homePage.clickKeyPresses();
        keyPage.enterPi();
    }
}
