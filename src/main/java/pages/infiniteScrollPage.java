package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class infiniteScrollPage {

    private WebDriver driver;
    By textBlocks = By.className("jscroll-added");

    public infiniteScrollPage(WebDriver driver) {
        this.driver = driver;
    }

    public void scrollToParagraph(int index){
        String script = "window.scrollTo(0, document.body.scrollHeight)";
        var jsExecutor = (JavascriptExecutor)driver;
        while (getNumberOfParagraphs() < index){
            jsExecutor.executeScript(script);
        }
    }

    private int getNumberOfParagraphs(){
        return driver.findElements(textBlocks).size();
    }
}
