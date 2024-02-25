package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;

public class EntryAdPage {
    private WebDriver driver;
    private By modalTitle = By.xpath("//div[@class='modal']/div/h3");
    private By adModalClose = By.xpath("//div[@class='modal-footer']/p");

    public EntryAdPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getModalTitle(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(modalTitle)));
        return driver.findElement(modalTitle).getText();
    }
    public void clickCloseFromModal(){
        driver.findElement(adModalClose).click();
    }
}
