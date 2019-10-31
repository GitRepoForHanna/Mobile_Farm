package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.android_driver.DriverUtils;
import utils.wait.Wait;

public class BaseEmulatorPage extends BasePage {

    @FindBy(id = "com.android.packageinstaller:id/permission_allow_button")
    private WebElement allowAccessButton;
    @FindBy(id = "com.socialnmobile.dictapps.notepad.color.note:id/btn_start_skip")
    private WebElement skipButton;

    public BaseEmulatorPage() {
        PageFactory.initElements(DriverUtils.getAppiumDriver(), this);
    }

    public void clickAllowAccess() {
        Wait.waitUntilParticularState(allowAccessButton::isDisplayed);
        allowAccessButton.click();
    }

    public void clickSkipButton() {
        Wait.waitUntilParticularState(skipButton::isEnabled);
        skipButton.click();
    }
}
