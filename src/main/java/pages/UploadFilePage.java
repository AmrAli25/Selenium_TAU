package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UploadFilePage {

    private WebDriver driver;
    private By fileUpload = By.id("file-upload");
    private By fileSubmit = By.id("file-submit");
    private By fileUploaded = By.id("uploaded-files");

    public UploadFilePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickSubmitFile(){
        driver.findElement(fileSubmit).click();
    }
    public void uploadFile(String absFilePath){
        driver.findElement(fileUpload).sendKeys(absFilePath);
        clickSubmitFile();
    }
    public String getUploadedFileName(){
        return driver.findElement(fileUploaded).getText();
    }
}
