package popups;

import business_objects.testbo.NoteType;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;
import utils.android_driver.DriverUtils;
import utils.wait.Wait;

public class NoteTypePopup extends BasePage {

    @FindBy(id = "android:id/parentPanel")
    private WebElement noteTypePopupPanel;

    public static final String NOTE_TYPE_POPUP_PANEL_ID = "android:id/parentPanel";

    private String typeButtonXpathPattern = "//android.widget.TextView[@text='%s']";

    public NoteTypePopup() {
        PageFactory.initElements(DriverUtils.getAppiumDriver(), this);
    }

    private WebElement getTypeButton(String type) {
        return findElementByXpath((String.format(typeButtonXpathPattern, type)));
    }


    public void clickNoteTypeButton(String type) {
        WebElement button = getTypeButton(type);
        Wait.waitUntilParticularState(button::isEnabled);
        button.click();
    }

    public boolean isPopupDisplayed() {
        return (findElementsById(NOTE_TYPE_POPUP_PANEL_ID).size() != 0) && noteTypePopupPanel.isDisplayed();
    }

    public void setNoteType(NoteType type) {
        Wait.waitUntilParticularState(this::isPopupDisplayed);
        clickNoteTypeButton(type.getValue());
//        Wait.waitUntilParticularState(() -> !isPopupDisplayed());
        Logger.getLogger(NoteTypePopup.class).info(String.format("Note type %s selected", type.getValue()));
    }
}
