package net.h0lg.java.tests.number2words.transform;

/**
 * Main converter implementation.
 *
 * The only public method takes a number and converts it into
 * the british word representation.
 * 
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
        String result = convertLessThanOneThousand(value);

        return result;
    }

    private static String convertLessThanOneThousand (int number) {
        String currentValue;

        if (number % 100 < 20) {
            currentValue = NUMBER_NAMES[number % 100];
            number /= 100;
        } else {
            currentValue = NUMBER_NAMES[number % 10];
            number /= 10;

            currentValue = addStringIfNotEmpty(currentValue, " ");

            currentValue = TENNER_NAMES[number % 10] + currentValue;
            number /= 10;
        }
        if (number == 0) return currentValue;

        currentValue = addStringIfNotEmpty(currentValue, " and ");
        return NUMBER_NAMES[number] + " hundred" + currentValue;
    }

    private static String addStringIfNotEmpty(String value, String stringToAdd) {
        String result = value;

        if (!result.isEmpty()) {
            result = stringToAdd + result;
        }

        return result;
    }
}
