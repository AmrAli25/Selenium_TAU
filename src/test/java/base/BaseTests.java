package base;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;

public class BaseTests {
    private WebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver"); // For mac os
//        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe"); // For windows os
        driver = new ChromeDriver();
        goHome();

        homePage = new HomePage(driver);
    }
    @BeforeMethod
    public void goHome(){
        driver.get("https://the-internet.herokuapp.com/");
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
