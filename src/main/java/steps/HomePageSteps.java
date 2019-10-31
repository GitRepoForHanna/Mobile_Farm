package steps;

import org.apache.log4j.Logger;
import pages.BottomMenuPage;
import pages.HomePage;
import utils.actions.SwipeDirection;
import utils.actions.TouchActionUtils;

public class HomePageSteps extends BaseSteps {

    public void clickNewNoteButton() {
        new HomePage().clickNewNoteButton();
        Logger.getLogger(HomePageSteps.class).info("Click New Note Button");
    }
    public int getNotesCount() {
        return new HomePage().getNoteElements().size();
    }

    public void clickArchiveInBottomMenu() {
        BottomMenuPage menuPage = new BottomMenuPage();
        menuPage.clickArchiveButton();
        Logger.getLogger(HomePageSteps.class).info("Click Archive Button in Bottom Menu");
    }

    public void clickDeleteInBottomMenu() {
        BottomMenuPage menuPage = new BottomMenuPage();
        menuPage.clickDeleteButton();
        Logger.getLogger(HomePageSteps.class).info("Click Delete Button in Bottom Menu");
    }

    public void clickColorInBottomMenu() {
        BottomMenuPage menuPage = new BottomMenuPage();
        menuPage.clickColorButton();
        Logger.getLogger(HomePageSteps.class).info("Click Color Button in Bottom Menu");
    }

    public void clickReminderInBottomMenu() {
        BottomMenuPage menuPage = new BottomMenuPage();
        menuPage.clickReminderButton();
        Logger.getLogger(HomePageSteps.class).info("Click Reminder Button in Bottom Menu");
    }

    public void clickMoreInBottomMenu() {
        BottomMenuPage menuPage = new BottomMenuPage();
        menuPage.clickMoreButton();
        Logger.getLogger(HomePageSteps.class).info("Click More Button in Bottom Menu");
    }

    public boolean isNoteWithTextPresent(String noteTitle) {
        return (new HomePage().getNoteElement(noteTitle)) != null;
    }

    public void clickNoteWithText(String noteTitle) {
        new HomePage().clickNoteWithText(noteTitle);
        Logger.getLogger(HomePageSteps.class).info(String.format("Click Note with text %s", noteTitle));
    }

    public void clickAndHoldNoteWithText(String noteTitle) {
        new HomePage().clickAndHoldNoteWithText(noteTitle);
        Logger.getLogger(HomePageSteps.class).info(String.format("Click and hold Note with text %s", noteTitle));
    }

    public void deleteNote(String noteTitle) {
        HomePage homePage = new HomePage();
        homePage.clickAndHoldNoteWithText(noteTitle);
        clickDeleteInBottomMenu();
        clickOkButton();
    }

    public void swipeScreenToLeft() {
        TouchActionUtils.swipe(SwipeDirection.LEFT);
    }

    public void swipeScreenToRight() {
        TouchActionUtils.swipe(SwipeDirection.RIGHT);
    }

    public void swipeScreenToTop() {
        TouchActionUtils.swipe(SwipeDirection.TOP);
    }

    public void swipeScreenToBottom() {
        TouchActionUtils.swipe(SwipeDirection.BOTTOM);
    }
}
