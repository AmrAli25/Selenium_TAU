package base;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.HomePage;

public class BaseTests {
    private WebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        homePage = new HomePage(driver);
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
    // This is the first example for Chapter 3
//    public void firstExample(){
//        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
//        driver = new ChromeDriver();
//        driver.get("https://the-internet.herokuapp.com/");
//        WebElement shiftingContentLink = driver.findElement(By.linkText("Shifting Content"));
//        shiftingContentLink.click();
//        WebElement menuLink = driver.findElement(By.linkText("Example 1: Menu Element"));
//        menuLink.click();
//        List <WebElement> links = driver.findElements(By.tagName("li"));
//        System.out.println("The items in the list is : " + links.size());
//        driver.quit();
//    }
}
