package net.h0lg.java.tests.number2words.helper;

import net.h0lg.java.tests.number2words.transform.NumberPartIdentifiers;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Tests the NumberHelper implementation.
 *
 * Note: I skipped the boundary checks as they are done during 0-pad processing (see StringFormatHelper.zeroPadNumber()).
 */
public class NumberHelperTest {

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
