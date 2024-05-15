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
@Feature("Interacting with editors")
@Story("Set editor Tests")
@Listeners(TestngListener.class)
public class SetEditorTests extends BaseTests {

    @Test
    public void setEditorTextTest(){
        var textEditorPage = homePage.clickWysiwygPage();
        String text1 = "Hello ";
        String text2 = "Worldd";

        textEditorPage.clearTextArea();
        textEditorPage.setTextArea(text1);
        textEditorPage.clickIncreaseIndentBtn();
        textEditorPage.setTextArea(text2);
        assertEquals(textEditorPage.getEditorText(),text1+text2,"Wrong text entered");
    }
}
