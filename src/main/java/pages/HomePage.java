package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;

    // Constructor to pass the driver to the class and the method
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // generic method to click the links by parsing the text to it
    @Step("Click the link provided")
    public void clickLink(String linkText) {
        driver.findElement(By.linkText(linkText)).click();
    }

    @Step("Click the authentication form")
    public LoginPage clickFormAuth() {
        clickLink("Form Authentication");
        return new LoginPage(driver);
    }

    @Step("Click on the dropDown menu")
    public DropDownPage clickDropDown() {
        clickLink("Dropdown");
        return new DropDownPage(driver);
    }

    @Step("Click the forget password")
    public ForgetPassPage clickForgetPassword() {
        clickLink("Forgot Password");
        return new ForgetPassPage(driver);
    }

    @Step("Click the Hovers")
    public HoverPage clickHovers() {
        clickLink("Hovers");
        return new HoverPage(driver);
    }

    @Step("Click key presses link")
    public InputPage clickKeyPresses() {
        clickLink("Key Presses");
        return new InputPage(driver);
    }

    @Step("Click HorizontalSlider link")
    public HorizontalSliderPage clickHorizontalSlider() {
        clickLink("Horizontal Slider");
        return new HorizontalSliderPage(driver);
    }

    @Step("Go to the Alert page")
    public AlertsPage clickAlertsPage() {
        clickLink("JavaScript Alerts");
        return new AlertsPage(driver);
    }

    @Step("Go to the upload files page")
    public UploadFilePage clickUploadFiles() {
        clickLink("File Upload");
        return new UploadFilePage(driver);
    }

    @Step("Go to the context menu page")
    public ContextMenuPage clickContextMenu() {
        clickLink("Context Menu");
        return new ContextMenuPage(driver);
    }

    @Step("Go to the Editor page")
    public WysiwygEditor clickWysiwygPage() {
        clickLink("WYSIWYG Editor");
        return new WysiwygEditor(driver);
    }

    @Step("Go to the Frames page")
    public FramesPage clickFramesPage() {
        clickLink("Frames");
        return new FramesPage(driver);
    }

    @Step("Go to the dynamic loading page")
    public DynamicLoading clickDynamicLoadingPage() {
        clickLink("Dynamic Loading");
        return new DynamicLoading(driver);
    }

    @Step("Go to the large and deep DOM page")
    public LargeAndDeepDomPage clickLargeAndDeepDomPage() {
        clickLink("Large & Deep DOM");
        return new LargeAndDeepDomPage(driver);
    }

    @Step("Go to the upload files page")
    public infiniteScrollPage clickinfiniteScrollPage() {
        clickLink("Infinite Scroll");
        return new infiniteScrollPage(driver);
    }

    @Step("Go to the entry ad page")
    public EntryAdPage clickEntryAd() {
        clickLink("Entry Ad");
        return new EntryAdPage(driver);
    }

    @Step("Go to the Multiple windows page")
    public MultipleWindowsPage clickMultipleWindows() {
        clickLink("Multiple Windows");
        return new MultipleWindowsPage(driver);
    }


}
