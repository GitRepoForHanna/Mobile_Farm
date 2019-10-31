package utils.dataProviders;

import business_objects.testbo.*;
import org.testng.annotations.DataProvider;

import java.util.Arrays;

public class NoteDataProvider {

    @DataProvider(name = "CreateNewNote")
    public static Object[] getNote() {
        return new Note[]{
                new TextNote("Salad ingridients", new Body(Arrays.asList("Oil", "Red fish", "Cheese", "Latook", "Eggs")))//,
//                new TextNote("Cake", Color.BLUE, new Body(Arrays.asList("Milk", "5 Eggs", "Creamy souse", "2 Bananas", "500g Berries"))),
//                new CheckListNote("Books to read", new Body(Arrays.asList("Ivanhoe",
//                        "Lost by the wind",
//                        "Forsyte saga")))
        };
    }

    @DataProvider(name = "CreateTextNote")
    public static Object[] createTextNote() {
        return new Note[]{
                new TextNote("Books to read", new Body(Arrays.asList("Lost by the wind", "Forsyte saga", "Ivanhoe")))
        };
    }

    @DataProvider(name = "Note_Editing")
    public static Object[] createNote() {
        return new Note[]{
                    new TextNote("Books to read", new Body(Arrays.asList("Lost by the wind"))),
                    new CheckListNote("Colors", new Body(Arrays.asList("Green")))
        };
    }

    @DataProvider(name = "AppendingToNote")
    public static Object[][] getDataForAppendingChecklistNote() {
        return new Object[][]{
                {
                        new CheckListNote("Colors", new Body(Arrays.asList("Green"))),
                        new CheckListNote("Colors", new Body(Arrays.asList("Red")))
                },
                {
                        new TextNote("Books to read", new Body(Arrays.asList("Lost by the wind","Forsyte saga","Ivanhoe"))),
                        new TextNote("Books to read", new Body(Arrays.asList("Jain Eyre")))
                }
        };
    }

    @DataProvider(name = "EditNoteTitle")
    public static Object[] getDataForTitleEditing() {
        return new Note[][]{
                {
                    new TextNote("Books to read", new Body(Arrays.asList("Lost by the wind", "Forsyte saga", "Ivanhoe"))),
                    new TextNote("My favority books")
                },
                {
                    new CheckListNote("Colors", new Body(Arrays.asList("Green"))),
                    new CheckListNote("My favorite colors")
                }
        };
    }

    @DataProvider(name = "UpdateNoteTitle")
    public static Object[] getDataForTitleChanging() {
        return new Note[][]{
                {
                        new TextNote("Books", new Body(Arrays.asList("Lost by the wind", "Forsyte saga", "Ivanhoe"))),
                        new TextNote("Books to read")
                },
                {
                        new TextNote("Books", new Body(Arrays.asList("Lost by the wind", "Forsyte saga", "Ivanhoe"))),
                        new TextNote("My favorite books")
                }
        };
    }

}
