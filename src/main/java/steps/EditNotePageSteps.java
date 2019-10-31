package steps;

import pages.EditNotePage;

public class EditNotePageSteps {

    public void clickBackButton() {
        new EditNotePage().clickBackButton();
    }

    public void clickOverflowButton() {
        new EditNotePage().clickOverflowButton();
    }

    public void clickEditButton() {
        new EditNotePage().clickEditButton();
    }

    public String getNoteTitle() {
        return new EditNotePage().getTitle();
    }
}
