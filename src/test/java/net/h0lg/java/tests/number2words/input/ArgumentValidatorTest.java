package net.h0lg.java.tests.number2words.input;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test cases for the argument validator.
 */
public class ArgumentValidatorTest {

    @Test
    public void validInputIsParsed () {
        int validInputValue = 2;
        boolean expectedFaultyState = false;

        String[] validInput = { Integer.toString(validInputValue) };
        UserInput expectedInput = new UserInput(validInputValue, expectedFaultyState);

        UserInput actualInput = ArgumentValidator.process(validInput);

        Assert.assertEquals(expectedInput, actualInput);
    }

}
