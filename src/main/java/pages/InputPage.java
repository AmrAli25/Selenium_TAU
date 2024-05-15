package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import static utils.Helper.highlightElement;
import static utils.Helper.takeScreenShot;

public class InputPage {
    private WebDriver driver;
    private By inputField = By.id("target");
    private By resultHint = By.id("result");

    public InputPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Enter the wanted text")
    public void enterText(String text) {
        driver.findElement(inputField).sendKeys(text);
    }

    @Step("Enter PI")
    public void enterPi() {
        enterText(Keys.chord(Keys.ALT, "p") + "= 3.14");
    }

    @Step("Get the results text")
    public String getResultText() {
//        takeScreenShot(driver.findElement(resultHint));
        return driver.findElement(resultHint).getText();
    }
}
