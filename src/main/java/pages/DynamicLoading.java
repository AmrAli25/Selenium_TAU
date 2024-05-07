package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static utils.Helper.ExplicitWait;

public class DynamicLoading {

    private WebDriver driver;
    private By exambleOne = By.cssSelector("a[href='/dynamic_loading/1']");
    private By exambletwo = By.cssSelector("a[href='/dynamic_loading/2']");

    public DynamicLoading(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click element page 1")
    public ElementPage1 clickElementPage1() {
        ExplicitWait(driver,10).until(ExpectedConditions.elementToBeClickable(exambleOne));
        driver.findElement(exambleOne).click();
        return new ElementPage1(driver);
    }

    @Step("Click element page 2")
    public ElementPage2 clickElementPage2() {
        ExplicitWait(driver,10).until(ExpectedConditions.elementToBeClickable(exambletwo));
        driver.findElement(exambletwo).click();
        return new ElementPage2(driver);
    }

    @Step("Open the example in a new window ")
    public void openInNewTab() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(exambletwo)).keyDown(Keys.COMMAND).click().perform();
    }


}
