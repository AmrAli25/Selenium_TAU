package horizontalSlider;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class HorizontalSliderTests extends BaseTests {

    @Test
    public void setSliderTest(){
        var horizontalSliderPage = homePage.clickHorizontalSlider();
        horizontalSliderPage.moveSlider("4");
        assertEquals(horizontalSliderPage.getRange(),"4", "Wrong Range for the slider");
    }
}
