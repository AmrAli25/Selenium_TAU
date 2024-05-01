package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertsPage {
    private WebDriver driver;
    private By triggerJsAlert = By.cssSelector("button[onclick='jsAlert()']");
    private By triggerJsConfirm = By.cssSelector("button[onclick='jsConfirm()']");
    private By triggerJsPrompt = By.cssSelector("button[onclick='jsPrompt()']");
    private By resultHint = By.id("result");

    public AlertsPage(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Show the javascript alert")
    public void clickJsAlert(){
        driver.findElement(triggerJsAlert).click();
    }
    public void clickJsConfirm(){
        driver.findElement(triggerJsConfirm).click();
    }
    public void clickJsPrompt(){
        driver.findElement(triggerJsPrompt).click();
    }
    @Step("Accept the alert")
    public void alert_AcceptAlert(){
        driver.switchTo().alert().accept();
    }
    public void alert_DismissAlert(){
        driver.switchTo().alert().dismiss();
    }
    public String alert_GetAlertText(){
        return driver.switchTo().alert().getText();
    }
    public void alert_EnterTextForAlert(String text){
        driver.switchTo().alert().sendKeys(text);
    }
    public String getResultHint(){
        return driver.findElement(resultHint).getText();
    }
}
