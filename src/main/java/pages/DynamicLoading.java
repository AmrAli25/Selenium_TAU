package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class DynamicLoading {

    private WebDriver driver;
    private By exambleOne = By.cssSelector("a[href='/dynamic_loading/1']");
    private By exambletwo = By.cssSelector("a[href='/dynamic_loading/2']");

    public DynamicLoading(WebDriver driver) {
        this.driver = driver;
    }

    public ElementPage1 clickElementPage1(){
        driver.findElement(exambleOne).click();
        return new ElementPage1(driver);
    }
    public ElementPage2 clickElementPage2(){
        driver.findElement(exambletwo).click();
        return new ElementPage2(driver);
    }
    public void openInNewTab(){
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(exambletwo)).keyDown(Keys.COMMAND).click().perform();
    }



}
