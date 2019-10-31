package steps;

import popups.BasePopup;
import utils.wait.Wait;

public class BaseSteps {

    /**
     * Clicks Ok button on Confirmation Popup
     */
    public void clickOkButton() {
        BasePopup popup = new BasePopup();
        Wait.waitUntilParticularState(popup::isDisplayed);
        popup.clickOkButton();
        Wait.waitUntilParticularState(() -> !popup.isDisplayed());
    }

    /**
     * Clicks Cancel button on Confirmation Popup
     */
    public void clickCancelButton() {
        BasePopup popup = new BasePopup();
        Wait.waitUntilParticularState(popup::isDisplayed);
        popup.clickCancelButton();
        Wait.waitUntilParticularState(() -> !popup.isDisplayed());
    }
}
