package utils.android_driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.interactions.Actions;


public class DriverUtils {
    public static AppiumDriver getAppiumDriver() {
        return AndroidDriverSingletone.getDriver();
    }

    public static Actions getActions() {
        return new Actions(getAppiumDriver());
    }

    public static TouchAction getAppiumTouchActions() {
        return new TouchAction(DriverUtils.getAppiumDriver());
    }
}
