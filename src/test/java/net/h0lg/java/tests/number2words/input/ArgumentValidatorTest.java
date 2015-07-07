package net.h0lg.java.tests.number2words.input;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test cases for the argument validator.
 */
public class ArgumentValidatorTest {

    @Test
    public void validInputIsParsed () {
        int validInputValue = 21;
        checkValidInput(validInputValue);
    }

    @Test
    public void anotherValidInputIsParsed () {
        int validInputValue = 42;
        checkValidInput(validInputValue);
    }

    @Test
    public void moreThanOneArgumentReturnsInputWithFaultyFlagSet () {
        int validInputValue = 42;

        String[] invalidInput = createArgumentArray(validInputValue, validInputValue);
        UserInput actualInput = ArgumentValidator.process(invalidInput);

        Assert.assertTrue(actualInput.isFaulty());
    }

    @Test
    public void emptyArgumentArrayIsHandled() {
        String[] invalidInput = {};
        UserInput actualInput = ArgumentValidator.process(invalidInput);

        Assert.assertTrue(actualInput.isFaulty());
    }

    @Test
    public void lowerBoundIsCheckedCorrectly() {
        int lowerBoundValue = 0;
        String[] invalidInput = createArgumentArray(lowerBoundValue);
        UserInput actualInput = ArgumentValidator.process(invalidInput);

        Assert.assertTrue(actualInput.isFaulty());
    }

    /**
     * Checks if the UserInput returned for a given, valid (!) input correct. It is correct
     * when the returned instance contains the input as value and the faulty flag is set to
     * false.
     *
     * @param input The valid value to test.
     */
    private void checkValidInput(int input) {
        boolean expectedFaulty = false;

        String[] arguments = createArgumentArray(input);
        UserInput expectedInput = new UserInput(input, expectedFaulty);
        UserInput actualInput = ArgumentValidator.process(arguments);

        Assert.assertEquals(expectedInput, actualInput);
    }

    /**
     * Returns an String array for all given integers.
     *
     * @param inputValues n int values, you need a String array for.
     * @return String array with all given int values as Strings.
     */
    private String[] createArgumentArray (int... inputValues) {
        String[] input = new String[inputValues.length];
        for (int i = 0; i < inputValues.length; i++) {
            input[i] = Integer.toString(inputValues[i]);
        }

        return input;
    }
}
