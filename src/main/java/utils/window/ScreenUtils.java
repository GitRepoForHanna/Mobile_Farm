package utils.window;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import utils.android_driver.AndroidDriverSingletone;

public class ScreenUtils {

    public static Dimension getSize() {
        return AndroidDriverSingletone.getDriver().manage().window().getSize();
    }

    public static int getScreenHeight() {
        return getSize().getHeight();
    }

    public static int getScreenWidth() {
        return getSize().getWidth();
    }

    public static int getScreenVerticalCoordinate(Double heightPercentage) {
        return (int) (getScreenHeight() * heightPercentage);
    }

    public static int getScreenHorizontalCoordinate(Double widthPercentage) {
        return (int) (getScreenWidth() * widthPercentage);
    }

    public static Point getScreenPoint(Double widthPercentage, Double heightPercentage) {
        return new Point(getScreenHorizontalCoordinate(widthPercentage), getScreenVerticalCoordinate(heightPercentage));
    }


}
