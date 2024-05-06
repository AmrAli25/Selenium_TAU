package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class ElementPage1 {

    private WebDriver driver;
    private By startBtn = By.cssSelector("#start button");
    private By loadingIndicator = By.id("loading");
    private By finishText = By.id("finish");

    public ElementPage1(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click Start button")
    public void ClickStartBtn() {
        driver.findElement(startBtn).click();


        FluentWait wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(loadingIndicator)));

    }

    @Step("Get the finish text")
    public String getFinishText() {
        return driver.findElement(finishText).getText();
    }
}
