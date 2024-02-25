package base;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import utils.WindowManger;

public class BaseTests {
    private WebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        goHome();
        homePage = new HomePage(driver); // this will redirect me to the homepage class page
    }
    @BeforeMethod
    public void goHome(){
        driver.get("https://the-internet.herokuapp.com/");
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
    public WindowManger getWindowManger(){
        return new WindowManger(driver);
    }

}
