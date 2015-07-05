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

    public static String transform(int value) {
        return NUMBER_NAMES[value];
    }
}
