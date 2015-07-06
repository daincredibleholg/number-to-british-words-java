package net.h0lg.java.tests.number2words.helper;

import net.h0lg.java.tests.number2words.transform.NumberPartIdentifiers;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.HashMap;
import java.util.Map;

/**
 * Tests the NumberHelper implementation.
 *
 * Note: I skipped the boundary checks as they are done during 0-pad processing (see StringFormatHelper.zeroPadNumber()).
 */
public class NumberHelperTest {

    @Rule
    public
    ExpectedException expectedException = ExpectedException.none();

    @Test
    public void valueInHundredsIsOk() {
        int validValue = 142;
        checkValidSplitIntoPartsNumbers(validValue, 142, 0, 0);
    }

    @Test
    public void valueInTenThousandsIsOk() {
        int validValue = 42021;
        checkValidSplitIntoPartsNumbers(validValue, 21, 42, 0);
    }

    @Test
    public void valueInMillionsIsOk() {
        int validValue = 420042021;
        checkValidSplitIntoPartsNumbers(validValue, 21, 42, 420);
    }

    @Test
    public void validNumberAsOnlyElementInArray() {
        int expectedValue = 42;
        String[] args = { Integer.toString(expectedValue) };

        int actualValue = NumberHelper.getNumberFromFirstArgument(args);

        Assert.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void anotherValidNumberAsOnlyElementInArray() {
        int expectedValue = 21;
        String[] args = { Integer.toString(expectedValue) };

        int actualValue = NumberHelper.getNumberFromFirstArgument(args);

        Assert.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void emptyArgumentsShouldLeadToAnException () {
        String[] emptyArgs = {};

        expectedException.expect(IllegalArgumentException.class);
        NumberHelper.getNumberFromFirstArgument(emptyArgs);

    }

    @Test
    public void firstElementReturnedEvenIfMultipleElementsAvailable() {
        int expectedValue = 23;
        String[] multiArgs = { Integer.toString(expectedValue), "42" };

        int actualValue = NumberHelper.getNumberFromFirstArgument(multiArgs);

        Assert.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getNumberFromFirstArgumentIsNullSafe() {
        String[] nullArgs = null;

        expectedException.expect(IllegalArgumentException.class);
        NumberHelper.getNumberFromFirstArgument(nullArgs);
    }

    private void checkValidSplitIntoPartsNumbers(
            int validNumber, int expectedThousands, int expectedHundredThousands, int expectedMillions) {

        Map<NumberPartIdentifiers, Integer> expected = new HashMap<>();
        expected.put(NumberPartIdentifiers.THOUSANDS, expectedThousands);
        expected.put(NumberPartIdentifiers.HUNDRED_THOUSANDS, expectedHundredThousands);
        expected.put(NumberPartIdentifiers.MILLIONS, expectedMillions);

        Map<NumberPartIdentifiers, Integer> actual = NumberHelper.splitIntoParts(validNumber);

        Assert.assertEquals(expected, actual);
    }
}
