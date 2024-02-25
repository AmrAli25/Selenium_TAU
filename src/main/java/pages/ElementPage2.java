package pages;

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

    public void clickStartBtn(){
        driver.findElement(startBtn).click();
    }

    public String getFinishText(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(finishText));
        return driver.findElement(finishText).getText();
    }
    public Boolean checkStartBtn(){
        return driver.findElement(startBtn).isDisplayed();
    }

}
