package base;


import com.google.common.io.Files;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import utils.CookieManager;
import utils.EventListenerManager;
import utils.WindowManger;

import java.io.File;
import java.io.IOException;

public class BaseTests {
    private WebDriver driver;

    protected HomePage homePage;

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver(getChromeOptions());
//        EventListenerManager eventListener = new EventListenerManager();
//        EventFiringDecorator decorator = new EventFiringDecorator((WebDriverListener) driver,eventListener);

        goHome();
        homePage = new HomePage(driver); // this will redirect me to the homepage class page
    }
    @BeforeMethod
    public void goHome(){
        driver.get("https://the-internet.herokuapp.com/");
    }

    @AfterMethod
    public void recordFailure(ITestResult result){
        // ITestResult is a type from the TestNG
        if (ITestResult.FAILURE == result.getStatus()) {
            var camera = (TakesScreenshot)driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            System.out.println("Screenshot path : " + screenshot.getAbsolutePath());
            try {
                Files.move(screenshot, new File("resources/screenshots/"+ result.getName() +".png"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
    public WindowManger getWindowManger(){
        return new WindowManger(driver);
    }
    private ChromeOptions getChromeOptions(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        return options;
    }
    public CookieManager getCookieManager(){
        return new CookieManager(driver);
    }

}
