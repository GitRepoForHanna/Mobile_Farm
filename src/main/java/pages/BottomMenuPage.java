package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.android_driver.DriverUtils;
import utils.wait.Wait;

public class BottomMenuPage extends BasePage {

    private static final String BOTTOM_MENU_ID = "com.socialnmobile.dictapps.notepad.color.note:id/bottom_menu_layout";

    @FindBy(id = BOTTOM_MENU_ID)
    private WebElement bottomMenu;

    @FindBy(id = "com.socialnmobile.dictapps.notepad.color.note:id/bottom_menu_archive")
    private WebElement archiveButton;

    @FindBy(id = "com.socialnmobile.dictapps.notepad.color.note:id/bottom_menu_delete")
    private WebElement deleteButton;

    @FindBy(id = "com.socialnmobile.dictapps.notepad.color.note:id/bottom_menu_color")
    private WebElement colorButton;

    @FindBy(id = "com.socialnmobile.dictapps.notepad.color.note:id/bottom_menu_reminder")
    private WebElement reminderButton;

    @FindBy(id = "com.socialnmobile.dictapps.notepad.color.note:id/bottom_menu_more")
    private WebElement moreButton;

    public BottomMenuPage() {
        PageFactory.initElements(DriverUtils.getAppiumDriver(), this);
    }

    public boolean isDisplayed() {
        return (findElementsById(BOTTOM_MENU_ID).size() != 0) && bottomMenu.isDisplayed();
    }

    public void clickArchiveButton() {
        Wait.waitUntilParticularState(this::isDisplayed);
        Wait.waitUntilParticularState(archiveButton::isEnabled);
        archiveButton.click();
    }

    public void clickDeleteButton() {
        Wait.waitUntilParticularState(this::isDisplayed);
        Wait.waitUntilParticularState(deleteButton::isEnabled);
        deleteButton.click();
    }

    public void clickColorButton() {
        Wait.waitUntilParticularState(this::isDisplayed);
        Wait.waitUntilParticularState(colorButton::isEnabled);
        colorButton.click();
    }

    public void clickReminderButton() {
        Wait.waitUntilParticularState(this::isDisplayed);
        Wait.waitUntilParticularState(reminderButton::isEnabled);
        reminderButton.click();
    }

    public void clickMoreButton() {
        Wait.waitUntilParticularState(this::isDisplayed);
        Wait.waitUntilParticularState(moreButton::isEnabled);
        moreButton.click();
    }
}
