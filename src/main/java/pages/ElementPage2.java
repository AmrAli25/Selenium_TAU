package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementPage2 {

    private WebDriver driver;
    private By startBtn = By.cssSelector("#start button");
    private By finishText = By.cssSelector("div[id='finish']");

    public ElementPage2(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click start button")
    public void clickStartBtn() {
        driver.findElement(startBtn).click();
    }

    @Step("Get the finish text")
    public String getFinishText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(finishText));
        return driver.findElement(finishText).getText();
    }

    @Step("Check the start button visibility")
    public Boolean checkStartBtn() {
        return driver.findElement(startBtn).isDisplayed();
    }

}
