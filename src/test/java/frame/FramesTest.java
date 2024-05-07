package frame;

import base.BaseTests;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.TestngListener;

import static org.testng.Assert.assertEquals;

@Epic("Automation Exercise using Selenium - TAU")
@Feature("Interacting with Frames")
@Story("Frames Tests")
@Listeners(TestngListener.class)
public class FramesTest extends BaseTests {

    @Test
    public void getFramesTests() {
        var nestedFramesPage = homePage.clickFramesPage().clickNestedFrames();
        assertEquals(nestedFramesPage.getLeftFrameText(), "LEFT", "Wrong Frame");
        assertEquals(nestedFramesPage.getBottomFrameText(), "BOTTOM", "Wrong Frame");
        assertEquals(nestedFramesPage.getRightFrameText(), "RIGHT", "Wrong Frame");
        assertEquals(nestedFramesPage.getMiddleFrameText(), "MIDDLE", "Wrong Frame");

    }
}
