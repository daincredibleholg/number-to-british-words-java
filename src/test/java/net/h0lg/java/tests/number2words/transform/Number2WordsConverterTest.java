package net.h0lg.java.tests.number2words.transform;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Tests the central implementation of this app - the converter logic from a given number
 * to a british words representation.
 *
 */
public class Number2WordsConverterTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

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

    @Test
    public void checkZeroIsNotProcessed() {
        expectedException.expect(IllegalArgumentException.class);
        Number2WordsConverter.convert(0);
    }

    /**
     * Checks if Number2WordsConverter returns expectedOutput for given number
     * validInput.
     *
     * @param validInput Number to convert
     * @param expectedOutput Expected result from Number2WordsConverter.convert()
     */
    private void checkValidInput (int validInput, String expectedOutput) {
        String actual = Number2WordsConverter.convert(validInput);
        Assert.assertEquals(expectedOutput, actual);
    }
}
