package base;

import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTests {
    public WebDriver driver;

    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        List <WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println(links.size());
        WebElement InputsLink = driver.findElement(By.linkText("Inputs"));
        InputsLink.click();
        System.out.println(driver.getTitle());
        driver.quit();
    }
    // This is the first example for Chapter 3
    public void firstExample(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        WebElement shiftingContentLink = driver.findElement(By.linkText("Shifting Content"));
        shiftingContentLink.click();
        WebElement menuLink = driver.findElement(By.linkText("Example 1: Menu Element"));
        menuLink.click();
        List <WebElement> links = driver.findElements(By.tagName("li"));
        System.out.println("The items in the list is : " + links.size());
        driver.quit();
    }
    public static void main(String[] args) {
        BaseTests test = new BaseTests();
        test.firstExample();
    }
}
