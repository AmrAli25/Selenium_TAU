package utils;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CookieManager {

    private final WebDriver driver;

    public CookieManager(WebDriver driver) {
        this.driver = driver;
    }

    public void addCookie(Cookie cookie){
        driver.manage().addCookie(cookie);
    }

    public void deleteCookie(Cookie cookie){
        driver.manage().deleteCookie(cookie);
    }
    public Set<Cookie> getAllCookies(){
        return driver.manage().getCookies();
    }
    public Cookie buildCookie(String name, String value){
       return new Cookie(name, value);
    }
    public List<String> getAllCookiesNames(){
        Set<Cookie> cookies = driver.manage().getCookies();
        return cookies.stream().map(e->e.getName()).collect(Collectors.toList()); // to convert the set to list of names only
    }
}
