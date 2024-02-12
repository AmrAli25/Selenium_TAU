package uploadFile;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class UploadFileTests extends BaseTests {

    @Test
    public void uploadFileTest(){
        var fileUploadPage = homePage.clickUploadFiles();
        fileUploadPage.uploadFile("/Volumes/Data/Amr's Projects/Selenium_TAU/resources/headphones.png");
        assertEquals(fileUploadPage.getUploadedFileName(),"headphones.png","Test failed Wrong file name");
    }
}
