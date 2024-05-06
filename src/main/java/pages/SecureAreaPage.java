package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage {

    private WebDriver driver;
    private By statusAlert = By.id("flash");

    public SecureAreaPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Get alert text")
    public String getAlertText() {
        return driver.findElement(statusAlert).getText();
    }


}
