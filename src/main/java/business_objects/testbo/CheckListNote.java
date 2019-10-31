package business_objects.testbo;

public class CheckListNote extends Note{

    public CheckListNote(String name, Color color) {
        super(name, NoteType.CHECKLIST, color);
    }

    public CheckListNote(String name, Body body) {
        super(name, NoteType.CHECKLIST);
        setBody(body);
    }

    public CheckListNote(String name) {
        super(name, NoteType.CHECKLIST);
    }

}
