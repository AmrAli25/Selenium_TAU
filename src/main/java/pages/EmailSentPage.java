package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmailSentPage {
    private WebDriver driver;           // initialize the driver to be chrome driver
    private By alertMessage = By.tagName("h1");             // variable to find the web element

    // Constructor for the class
    public EmailSentPage(WebDriver driver) {
        this.driver = driver;
    }

    // Get the message from the alert
    @Step("Get the alert message ")
    public String getMessage() {
        return driver.findElement(alertMessage).getText();
    }
}
