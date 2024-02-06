package hover;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class HoverTests extends BaseTests {
    @Test
    public void testHoverUser1(){
        var hoverPage = homePage.clickHovers();
        var caption = hoverPage.hoverOverFigure(0);
        assertTrue(caption.isCaptionDisplayed(),"Caption is not displayed");
        assertEquals(caption.getTitle(), "name: user1", "Wrong title is displayed");
        assertEquals(caption.getLinkText(), "View profile", "Wrong title is displayed");
        assertTrue(caption.getLink().endsWith("/users/1"),"link is incorrect");
    }
}
