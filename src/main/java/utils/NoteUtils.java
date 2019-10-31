package utils;

import org.apache.commons.lang3.StringUtils;

public class NoteUtils {
//
//    private static final int STRING_BEGINNING_INDEX = 0;
//    private static final int STRING_1ST_SYMBOL_INDEX = 1;

    public static String getDifferenceBetweenNoteData(String currentDataStr, String newDataStr) {
        return StringUtils.remove(newDataStr.toLowerCase(), currentDataStr.toLowerCase());
    }
}
