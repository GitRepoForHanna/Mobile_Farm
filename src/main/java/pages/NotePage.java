package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.NoteUtils;
import utils.android_driver.DriverUtils;
import utils.elements.ElementUtils;
import utils.wait.Wait;

public class NotePage extends BasePage {

    @FindBy(id = "com.socialnmobile.dictapps.notepad.color.note:id/edit_title")
    protected WebElement titleInput;

    @FindBy(id = "com.socialnmobile.dictapps.notepad.color.note:id/back_btn")
    protected WebElement saveButton;

    @FindBy(id = "com.socialnmobile.dictapps.notepad.color.note:id/color_btn")
    protected WebElement colorButton;

    @FindBy(id = "com.socialnmobile.dictapps.notepad.color.note:id/overflow_btn")
    protected WebElement menuButton;

    @FindBy(id = "com.socialnmobile.dictapps.notepad.color.note:id/btn_undo")
    protected WebElement undoButton;

    @FindBy(id = "com.socialnmobile.dictapps.notepad.color.note:id/btn_redo")
    protected WebElement redoButton;

    public NotePage() {
        PageFactory.initElements(DriverUtils.getAppiumDriver(), this);
    }

    public void setTitle(String title) {
        Wait.waitUntilParticularState(titleInput::isEnabled);
        titleInput.sendKeys(title);
        Logger.getLogger(NotePage.class).info(String.format("Set note title %s", title));
    }

    public void clearTitle() {
        Wait.waitUntilParticularState(titleInput::isEnabled);
        titleInput.clear();
        Logger.getLogger(NotePage.class).info("Note title is cleared");
    }

    public String getTitle() {
        Wait.waitUntilParticularState(titleInput::isEnabled);
        return titleInput.getText();
    }

    public void updateTitle(String previousTitle, String newTitle) {
        Wait.waitUntilParticularState(titleInput::isEnabled);
        String difference = NoteUtils.getDifferenceBetweenNoteData(previousTitle, newTitle);
        int indexToInsert = newTitle.toLowerCase().indexOf(difference);
        if ((indexToInsert == 0)) {
            ElementUtils.placeCursorToBeginningOfInput(titleInput);
            ElementUtils.pressKey(titleInput, Keys.DELETE);
            DriverUtils.getActions().sendKeys(previousTitle.substring(0, 1).toLowerCase()).perform();
            ElementUtils.pressKey(titleInput, Keys.ARROW_LEFT);
            difference = difference.substring(0, 1).toUpperCase() + difference.substring(1);
        } else {
            ElementUtils.placeCursorToEndOfInput(titleInput);
        }
        DriverUtils.getActions().sendKeys(difference).perform();
        Logger.getLogger(NotePage.class).info(String.format("Title is updated with '%s' string", difference));
    }

    public void clickSaveButton() {
        Wait.waitUntilParticularState(saveButton::isEnabled);
        saveButton.click();
        Logger.getLogger(NotePage.class).info("Note saved");
    }

    public void clickColorButton() {
        Wait.waitUntilParticularState(colorButton::isEnabled);
        colorButton.click();
        Logger.getLogger(NotePage.class).info("Click Color button");
    }

    public void clickMenuButton() {
        Wait.waitUntilParticularState(menuButton::isEnabled);
        menuButton.click();
        Logger.getLogger(NotePage.class).info("Click Menu button");
    }

    public void clickUndoButton() {
        Wait.waitUntilParticularState(undoButton::isEnabled);
        undoButton.click();
        Logger.getLogger(NotePage.class).info("Click Undo button");
    }

    public void clickRedoButton() {
        Wait.waitUntilParticularState(redoButton::isEnabled);
        redoButton.click();
        Logger.getLogger(NotePage.class).info("Click Redo button");
    }
}
