package navigation;

import base.BaseTests;
import org.testng.annotations.Test;
import utils.WindowManger;

import static org.testng.Assert.assertTrue;

public class NavigationTests extends BaseTests {
    @Test
    public void testNavigator(){
        homePage.clickDynamicLoadingPage().clickElementPage1();
        getWindowManger().goBack();
        getWindowManger().refreshPage();
        getWindowManger().goForward();
        getWindowManger().goTo("https://google.com");

    }

    @Test
    public void testSwitchTabs(){
        homePage.clickMultipleWindows().clickHere();
        getWindowManger().switchToTabs("New Window");
    }

    @Test
    public void testNavigateToTab(){
        var dynamicLoadingPage = homePage.clickDynamicLoadingPage();
        dynamicLoadingPage.openInNewTab();
        var newTabPage = getWindowManger();
        newTabPage.switchToTabs("The Internet");
        assertTrue(newTabPage.getCurrentPage().checkStartBtn(),"Wrong tab is opened");
    }
}
