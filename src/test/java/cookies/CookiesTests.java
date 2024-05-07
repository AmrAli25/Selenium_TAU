package cookies;

import base.BaseTests;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.Cookie;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.TestngListener;

import static org.testng.Assert.assertFalse;

@Epic("Automation Exercise using Selenium - TAU")
@Feature("Interacting with Cookies")
@Story("Cookies Tests")
@Listeners(TestngListener.class)
public class CookiesTests extends BaseTests {

    @Test
    public void testDeleteCookie() {

        goHome();
        var cookieManager = getCookieManager();
        Cookie cookie = cookieManager.buildCookie("optimizelyBuckets", "%7B%TD");
        var cookies = cookieManager.getAllCookiesNames();
        cookies.forEach(System.out::println);
        cookieManager.deleteCookie(cookie);
        System.out.println("----------------------------");
        cookies = cookieManager.getAllCookiesNames();
        cookies.forEach(System.out::println);
        assertFalse(cookieManager.getAllCookies().contains(cookie), "Cookie wasn't deleted");
    }
}
