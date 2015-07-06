package net.h0lg.java.tests.number2words;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests main application class implementation
 */
public class AppTest {

    private final App app = new App();

    @Test
    public void checkValidArguments () {
        String[] validArgs = { "2" };

        boolean actual = app.checkArgumentsAreValid(validArgs);

        Assert.assertTrue(actual);
    }

    @Test
    public void checkOtherValidArguments () {
        String[] validArgs = { "42" };

        boolean actual = app.checkArgumentsAreValid(validArgs);

        Assert.assertTrue(actual);
    }

    @Test
    public void checkEmptyArgumentsArray () {
        String[] emptyArgs = {};

        boolean actual = app.checkArgumentsAreValid(emptyArgs);

        Assert.assertFalse(actual);
    }

    @Test
    public void checkTooManyArguments () {
        String[] tooManyArgs = { "42", "21" };

        boolean actual = app.checkArgumentsAreValid(tooManyArgs);

        Assert.assertFalse(actual);
    }

    @Test
    public void checkNonNumericArgument () {
        String[] nonNumericArgs = { "a" };

        boolean actual = app.checkArgumentsAreValid(nonNumericArgs);

        Assert.assertFalse(actual);
    }

    @Test
    public void tooLowValueIsNotValid() {
        String[] argsWithTooLowValue = { Integer.toString(BoundaryChecker.LOWER_BOUNDARY) };

        boolean actual = app.checkArgumentsAreValid(argsWithTooLowValue);

        Assert.assertFalse(actual);
    }

    @Test
    public void tooHighValueIsNotValid () {
        String[] argsWithTooHighValue = { Integer.toString(BoundaryChecker.UPPER_BOUNDARY + 1) };

        boolean actual = app.checkArgumentsAreValid(argsWithTooHighValue);

        Assert.assertFalse(actual);
    }
}
