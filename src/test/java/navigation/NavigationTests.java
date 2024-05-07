package navigation;

import base.BaseTests;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.TestngListener;

import static org.testng.Assert.assertTrue;

@Epic("Automation Exercise using Selenium - TAU")
@Feature("Interacting with Navigation")
@Story("Navigation Tests")
@Listeners(TestngListener.class)
public class NavigationTests extends BaseTests {

    @Test
    public void testNavigateToTab() {
        var dynamicLoadingPage = homePage.clickDynamicLoadingPage();
        dynamicLoadingPage.openInNewTab();
        var newTabPage = getWindowManger();
        newTabPage.switchToTabs("The Internet");
        assertTrue(newTabPage.getCurrentPage().checkStartBtn(), "Wrong tab is opened");
    }

    @Test
    public void testNavigator() {
        var dynamicLoadingPage = homePage.clickDynamicLoadingPage();
        getWindowManger().switchToTabs("The Internet");
        dynamicLoadingPage.clickElementPage1();
        getWindowManger().goBack();
        getWindowManger().refreshPage();
        getWindowManger().goForward();
        getWindowManger().goTo("https://google.com");

    }



}
