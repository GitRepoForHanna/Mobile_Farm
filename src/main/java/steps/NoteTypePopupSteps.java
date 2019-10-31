package steps;

import business_objects.testbo.NoteType;
import popups.NoteTypePopup;

public class NoteTypePopupSteps extends BaseSteps {

    public void selectNoteType(NoteType type) {
        new NoteTypePopup().setNoteType(type);
    }

}
