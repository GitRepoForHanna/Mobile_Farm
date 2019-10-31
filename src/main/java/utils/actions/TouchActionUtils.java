package utils.actions;

import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Point;
import utils.android_driver.DriverUtils;
import utils.window.ScreenUtils;

import java.time.Duration;

public class TouchActionUtils {

    public static final long DEFAULT_WAIT_OPTION_TIMEOUT = 1;

    public static void swipe(Point startPoint, Point endPoint) {
        PointOption pointOption = new PointOption();
        DriverUtils.getAppiumTouchActions().waitAction(new WaitOptions().withDuration(Duration.ofSeconds(DEFAULT_WAIT_OPTION_TIMEOUT)))
                .press(pointOption.withCoordinates(startPoint))
                .moveTo(pointOption.withCoordinates(endPoint))
                .waitAction(new WaitOptions().withDuration(Duration.ofSeconds(1)))
                .release()
                .perform();
    }

   public static void swipe(SwipeDirection direction) {
        Point startPoint = ScreenUtils.getScreenPoint(direction.getStartPointX(), direction.getStartPointY());
        Point endPoint = ScreenUtils.getScreenPoint(direction.getEndPointX(), direction.getEndPointY());
        swipe(startPoint, endPoint);
    }

}








//    public static void swipeToLeft() {
//        Point startPoint = new Point(ScreenUtils.getScreenHorizontalCoordinate(0.5),
//                ScreenUtils.getScreenVerticalCoordinate(0.5));
//
//        Point endPoint = new Point(ScreenUtils.getScreenHorizontalCoordinate(0.1),
//                ScreenUtils.getScreenVerticalCoordinate(0.5));
//        swipe(startPoint, endPoint);
//    }
//
//    public static void swipeToRight() {
//        Point startPoint = new Point(ScreenUtils.getScreenHorizontalCoordinate(0.1),
//                ScreenUtils.getScreenVerticalCoordinate(0.5));
//
//        Point endPoint = new Point(ScreenUtils.getScreenHorizontalCoordinate(0.9),
//                ScreenUtils.getScreenVerticalCoordinate(0.5));
//        swipe(startPoint, endPoint);
//    }
//
//    public static void swipeToTop() {
//        Point startPoint = new Point(ScreenUtils.getScreenHorizontalCoordinate(0.5),
//                ScreenUtils.getScreenVerticalCoordinate(0.9));
//
//        Point endPoint = new Point(ScreenUtils.getScreenHorizontalCoordinate(0.5),
//                ScreenUtils.getScreenVerticalCoordinate(0.1));
//        swipe(startPoint, endPoint);
//    }
//
//    public static void swipeToBottom() {
//        Point startPoint = new Point(ScreenUtils.getScreenHorizontalCoordinate(0.5),
//                ScreenUtils.getScreenVerticalCoordinate(0.1));
//
//        Point endPoint = new Point(ScreenUtils.getScreenHorizontalCoordinate(0.5),
//                ScreenUtils.getScreenVerticalCoordinate(0.9));
//        swipe(startPoint, endPoint);
//    }
