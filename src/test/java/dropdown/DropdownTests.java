package dropdown;

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
@Feature("Interacting with DropDown menus")
@Story("DropDown menu Tests")
@Listeners(TestngListener.class)
public class DropdownTests extends BaseTests {

    @Test
    public void testSelectOptions() {
        var dropdownPage = homePage.clickDropDown();
        String options = "Option 1";
        dropdownPage.selectFromDropDown(options);
        var selectedOptions = dropdownPage.getSelectedOptions();
        assertEquals(selectedOptions.size(), 1, "Incorrect number of selections");
        assertTrue(selectedOptions.contains(options), "Option not selected");

    }
}
