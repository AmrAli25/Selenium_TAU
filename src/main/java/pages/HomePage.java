package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
    public WysiwygEditor clickWysiwygPage(){
        clickLink("WYSIWYG Editor");
        return new WysiwygEditor(driver);
    }
    public FramesPage clickFramesPage(){
        clickLink("Frames");
        return new FramesPage(driver);
    }
    public DynamicLoading clickDynamicLoadingPage(){
        clickLink("Dynamic Loading");
        return new DynamicLoading(driver);
    }
    public LargeAndDeepDomPage clickLargeAndDeepDomPage(){
        clickLink("Large & Deep DOM");
        return new LargeAndDeepDomPage(driver);
    }
    public infiniteScrollPage clickinfiniteScrollPage(){
        clickLink("Infinite Scroll");
        return new infiniteScrollPage(driver);
    }
    public EntryAdPage clickEntryAd(){
        clickLink("Entry Ad");
        return new EntryAdPage(driver);
    }
    public MultipleWindowsPage clickMultipleWindows(){
        clickLink("Multiple Windows");
        return new MultipleWindowsPage(driver);
    }


}
