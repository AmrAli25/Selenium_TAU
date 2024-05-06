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
    public void clickJsAlert() {
        driver.findElement(triggerJsAlert).click();
    }

    @Step("Click the confirm button for Js Alert")
    public void clickJsConfirm() {
        driver.findElement(triggerJsConfirm).click();
    }

    @Step("Click the Js prompt")
    public void clickJsPrompt() {
        driver.findElement(triggerJsPrompt).click();
    }

    @Step("Accept the alert")
    public void alert_AcceptAlert() {
        driver.switchTo().alert().accept();
    }

    @Step("Remove the Js alert")
    public void alert_DismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    @Step("Get the text in the Js Alert")
    public String alert_GetAlertText() {
        return driver.switchTo().alert().getText();
    }

    @Step("Enter a text in the Js Alert")
    public void alert_EnterTextForAlert(String text) {
        driver.switchTo().alert().sendKeys(text);
    }

    @Step("Get the data from the hint")
    public String getResultHint() {
        return driver.findElement(resultHint).getText();
    }
}
