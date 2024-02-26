package javascript;

import base.BaseTests;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class JavaScriptTests extends BaseTests {

    @Test
    public void testScrollToTable(){
        var largeAndDeepDomPage = homePage.clickLargeAndDeepDomPage();
        largeAndDeepDomPage.scrollToTable();
    }
    @Test
    public void testScrollToParagraph(){
        homePage.clickinfiniteScrollPage().scrollToParagraph(5);
    }
    @Test
    public void testMultipleSelectionForDropDown(){
       var dropDownPage = homePage.clickDropDown();
       dropDownPage.enableMultipleSelection();
       var optionsToSelect = List.of("Option 1","Option 2");
       optionsToSelect.forEach(dropDownPage::selectFromDropDown);

       var selectedOptions = dropDownPage.getSelectedOptions();
       assertTrue(selectedOptions.containsAll(optionsToSelect),"all options were not selected");
       assertEquals(selectedOptions.size(),optionsToSelect.size(),"Number of selected options");
    }
}