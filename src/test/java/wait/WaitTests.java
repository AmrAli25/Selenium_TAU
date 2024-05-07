package wait;

import base.BaseTests;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.TestngListener;

import static org.testng.Assert.assertEquals;

@Epic("Automation Exercise using Selenium - TAU")
@Feature("Interacting with Waits")
@Story("Wait Tests")
@Listeners(TestngListener.class)
public class WaitTests extends BaseTests {

    @Test
    public void testWaitUntilHidden() {

        var dynamicLoadingPage = homePage.clickDynamicLoadingPage();
        var elementPage1 = dynamicLoadingPage.clickElementPage1();
        elementPage1.ClickStartBtn();
        assertEquals(elementPage1.getFinishText(), "Hello World!", "Wrong test and something went wrong");
    }

    @Test
    public void testWaitUntilVisible() {

        var dynamicLoadingPage = homePage.clickDynamicLoadingPage();
        var elementPage2 = dynamicLoadingPage.clickElementPage2();
        elementPage2.clickStartBtn();
        assertEquals(elementPage2.getFinishText(), "Hello World!", "Wrong Finish text");
    }
}
