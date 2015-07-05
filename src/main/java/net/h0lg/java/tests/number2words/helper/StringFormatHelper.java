package net.h0lg.java.tests.number2words.helper;

/**
 * Created by holgersteinhauer on 05/07/15.
 */
public class StringFormatHelper {

    public static String addBeforeIfNotEmpty(String value, String stringToAdd) {
        if (value == null || value.isEmpty()) {
            return value;
        }

        return stringToAdd + value;
    }
}
