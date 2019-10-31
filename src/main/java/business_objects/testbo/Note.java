package business_objects.testbo;

public class Note {

    private String name;
    private NoteType type;
    private Color color;
    private Body body;

    protected Note(String name, NoteType type, Color color, Body body) {
        this.name = name;
        this.type = type;
        this.color = color;
        this.body = body;
    }

    protected Note(String name, NoteType type, Color color) {
        this.name = name;
        this.type = type;
        this.color = color;
    }

    protected Note(String name, NoteType type, Body body) {
        this.name = name;
        this.type = type;
        this.body = body;
        this.color = Color.YELLOW;
    }

    protected Note(String name, NoteType type) {
        this.name = name;
        this.type = type;
        this.color = Color.YELLOW;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public NoteType getType() {
        return type;
    }

    public void setType(NoteType type) {
        this.type = type;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }
}
