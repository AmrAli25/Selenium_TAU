package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class infiniteScrollPage {

    By textBlocks = By.className("jscroll-added");
    private WebDriver driver;

    public infiniteScrollPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Scroll to the wanted paragraph")
    public void scrollToParagraph(int index) {
        String script = "window.scrollTo(0, document.body.scrollHeight)";
        var jsExecutor = (JavascriptExecutor) driver;
        while (getNumberOfParagraphs() < index) {
            jsExecutor.executeScript(script);
        }
    }

    @Step("Get the numbers of paragraphs")
    private int getNumberOfParagraphs() {
        return driver.findElements(textBlocks).size();
    }
}
