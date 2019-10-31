package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.android_driver.DriverUtils;

import java.util.List;

public abstract class BasePage {

    protected String resourceIdXPathPattern = "//*[@resource-id='%s']";
    protected static final long DEFAULT_HOLD_TIMEOUT = 3;

    protected List findElementsById(String elementId){
        return DriverUtils.getAppiumDriver().findElementsById(elementId);
    }

    protected WebElement findElementById(String elementId) {
        return DriverUtils.getAppiumDriver().findElement(By.id(elementId));
    }

    protected List findElementsByXpath(String elementXpath) {
        return DriverUtils.getAppiumDriver().findElementsByXPath(elementXpath);
    }

    protected WebElement findElementByXpath(String elementXpath) {
        return DriverUtils.getAppiumDriver().findElement(By.xpath(elementXpath));
    }

}
