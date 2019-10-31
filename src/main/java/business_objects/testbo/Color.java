package business_objects.testbo;

public enum Color {
    RED("com.socialnmobile.dictapps.notepad.color.note:id/btn1"),
    ORANGE("com.socialnmobile.dictapps.notepad.color.note:id/btn2"),
    YELLOW("com.socialnmobile.dictapps.notepad.color.note:id/btn3"),
    GREEN("com.socialnmobile.dictapps.notepad.color.note:id/btn4"),
    BLUE("com.socialnmobile.dictapps.notepad.color.note:id/btn5"),
    VIOLET("com.socialnmobile.dictapps.notepad.color.note:id/btn6"),
    BLACK("com.socialnmobile.dictapps.notepad.color.note:id/btn7"),
    GREY("com.socialnmobile.dictapps.notepad.color.note:id/btn8"),
    WHITE("com.socialnmobile.dictapps.notepad.color.note:id/btn9");

    private String colorButtonId;

    Color(String colorButtonId) {
        this.colorButtonId = colorButtonId;
    }

    public String getColorButtonId() {
        return colorButtonId;
    }
}
