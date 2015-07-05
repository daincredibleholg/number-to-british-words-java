package net.h0lg.java.tests.number2words.transform;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by holgersteinhauer on 05/07/15.
 */
public class Number2WordsTransformerTest {

    @Test
    public void checkOneGetsConverted () {
        int validInput = 1;
        String expected = "one";
        checkValidInput(validInput, expected);
    }

    @Test
    public void checkTwentyOneGetsConverted () {
        int validInput = 21;
        String expected = "twenty one";
        checkValidInput(validInput, expected);
    }

    @Test
    public void checkSixtyGetsTransformed() {
        int validInput = 60;
        String expected = "sixty";
        checkValidInput(validInput, expected);
    }

    @Test
    public void checkHundredAndFiveGetsConverted() {
        int validInput = 105;
        String expected = "one hundred and five";
        checkValidInput(validInput, expected);
    }

    /**
     * Checks if Number2WordsTransformer returns expectedOutput for given number
     * validInput.
     *
     * @param validInput Number to convert
     * @param expectedOutput Expected result from Number2WordsTransformer.transform()
     */
    private void checkValidInput (int validInput, String expectedOutput) {
        String actual = Number2WordsTransformer.transform(validInput);
        Assert.assertEquals(expectedOutput, actual);
    }
}
