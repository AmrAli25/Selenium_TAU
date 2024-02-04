package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    private By formAuthLink = By.linkText("Form Authentication");

    // Constructor to pass the driver to the class and the method
    public HomePage(WebDriver driver){
        this.driver = driver;
    }
    public LoginPage clickFormAuth(){
        driver.findElement(formAuthLink).click();
        return new LoginPage(driver);
    }
}
