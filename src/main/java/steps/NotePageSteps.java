package steps;

import business_objects.testbo.CheckListNote;
import business_objects.testbo.Note;
import business_objects.testbo.TextNote;
import org.openqa.selenium.Keys;
import pages.BasePage;
import pages.ChecklistNotePage;
import pages.NotePage;
import pages.TextNotePage;
import popups.ColorPopup;
import popups.NewChecklistItemPopup;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NotePageSteps extends BasePage {

    public void setNoteData(Note note) {
        switch (note.getType()) {
            case TEXT_NOTE: {
                TextNote textNote = (TextNote) note;
                textNote.getBody().getContentItems()
                        .forEach( item -> {
                            new TextNotePage().setBody(item);
                            new TextNotePage().pressKey(Keys.ENTER);
                        });
                break;
            }
            case CHECKLIST: {
                CheckListNote checkListNote = (CheckListNote) note;
                List<String> itemsList = checkListNote.getBody().getContentItems();
                if (itemsList != null) {
                    itemsList
                            .forEach(item -> {
                                new ChecklistNotePage().clickNewItem();
                                NewChecklistItemPopup popup = new NewChecklistItemPopup();
                                popup.setItemBody(item);
                                popup.clickOkButton();
                            });
                }
                break;
            }
            default:
                throw new RuntimeException("This note type doesn't exists!");
        }
    }

    public void clearTitle() {
        new NotePage().clearTitle();
    }

    public void setTitle(Note note) {
        new NotePage().setTitle(note.getName());
    }

    public void setTitle(String title) {
        new NotePage().setTitle(title);
    }

    public String getNoteTitle() {
        return new NotePage().getTitle();
    }

    public void changeTitle(Note note) {
        NotePage notePage = new NotePage();
        notePage.clearTitle();
        notePage.setTitle(note.getName());
    }

    public void updateTitle(Note note) {
        NotePage notePage = new NotePage();
        String currentTitle = getNoteTitle();
        String newTitle = note.getName();
        notePage.updateTitle(currentTitle, newTitle);
    }

    public void clickColorButton() {
        NotePage notePage = new NotePage();
        notePage.clickColorButton();
    }

    public void setColor(Note note) {
        clickColorButton();
        new ColorPopup().setColor(note.getColor());
    }

    public void saveNote() {
        NotePage notePage = new NotePage();
        notePage.clickSaveButton();
    }

    public void undoAction() {
        NotePage notePage = new NotePage();
        notePage.clickUndoButton();
    }

    public void undoAction(int actionCount) {
        for (int i = 0; i < actionCount; i++) {
            undoAction();
        }
    }

    public void redoAction() {
        NotePage notePage = new NotePage();
        notePage.clickRedoButton();
    }

    public void redoAction(int actionCount) {
        for (int i = 0; i < actionCount; i++) {
            redoAction();
        }
    }

    public List<String> getNoteBody(Note note) {
        switch (note.getType()) {
            case TEXT_NOTE: {
                TextNotePage textNotePage = new TextNotePage();
                return (textNotePage.getBody().size() != 0) ? Arrays.asList(textNotePage.getBody().get(0).split("\n")) : Collections.emptyList();

            }
            case CHECKLIST: {
                return new ChecklistNotePage().getCheckListItems();
            }
            default:
                throw new RuntimeException("This note type doesn't exists!");
        }
    }
}
