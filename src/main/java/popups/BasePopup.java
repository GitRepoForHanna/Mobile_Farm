package popups;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;
import utils.android_driver.DriverUtils;
import utils.wait.Wait;

public class BasePopup extends BasePage {

    private static final String PARENT_PANEL_ID = "android:id/parentPanel";

    @FindBy(id = PARENT_PANEL_ID)
    private WebElement parentPanel;

    @FindBy(xpath = "//android.widget.Button[@text='NEXT']")
    private WebElement nextButton;

    @FindBy(xpath = "//android.widget.Button[@text='CANCEL']")
    private WebElement cancelButton;

    @FindBy(xpath = "//android.widget.Button[@text='OK']")
    private WebElement okButton;

    public BasePopup() {
        PageFactory.initElements(DriverUtils.getAppiumDriver(), this);
    }

    public void clickCancelButton() {
        Wait.waitUntilParticularState(() -> cancelButton.isEnabled());
        cancelButton.click();
    }

    public void clickOkButton() {
        Wait.waitUntilParticularState(() -> okButton.isEnabled());
        okButton.click();
    }

    public boolean isDisplayed() {
        return (findElementsById(PARENT_PANEL_ID).size() != 0) && parentPanel.isDisplayed();
    }
}
