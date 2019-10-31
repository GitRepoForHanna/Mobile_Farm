package utils.android_driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static java.lang.String.format;

public class AndroidDriverSingletone {

    private static final String PROJECT_NAME = "EPM-TSTF";

    private static final String API_KEY = "d41951f2-00ae-4775-843a-9fb7ca4e30c3";
    private static final String APPIUM_HUB = "mobilecloud.epam.com";
    private static final long DEFAULT_TIMEOUT = 15;

    private static AndroidDriverSingletone instance;

    private static AppiumDriver driver = null;

    private AndroidDriverSingletone(DesiredCapabilities capabilities) {
        initDriver(capabilities);
    }

    private static AppiumDriver initDriver(DesiredCapabilities capabilities) {
        try {
            driver = new AndroidDriver(
                        new URL(format("https://%s:%s@%s/wd/hub", PROJECT_NAME, API_KEY, APPIUM_HUB)), capabilities);
            Logger.getLogger(AndroidDriverSingletone.class).error("Session id: " + driver.getSessionId());
        } catch (MalformedURLException e) {
            Logger.getLogger(AndroidDriverSingletone.class).info("MalformedURLException exception was caught \n" + e.getMessage());
        }
        return (AppiumDriver) applyDriverConfiguration(driver);
    }

    private static RemoteWebDriver applyDriverConfiguration(RemoteWebDriver driver) {
        driver.manage().timeouts()
                .implicitlyWait(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        return driver;
    }

    public static AndroidDriverSingletone createInstance(DesiredCapabilities capabilities) {
        if(null == instance) {
            instance = new AndroidDriverSingletone(capabilities);
        }
        return instance;
    }

    public static AppiumDriver getDriver() {
        return driver;
    }

    public void closeDriver() {
        driver.close();
        driver.runAppInBackground(Duration.ofSeconds(1));
    }

    public void resetApp() {
        driver.resetApp();
    }

}
