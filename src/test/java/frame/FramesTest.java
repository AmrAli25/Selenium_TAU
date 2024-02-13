package frame;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FramesTest extends BaseTests {

    @Test
    public void getFramesTests(){
        var nestedFramesPage = homePage.clickFramesPage().clickNestedFrames();
        assertEquals(nestedFramesPage.getLeftFrameText(),"LEFT","Wrong Frame");
        assertEquals(nestedFramesPage.getBottomFrameText(),"BOTTOM","Wrong Frame");
        assertEquals(nestedFramesPage.getRightFrameText(),"RIGHT","Wrong Frame");
        assertEquals(nestedFramesPage.getMiddleFrameText(),"MIDDLE","Wrong Frame");

    }
}
