package steps;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import pages.BaseEmulatorPage;

@Component
public class BaseEmulatorPageSteps extends BaseSteps{

    public BaseEmulatorPageSteps() {
    }

    public void clickAllowAccess() {
        BaseEmulatorPage baseEmulatorPage = new BaseEmulatorPage();
        baseEmulatorPage.clickAllowAccess();
        Logger.getLogger(BaseEmulatorPageSteps.class).info("Allowing Access to device resources");
    }

    public void clickSkipButton() {
        BaseEmulatorPage baseEmulatorPage = new BaseEmulatorPage();
        baseEmulatorPage.clickSkipButton();
        Logger.getLogger(BaseEmulatorPageSteps.class).info("Click Skip Details Button");
    }

    public void preparationActivities() {
        clickAllowAccess();
        clickSkipButton();
    }
}
