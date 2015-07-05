package net.h0lg.java.tests.number2words.helper;

import net.h0lg.java.tests.number2words.transform.NumberPartIdentifiers;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by holgersteinhauer on 05/07/15.
 */
public class NumberHelper {

    public static Map<NumberPartIdentifiers, Integer> splitIntoParts(int number) {
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

}
