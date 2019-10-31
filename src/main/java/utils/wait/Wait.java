package utils.wait;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.android_driver.AndroidDriverSingletone;

import java.time.Duration;
import java.util.concurrent.Callable;

public class Wait {

    public static final long TIMEOUT = 15;
    public static final long POLLING_TIME = 100;

    public static void waitUntilParticularState(Callable<Boolean> state, long timeout, long pollingTime) {
        new WebDriverWait(AndroidDriverSingletone.getDriver(), timeout)
                .withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofMillis(pollingTime))
                .until(webDriver -> {
                    try {
                        return state.call();
                    } catch (Exception e) {
                        Logger.getLogger(Wait.class).info("Waiting particular state...");
                    }
                    return false;
                });
    }

    public static void waitUntilParticularState(Callable<Boolean> state) {
        waitUntilParticularState(state, TIMEOUT, POLLING_TIME);
    }

}
