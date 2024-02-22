package wait;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class WaitTests  extends BaseTests {

    @Test
    public void testWaitUntilHidden(){

        var dynamicLoadingPage = homePage.clickDynamicLoadingPage();
        var elementPage1 = dynamicLoadingPage.clickElementPage1();
        elementPage1.ClickStartBtn();
        assertEquals(elementPage1.getFinishText(),"Hello World!","Wrong test and something went wrong");
    }

    @Test
    public void testWaitUntilVisible(){

        var dynamicLoadingPage = homePage.clickDynamicLoadingPage();
        var elementPage2 = dynamicLoadingPage.clickElementPage2();
        elementPage2.clickStartBtn();
        assertEquals(elementPage2.getFinishText(),"Hello World!","Wrong Finish text");
    }
}
