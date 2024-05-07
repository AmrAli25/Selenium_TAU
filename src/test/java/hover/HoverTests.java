package hover;

import base.BaseTests;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.TestngListener;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Epic("Automation Exercise using Selenium - TAU")
@Feature("Interacting with Hovering")
@Story("Hover Tests")
@Listeners(TestngListener.class)
public class HoverTests extends BaseTests {
    @Test
    public void testHoverUser1() {
        var hoverPage = homePage.clickHovers();
        var caption = hoverPage.hoverOverFigure(0);
        assertTrue(caption.isCaptionDisplayed(), "Caption is not displayed");
        assertEquals(caption.getTitle(), "name: user1", "Wrong title is displayed");
        assertEquals(caption.getLinkText(), "View profile", "Wrong title is displayed");
        assertTrue(caption.getLink().endsWith("/users/1"), "link is incorrect");
    }
}
