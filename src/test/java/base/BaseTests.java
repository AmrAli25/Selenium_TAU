package base;


import com.google.common.io.Files;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;
import pages.HomePage;
import utils.CookieManager;
import utils.EventListenerManager;
import utils.TestngListener;
import utils.WindowManger;

import java.io.File;
import java.io.IOException;

@Epic("Automation Exercise using Selenium - TAU")
@Feature("Initialize the test environment")
@Story("Base test")
@Listeners(TestngListener.class)
public class BaseTests {
    protected HomePage homePage;
    private WebDriver driver;       // normal driver
    private ITestResult result;
    private ITestContext context;

    @BeforeClass
    public void setUp() {
        driver = createWebDriverListener(new ChromeDriver(getChromeOptions()));
        result = Reporter.getCurrentTestResult();
        context = result.getTestContext();
        context.setAttribute("driver", driver);

//        goHome();
        homePage = new HomePage(driver);          // this will redirect me to the homepage class page
    }

    @BeforeMethod
    public void goHome() {
        driver.get("https://the-internet.herokuapp.com/");

    }

//    @AfterMethod(description = "If there is an error then this will take a screenshot for it")
//    public void recordFailure(ITestResult result) {
//        // ITestResult is a type from the TestNG
//        if (ITestResult.FAILURE == result.getStatus()) {
//            var camera = (TakesScreenshot) driver;
//            File screenshot = camera.getScreenshotAs(OutputType.FILE);
//            System.out.println("Screenshot path : " + screenshot.getAbsolutePath());
//            try {
//                Files.move(screenshot, new File("resources/screenshots/" + result.getName() + ".png"));
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }
//    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    public WindowManger getWindowManger() {
        return new WindowManger(driver);
    }

    private ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized", "--headless");
        return options;
    }

    public CookieManager getCookieManager() {
        return new CookieManager(driver);
    }

    public WebDriver createWebDriverListener(WebDriver driver) {
        EventListenerManager eventListener = new EventListenerManager();
        EventFiringDecorator<WebDriver> decorator = new EventFiringDecorator<>(eventListener);
        return decorator.decorate(driver);
    }

}
