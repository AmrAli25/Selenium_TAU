package pages;


import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.cssSelector("i.fa.fa-2x.fa-sign-in");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Enter the username ")
    public void setUsernameField(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    @Step("Enter the password ")
    public void setPasswordField(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    @Step("Click on the login button")
    public SecureAreaPage clickLoginButton() {
        driver.findElement(loginButton).click();
        return new SecureAreaPage(driver);
    }


}
