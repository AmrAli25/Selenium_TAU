package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WysiwygEditor {
    private WebDriver driver;
    private By textField = By.id("tinymce");
    private String editorFrameId = "mce_0_ifr";
    private By increaseIndentBtn = By.cssSelector("button[title='Increase indent']");

    public WysiwygEditor(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Switch to the edit area frame")
    private void switchToEditArea() {
        driver.switchTo().frame(editorFrameId);
    }

    @Step("Switch to the main area frame")
    private void switchToMainArea() {
        driver.switchTo().parentFrame();
    }

    @Step("Clear the text area")
    public void clearTextArea() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(editorFrameId));
        driver.findElement(textField).clear();
        switchToMainArea();
    }

    @Step("Set the text area with a text")
    public void setTextArea(String text) {
        switchToEditArea();
        driver.findElement(textField).sendKeys(text);
        switchToMainArea();
    }

    @Step("Get an indented space in the text")
    public void clickIncreaseIndentBtn() {
        driver.findElement(increaseIndentBtn).click();
    }

    @Step("Get the text in the editor")
    public String getEditorText() {
        switchToEditArea();
        String text = driver.findElement(textField).getText();
        switchToMainArea();
        return text;
    }

}
