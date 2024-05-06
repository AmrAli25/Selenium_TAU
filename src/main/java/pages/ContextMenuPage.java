package pages;

import io.qameta.allure.Step;
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

    @Step("Right click the box")
    public void rightClickOnBox() {
        WebElement box = driver.findElement(boxField);
        Actions actions = new Actions(driver);
        actions.contextClick(box).perform();
    }

    @Step("Get the text of the text")
    public String alert_getText() {
        return driver.switchTo().alert().getText();
    }

    @Step("Accept the alert")
    public void alert_acceptAlert() {
        driver.switchTo().alert().accept();
    }
}
