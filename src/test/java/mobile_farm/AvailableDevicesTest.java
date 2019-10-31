package mobile_farm;

import business_objects.testbo.Note;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.dataProviders.NoteDataProvider;

public class AvailableDevicesTest extends BaseTestClass {

    @Test(dataProviderClass = NoteDataProvider.class, dataProvider = "CreateNewNote", groups = "Creation")
    public void createNewNote(Note note) {
////        driver.getContext();
//            baseEmulatorPageSteps.clickAllowAccess();
//            baseEmulatorPageSteps.clickSkipButton();
//        homePageSteps.clickNewNoteButton();
//        noteTypePopupSteps.selectNoteType(note.getType());
//        notePageSteps.setTitle(note);
//        notePageSteps.setColor(note);
//        notePageSteps.setNoteData(note);
//        AndroidDriverSingletone.getDriver().resetApp();
        SoftAssert softAssert = new SoftAssert();
        baseEmulatorPageSteps.preparationActivities();
        homePageSteps.clickNewNoteButton();
        noteTypePopupSteps.selectNoteType(note.getType());
        notePageSteps.setTitle(note);
        notePageSteps.saveNote();
        editNotePageSteps.clickBackButton();
        softAssert.assertEquals(homePageSteps.getNotesCount(), 1, "New note is added");
        homePageSteps.deleteNote(note.getName());
        softAssert.assertEquals(homePageSteps.getNotesCount(), 0, "Note was deleted");
    }
}
