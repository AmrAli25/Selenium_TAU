package uploadFile;

import base.BaseTests;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.TestngListener;

import static org.testng.Assert.assertEquals;

@Epic("Automation Exercise using Selenium - TAU")
@Feature("Interacting with Upload")
@Story("Upload files Tests")
@Listeners(TestngListener.class)
public class UploadFileTests extends BaseTests {

    @Test
    public void uploadFileTest() {
        var fileUploadPage = homePage.clickUploadFiles();
        fileUploadPage.uploadFile("/Volumes/Data/Amr's Projects/Selenium_TAU/resources/headphones.png");
        assertEquals(fileUploadPage.getUploadedFileName(), "headphones.png", "Test failed Wrong file name");
    }
}
