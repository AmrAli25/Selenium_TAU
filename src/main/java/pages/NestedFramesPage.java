package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NestedFramesPage {
    private WebDriver driver;
    private String leftFrame = "frame-left";
    private String bottomFrame = "frame-bottom";
    private String topFrame = "frame-top";
    private String middleFrame = "frame-middle";
    private String rightFrame = "frame-right";
    private By frameText = By.tagName("body");

    public NestedFramesPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Get the left frame text")
    public String getLeftFrameText() {
        driver.switchTo().frame(topFrame);
        driver.switchTo().frame(leftFrame);
        String text = getFrameText();
        driver.switchTo().parentFrame();
        driver.switchTo().parentFrame();
        return text;
    }

    @Step("Get the bottom frame text")
    public String getBottomFrameText() {
        driver.switchTo().frame(bottomFrame);
        String text = getFrameText();
        driver.switchTo().parentFrame();
        driver.switchTo().parentFrame();
        return text;
    }

    @Step("Get the right frame text")
    public String getRightFrameText() {
        driver.switchTo().frame(topFrame);
        driver.switchTo().frame(rightFrame);
        String text = getFrameText();
        driver.switchTo().parentFrame();
        driver.switchTo().parentFrame();
        return text;
    }

    @Step("Get the middle frame text")
    public String getMiddleFrameText() {
        driver.switchTo().frame(topFrame);
        driver.switchTo().frame(middleFrame);
        String text = getFrameText();
        driver.switchTo().parentFrame();
        driver.switchTo().parentFrame();
        return text;
    }

    @Step("Get the frame text")
    private String getFrameText() {
        return driver.findElement(frameText).getText();
    }
}
