package pages;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.android_driver.DriverUtils;
import utils.android_driver.AndroidDriverSingletone;
import utils.elements.ElementUtils;
import utils.wait.Wait;

import java.time.Duration;
import java.util.List;
import java.util.Optional;

public class HomePage extends BasePage {

    @FindBy(id = "com.socialnmobile.dictapps.notepad.color.note:id/main_btn1")
    private WebElement newNoteButton;

    @FindBy(id = "com.socialnmobile.dictapps.notepad.color.note:id/main_btn2")
    private WebElement searchButton;

    @FindBy(id = "com.socialnmobile.dictapps.notepad.color.note:id/main_btn3")
    private WebElement actionsButton;

    @FindBy(id = "com.socialnmobile.dictapps.notepad.color.note:id/text_button_center")
    private WebElement sortByTimeButton;

    @FindBy(id = "com.socialnmobile.dictapps.notepad.color.note:id/img_add")
    private WebElement addNoteImage;

    @FindBy(id = "com.socialnmobile.dictapps.notepad.color.note:id/note_list")
    private WebElement notesListPanel;

    private String noteXPathPattern = "//android.widget.RelativeLayout//android.widget.TextView[@resource-id='com.socialnmobile.dictapps.notepad.color.note:id/title']";


    public HomePage() {
        PageFactory.initElements(DriverUtils.getAppiumDriver(), this);
    }

    public void clickNewNoteButton() {
        Wait.waitUntilParticularState(() -> newNoteButton.isDisplayed());
        newNoteButton.click();
    }

    public void waitNewNoteButtonEnabled() {
        Wait.waitUntilParticularState(() -> newNoteButton.isEnabled());
    }

    public void clickNewNoteImage() {
        Wait.waitUntilParticularState(() -> addNoteImage.isDisplayed());
        addNoteImage.click();
    }

    public void clickSearchButton() {
        Wait.waitUntilParticularState(() -> searchButton.isDisplayed());
        searchButton.click();
    }

    public void clickActionsButton() {
        Wait.waitUntilParticularState(() -> actionsButton.isDisplayed());
        actionsButton.click();
    }

    public void clickSortByTimeButton() {
        Wait.waitUntilParticularState(() -> sortByTimeButton.isDisplayed());
        sortByTimeButton.click();
    }

    public List<WebElement> getNoteElements() {
        Wait.waitUntilParticularState(notesListPanel::isDisplayed);
        return notesListPanel.findElements(By.xpath(noteXPathPattern));
    }

    public WebElement getNoteElement(String noteTitle) {
        Optional elementPresence = notesListPanel.findElements(By.xpath(noteXPathPattern)).stream()
                .filter(noteElement -> noteElement.getText().trim().equals(noteTitle))
                .findAny();
        return elementPresence.isPresent() ? (WebElement) elementPresence.get() : null;
    }

    public void clickNoteWithText(String noteTitle) {
        getNoteElement(noteTitle).click();
    }

    public void clickAndHoldNoteWithText(String noteTitle) {
        WebElement element = getNoteElement(noteTitle);
        PointOption pointOption  = ElementUtils.getCenterElementPointOption(element);
        new TouchAction(DriverUtils.getAppiumDriver()).press(pointOption)
                .waitAction(new WaitOptions().withDuration(Duration.ofSeconds(DEFAULT_HOLD_TIMEOUT)))
                .release()
                .perform();
    }
}
