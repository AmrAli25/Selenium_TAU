package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;

    // Constructor to pass the driver to the class and the method
    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    // generic method to click the links by parsing the text to it
    public void clickLink(String linkText){
        driver.findElement(By.linkText(linkText)).click();
    }

    public LoginPage clickFormAuth(){
        clickLink("Form Authentication");
        return new LoginPage(driver);
    }

    public DropDownPage clickDropDown(){
        clickLink("Dropdown");
        return new DropDownPage(driver);
    }

    public ForgetPassPage clickForgetPassword(){
        clickLink("Forgot Password");
        return new ForgetPassPage(driver);
    }

    public HoverPage clickHovers(){
        clickLink("Hovers");
        return new HoverPage(driver);
    }

    public InputPage clickKeyPresses(){
        clickLink("Key Presses");
        return new InputPage(driver);
    }
    public HorizontalSliderPage clickHorizontalSlider(){
        clickLink("Horizontal Slider");
        return new HorizontalSliderPage(driver);
    }

    public AlertsPage clickAlertsPage(){
        clickLink("JavaScript Alerts");
        return new AlertsPage(driver);
    }

    public UploadFilePage clickUploadFiles(){
        clickLink("File Upload");
        return new UploadFilePage(driver);
    }
    public ContextMenuPage clickContextMenu(){
        clickLink("Context Menu");
        return new ContextMenuPage(driver);
    }

}
