package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Helper {
    // To make an explicit wait easily
    public static WebDriverWait ExplicitWait(WebDriver driver, long timeInSec) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeInSec));
    }

    // To highlight the element if you want
    public static void highlightElement(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);
        actions.scrollToElement(element).moveToElement(element).perform();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='2px solid red'", element);
    }
}
