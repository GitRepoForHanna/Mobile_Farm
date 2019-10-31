package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.android_driver.DriverUtils;
import utils.wait.Wait;

public class EditNotePage extends BasePage{

    @FindBy(id = "com.socialnmobile.dictapps.notepad.color.note:id/back_btn")
    private WebElement backButton;

    @FindBy(id = "com.socialnmobile.dictapps.notepad.color.note:id/overflow_btn")
    private WebElement overflowButton;

    @FindBy(id = "com.socialnmobile.dictapps.notepad.color.note:id/edit_btn")
    private WebElement editButton;

    @FindBy(id = "com.socialnmobile.dictapps.notepad.color.note:id/edit_title")
    private WebElement titleInput;

    @FindBy(id = "com.socialnmobile.dictapps.notepad.color.note:id/view_note")
    private WebElement viewNote;

    public EditNotePage() {
        PageFactory.initElements(DriverUtils.getAppiumDriver(), this);
    }

    public void clickBackButton() {
        Wait.waitUntilParticularState(backButton::isDisplayed);
        backButton.click();
    }

    public void clickOverflowButton() {
        Wait.waitUntilParticularState(overflowButton::isDisplayed);
        overflowButton.click();
    }

    public void clickEditButton() {
        Wait.waitUntilParticularState(editButton::isDisplayed);
        editButton.click();
    }

    public String getTitle() {
        Wait.waitUntilParticularState(titleInput::isDisplayed);
        return titleInput.getText();
    }
}
