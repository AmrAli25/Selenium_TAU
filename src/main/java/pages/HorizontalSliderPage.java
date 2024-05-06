package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HorizontalSliderPage {
    private WebDriver driver;
    private By sliderField = By.tagName("input");
    private By range = By.id("range");

    public HorizontalSliderPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Move the horizontal slider ")
    public void moveSlider(String range) {
        while (!getRange().equals(range))
            driver.findElement(sliderField).sendKeys(Keys.ARROW_RIGHT);
    }

    @Step("Get the range of the slider")
    public String getRange() {
        return driver.findElement(range).getText();
    }
}
