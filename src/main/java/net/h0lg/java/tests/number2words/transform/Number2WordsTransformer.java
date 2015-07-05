package net.h0lg.java.tests.number2words.transform;

/**
 * Created by holgersteinhauer on 05/07/15.
 */
public class Number2WordsTransformer {

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

    public static String transform(int value) {
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

            if (!currentValue.isEmpty()) {
                currentValue = " " + currentValue;
            }

            currentValue = TENNER_NAMES[number % 10] + currentValue;
            number /= 10;
        }
        if (number == 0) return currentValue;

        if (!currentValue.isEmpty()) {
            currentValue = " and " + currentValue;
        }
        return NUMBER_NAMES[number] + " hundred" + currentValue;
    }
}
