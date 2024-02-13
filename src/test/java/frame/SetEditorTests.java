package frame;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SetEditorTests extends BaseTests {

    @Test
    public void setEditorTextTest(){
        var textEditorPage = homePage.clickWysiwygPage();
        String text1 = "Hello ";
        String text2 = "World";

        textEditorPage.clearTextArea();
        textEditorPage.setTextArea(text1);
        textEditorPage.clickIncreaseIndentBtn();
        textEditorPage.setTextArea(text2);
        assertEquals(textEditorPage.getEditorText(),text1+text2,"Wrong text entered");
    }
}
