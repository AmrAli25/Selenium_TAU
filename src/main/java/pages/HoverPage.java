package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class HoverPage {
    private WebDriver driver;
    private By figureBox = By.className("figure");
    private By boxCaption = By.className("figcaption");

    public HoverPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * @param index starts with index 0 as the first element
     */
    @Step("Go to the figure and hover over it")
    public FigureCaption hoverOverFigure(int index) {
        WebElement figure = driver.findElements(figureBox).get(index);
        Actions actions = new Actions(driver);
        actions.moveToElement(figure).perform();
        return new FigureCaption(figure.findElement(boxCaption));
    }

    public class FigureCaption {
        private WebElement caption;
        private By header = By.tagName("h5");
        private By link = By.tagName("a");


        public FigureCaption(WebElement caption) {
            this.caption = caption;
        }

        @Step("Check if the caption is displayed")
        public boolean isCaptionDisplayed() {
            return caption.isDisplayed();
        }

        @Step("Get the title of the caption")
        public String getTitle() {
            return caption.findElement(header).getText();
        }

        @Step("Get the link in the caption")
        public String getLink() {
            return caption.findElement(link).getAttribute("href");
        }

        @Step("Get the link as a text")
        public String getLinkText() {
            return caption.findElement(link).getText();
        }

    }
}
