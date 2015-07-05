package net.h0lg.java.tests.number2words.transform;

import net.h0lg.java.tests.number2words.BoundaryChecker;
import net.h0lg.java.tests.number2words.helper.NumberHelper;
import net.h0lg.java.tests.number2words.helper.StringFormatHelper;

import java.util.Map;

/**
 * Main converter implementation.
 *
 * The only public method takes a number and converts it into
 * the british word representation.
 */
public class Number2WordsConverter {

    private static final String[] NUMBER_NAMES = {
            "",
            "one",
            "two",
            "three",
            "four",
            "five",
            "six",
            "seven",
            "eight",
            "nine",
            "ten",
            "eleven",
            "twelve",
            "thirteen",
            "fourteen",
            "fifteen",
            "sixteen",
            "seventeen",
            "eighteen",
            "nineteen"
    };

    private static final String[] TENNER_NAMES = {
            "",
            "ten",
            "twenty",
            "thirty",
            "forty",
            "fifty",
            "sixty",
            "seventy",
            "eighty",
            "ninety"
    };

    public static String convert(int value) {
        // Ensure value is within boundaries.
        BoundaryChecker.checkBoundaries(value);

        Map<NumberPartIdentifiers, Integer> numberParts = NumberHelper.splitIntoParts(value);

        String result = processNumberParts(numberParts);
        return result;
    }

    private static String processNumberParts(Map<NumberPartIdentifiers, Integer> numberParts) {
        String result = "";

        for (NumberPartIdentifiers part : NumberPartIdentifiers.values()) {
            if (numberParts.get(part) > 1) {
                result = StringFormatHelper.addAfterIfNotEmpty(result, " and ");
                result += convertLessThanOneThousand(numberParts.get(part));
                result = StringFormatHelper.addAfterIfNotEmpty(result, part.getPartsStringRepresentation());
            } else if (numberParts.get(part) == 1) {
                // one is a special case, we have to take care of
                result += NUMBER_NAMES[1];
                result = StringFormatHelper.addAfterIfNotEmpty(result, part.getPartsStringRepresentation());
            }
        }

        return result;
    }

    private static String convertLessThanOneThousand(int number) {
        String currentValue;

        if (number % 100 < 20) {
            currentValue = NUMBER_NAMES[number % 100];
            number /= 100;
        } else {
            currentValue = NUMBER_NAMES[number % 10];
            number /= 10;

            currentValue = StringFormatHelper.addBeforeIfNotEmpty(currentValue, " ");

            currentValue = TENNER_NAMES[number % 10] + currentValue;
            number /= 10;
        }

        if (number == 0) return currentValue;

        currentValue = StringFormatHelper.addBeforeIfNotEmpty(currentValue, " and ");
        return NUMBER_NAMES[number] + " hundred" + currentValue;
    }

}
