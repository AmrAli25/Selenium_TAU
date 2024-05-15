package utils;

import com.google.common.io.Files;
import io.qameta.allure.Allure;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Helper {
    // To make an explicit wait easily
    public static WebDriverWait ExplicitWait(WebDriver driver, long timeInSec) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeInSec));
    }

    // To highlight the element if you want
    public static void highlightElement(WebDriver driver, WebElement element, String borderColor) {
        Actions actions = new Actions(driver);
        actions.scrollToElement(element).moveToElement(element).perform();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border=" + borderColor, element);
    }

    public static void takeScreenShot(WebDriver driver, ITestResult result) {
        var camera = (TakesScreenshot) driver;
        File screenShot = camera.getScreenshotAs(OutputType.FILE);
        try {
            Files.move(screenShot, new File("resources/screenshots/" + result.getName() + ".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //    @Attachment(value = "Full Page Screenshot", type = "image/png", fileExtension = ".png")
    public static void attachScreenshotToAllureReport(WebDriver driver) {
        Allure.addAttachment("FullPage Screenshot", "image/png", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)), ".png");
//        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
