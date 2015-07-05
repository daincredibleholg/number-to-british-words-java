package net.h0lg.java.tests.number2words.helper;

/**
 * This helper class provides methods to manipulate String null safe.
 *
 */
public class StringFormatHelper {

    /**
     * Adds stringToAdd at the beginning of value if value is
     *  a) not null and
     *  b) not empty
     *
     * @param value The value you need another string in front of.
     * @param stringToAdd The String to add at value's front.
     * @return The combination stringToAdd and value or value, if the above requirements are not met.
     */
    public static String addBeforeIfNotEmpty(String value, String stringToAdd) {
        if (value == null || value.isEmpty()) {
            return value;
        }

        return stringToAdd + value;
    }
}
