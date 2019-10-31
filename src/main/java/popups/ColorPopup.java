package popups;

import business_objects.testbo.Color;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;
import utils.android_driver.DriverUtils;
import utils.wait.Wait;

public class ColorPopup extends BasePage {

    @FindBy(id = "com.socialnmobile.dictapps.notepad.color.note:id/btn1")
    private WebElement colorButton;

    private static final String COLOR_BUTTON_ID = "com.socialnmobile.dictapps.notepad.color.note:id/btn1";

    public ColorPopup() {
        PageFactory.initElements(DriverUtils.getAppiumDriver(), this);
    }

    private WebElement getColorButton(Color color) {
        return findElementById(color.getColorButtonId());
    }

    public void clickColorButton(Color color) {
        WebElement button = getColorButton(color);
        Wait.waitUntilParticularState(button::isDisplayed);
        button.click();
    }

    public boolean isPopupDisplayed() {
        return (findElementsById(COLOR_BUTTON_ID).size() != 0) && colorButton.isDisplayed();
    }

    public void setColor(Color color) {
        Wait.waitUntilParticularState(this::isPopupDisplayed);
        clickColorButton(color);
        Wait.waitUntilParticularState(() -> !this.isPopupDisplayed());
    }
}
