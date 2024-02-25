package utils;

import org.openqa.selenium.WebDriver;
import pages.ElementPage2;

public class WindowManger {

    private WebDriver driver;

    public WindowManger(WebDriver driver) {
        this.driver = driver;
    }

    public void goBack(){
        driver.navigate().back();
    }
    public void goForward(){
        driver.navigate().forward();
    }
    public void refreshPage(){
        driver.navigate().refresh();
    }
    public void goTo(String url){
        driver.navigate().to(url);
    }
    public void switchToTabs(String tabTitle){
        var windows = driver.getWindowHandles();
        System.out.println("Number of tabs " + windows.size());
        System.out.println("Window handles:");
        windows.forEach(System.out::println);
        for (String window : windows){
            System.out.println("Switching to window " + window);
            driver.switchTo().window(window);

            System.out.println("Current window title " + driver.getTitle());

//            if (tabTitle.equals(driver.getTitle())){
//                break;
//            }
        }
    }
    public ElementPage2 getCurrentPage(){
        return new ElementPage2(driver);
    }

}
