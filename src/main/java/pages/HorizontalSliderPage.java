package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HorizontalSliderPage {
    private WebDriver driver;
    private By sliderField = By.tagName("input");
    private By range = By.id("range");

    public HorizontalSliderPage(WebDriver driver){
        this.driver = driver;
    }
    public void moveSlider(String range){
        while(!getRange().equals(range))
            driver.findElement(sliderField).sendKeys(Keys.ARROW_RIGHT);
    }
    public String getRange(){
        return driver.findElement(range).getText();
    }
}
