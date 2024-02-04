package base;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;

public class BaseTests {
    private WebDriver driver;
    protected HomePage homePage;


    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        homePage = new HomePage(driver);
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
    public static void main(String[] args) {
        BaseTests test = new BaseTests();
    }
}
