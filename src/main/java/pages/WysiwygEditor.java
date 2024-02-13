package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WysiwygEditor {
    private WebDriver driver;
    private By textField = By.id("tinymce");
    private String editorFrameId = "mce_0_ifr";
    private By increaseIndentBtn = By.cssSelector("button[title='Increase indent']");

    public WysiwygEditor(WebDriver driver) {
        this.driver = driver;
    }

    private void switchToEditArea(){
        driver.switchTo().frame(editorFrameId);
    }
    private void switchToMainArea(){
        driver.switchTo().parentFrame();
    }
    public void clearTextArea(){
        switchToEditArea();
        driver.findElement(textField).clear();
        switchToMainArea();
    }
    public void setTextArea(String text){
            switchToEditArea();
            driver.findElement(textField).sendKeys(text);
            switchToMainArea();
    }
    public void clickIncreaseIndentBtn(){
        driver.findElement(increaseIndentBtn).click();
    }
    public String getEditorText(){
        switchToEditArea();
        String text = driver.findElement(textField).getText();
        switchToMainArea();
        return text;
    }

}
