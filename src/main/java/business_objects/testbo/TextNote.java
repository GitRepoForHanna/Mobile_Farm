package business_objects.testbo;

public class TextNote extends Note {

    public TextNote(String name, Color color, Body body) {
        super(name, NoteType.TEXT_NOTE, color, body);
    }

    public TextNote(String name, Body body) {
        super(name, NoteType.TEXT_NOTE, body);
    }

    public TextNote(String name) {
        super(name, NoteType.TEXT_NOTE);
    }

}
