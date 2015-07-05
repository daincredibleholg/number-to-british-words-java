package net.h0lg.java.tests.number2words.helper;

import net.h0lg.java.tests.number2words.BoundaryChecker;

import java.text.DecimalFormat;

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

    /**
     * Pads the given number with 0s if needed.
     * The needed length correlates with BoundaryChecker.UPPER_BOUNDARY and can
     * be read by using BoundaryChecker.UPPER_BOUNDARY_PADDING_MASK.
     *
     * @param number Number you need a 0-padded String representation for.
     * @return 0-padded String representation of number
     */
    public static String zeroPadNumber(int number) {
        // check boundaries first
        BoundaryChecker.checkBoundaries(number);

        String result;
        String mask = BoundaryChecker.UPPER_BOUNDARY_PADDING_MASK;

        DecimalFormat decimalFormat = new DecimalFormat(mask);
        result = decimalFormat.format(number);

        return result;
    }
}
