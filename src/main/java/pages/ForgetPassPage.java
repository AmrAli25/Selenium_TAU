package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgetPassPage {
    private WebDriver driver; // create a variable of chromedriver
    private By enterEmailField = By.id("email");  // find the web element for email by id
    private By submitButton = By.id("form_submit");  // find the web element for button by id

    public ForgetPassPage(WebDriver driver) {
        this.driver = driver;
    }

    public EmailSentPage enterEmailAndSubmit(String email){
        driver.findElement(enterEmailField).sendKeys(email);
        driver.findElement(submitButton).click();
        return new EmailSentPage(driver);
    }
//    public EmailSentPage clickSubmitButton(){
//        driver.findElement(submitButton).click();
//        return new EmailSentPage(driver);
//    }

}
