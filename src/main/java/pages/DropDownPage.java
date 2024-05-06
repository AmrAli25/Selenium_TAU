package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class DropDownPage {
    private WebDriver driver;
    private By dropDownField = By.id("dropdown");

    public DropDownPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Select from the dropDown menu")
    public void selectFromDropDown(String option) {
        findDropdownElement().selectByVisibleText(option);
    }

    @Step("Get the options in the dropDown menu ")
    public List<String> getSelectedOptions() {
        List<WebElement> selectedElements = findDropdownElement().getAllSelectedOptions();
        return selectedElements.stream().map(e -> e.getText()).collect(Collectors.toList());
    }

    @Step("Get the options in the dropDown menu")
    private Select findDropdownElement() {
        return new Select(driver.findElement(dropDownField));
    }

    @Step("Enable the multiple selection in the dropDown menu using Js executor")
    public void enableMultipleSelection() {
        String script = "arguments[0].setAttribute('multiple', '')";
        var jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript(script, findDropdownElement());
    }

}
