package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ContextMenuPage {
    private WebDriver driver;
    private By boxField = By.id("hot-spot");


    public ContextMenuPage(WebDriver driver) {
        this.driver = driver;
    }

    public void rightClickOnBox(){
        WebElement box = driver.findElement(boxField);
        Actions actions = new Actions(driver);
        actions.contextClick(box).perform();
    }

    public String alert_getText(){
        return driver.switchTo().alert().getText();
    }
    public void alert_acceptAlert(){
         driver.switchTo().alert().accept();
    }
}
