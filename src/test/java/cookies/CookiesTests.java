package cookies;

import base.BaseTests;
import org.openqa.selenium.Cookie;
import org.testng.annotations.Test;
import utils.CookieManager;

import java.util.List;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class CookiesTests extends BaseTests {

    @Test
    public void testDeleteCookie(){

        goHome();
        var cookieManager = getCookieManager();
        Cookie cookie = cookieManager.buildCookie("optimizelyBuckets","%7B%TD");
        var cookies = cookieManager.getAllCookiesNames();
        cookies.forEach(System.out::println);
        cookieManager.deleteCookie(cookie);
        System.out.println("----------------------------");
        cookies = cookieManager.getAllCookiesNames();
        cookies.forEach(System.out::println);
        assertFalse(cookieManager.getAllCookies().contains(cookie),"Cookie wasn't deleted");
    }
}
