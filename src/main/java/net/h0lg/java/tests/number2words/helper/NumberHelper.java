package net.h0lg.java.tests.number2words.helper;

import net.h0lg.java.tests.number2words.BoundaryChecker;
import net.h0lg.java.tests.number2words.transform.NumberPartIdentifiers;

import java.util.HashMap;
import java.util.Map;

/**
 * This helper provides static methods to deal with number related tasks.
 */
public class NumberHelper {

    /**
     * Splits a given number into three parts:
     *   * Millions - the three leading digits
     *   * Hundred thousands - the three middle digits
     *   * Thousands - the three digits at the rear
     * Numbers between 1 and 999999999 (@see BoundaryCheck.LOWER_BOUNDARY and BoundaryCheck.UPPER_BOUNDARY)
     * are supported.
     * The result is a map, with the corresponding NumberPartIdentifiers element as key and the
     * digits as value.
     * If the given number is lower than a million or a thousand, the parts for million and / or
     * hundred thousands will be 0.
     *
     * @param number Number you want the parts for
     * @return Map with parts
     */
    public static Map<NumberPartIdentifiers, Integer> splitIntoParts(int number) {
        BoundaryChecker.checkBoundaries(number);

        String numberAsZeroPaddedString = StringFormatHelper.zeroPadNumber(number);

        Integer thousands = getThousandsFromNumberString(numberAsZeroPaddedString);
        Integer hundredThousands = getHundredThousandsFromNumberString(numberAsZeroPaddedString);
        Integer millions = getMillionsFromNumberString(numberAsZeroPaddedString);

        Map<NumberPartIdentifiers, Integer> result = new HashMap<>(3);
        result.put(NumberPartIdentifiers.THOUSANDS, thousands);
        result.put(NumberPartIdentifiers.HUNDRED_THOUSANDS, hundredThousands);
        result.put(NumberPartIdentifiers.MILLIONS, millions);

        return result;
    }

    private static Integer getMillionsFromNumberString(String numberAsZeroPaddedString) {
        Integer result = getIntegerFromSubstring(numberAsZeroPaddedString, 0, 3);
        return result;
    }

    private static Integer getHundredThousandsFromNumberString(String numberAsZeroPaddedString) {
        Integer result = getIntegerFromSubstring(numberAsZeroPaddedString, 3, 6);
        return result;
    }

    private static Integer getThousandsFromNumberString(String numberAsZeroPaddedString) {
        Integer result = getIntegerFromSubstring(numberAsZeroPaddedString, 6, 9);
        return result;
    }

    private static Integer getIntegerFromSubstring(String numberAsZeroPaddedString, int startIndex, int endIndex) {
        return Integer.parseInt(numberAsZeroPaddedString.substring(startIndex, endIndex));
    }


    /**
     * Returns the int representation of the first element in the given array arguments.
     * An empty or null argument causes an IllegalArgumentException and non-integer values
     * will cause an implicit NumberFormatException (sub-class of IllegalArgumentException).
     *
     * @param arguments Array with arguments, you want the first element converted to int from.
     * @return The converted first element
     */
    public static int getNumberFromFirstArgument(String[] arguments) {
        if (arguments == null || arguments.length == 0) {
            throw new IllegalArgumentException("Empty arguments are not supported.");
        }

        return Integer.parseInt(arguments[0]);
    }
}
