package horizontalSlider;

import base.BaseTests;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.TestngListener;

import static org.testng.Assert.assertEquals;

@Epic("Automation Exercise using Selenium - TAU")
@Feature("Interacting with Sliders")
@Story("Horizontal slider Tests")
@Listeners(TestngListener.class)
public class HorizontalSliderTests extends BaseTests {

    @Test
    public void setSliderTest() {
        var horizontalSliderPage = homePage.clickHorizontalSlider();
        horizontalSliderPage.moveSlider("4");
        assertEquals(horizontalSliderPage.getRange(), "4", "Wrong Range for the slider");
    }
}
