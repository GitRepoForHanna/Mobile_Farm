package utils.elements;

import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utils.android_driver.DriverUtils;
import utils.wait.Wait;

public class ElementUtils {

    public static PointOption getCenterElementPointOption(WebElement element) {
        int y = element.getSize().getHeight()/2;
        int x = element.getRect().getWidth()/2;
        return new PointOption().point(element.getLocation().moveBy(x, y));
    }

    public static void clickOnElement(WebElement element) {
        Wait.waitUntilParticularState(element::isEnabled);
        DriverUtils.getActions().click(element).perform();
    }

    public static void placeCursorToBeginningOfInput(WebElement element) {
        placeCursorToEndOfInput(element);
        int strLength = element.getText().length();
        pressKey(element, Keys.ARROW_LEFT, strLength);
    }

    public static void placeCursorToEndOfInput(WebElement element) {
        clickOnElement(element);
        pressKey(element, Keys.END);
    }

    public static void pressKey(WebElement element, Keys key) {
        DriverUtils.getActions().sendKeys(element, key).perform();
    }

    public static void pressKey(WebElement element, Keys key, int timesToPress) {
        for(int i = 0; i < timesToPress; i++){
            DriverUtils.getActions().sendKeys(element, key).perform();
        }
    }
}
