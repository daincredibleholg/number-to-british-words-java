package net.h0lg.java.tests.number2words.helper;

import org.junit.Assert;
import org.junit.Test;

/**
 * Checks the StringFormatHelper is functioning as expected.
 */
public class StringFormatHelperTest {

    @Test
    public void addASpaceBeforeGivenValue () {
        String givenValue = "test";
        String stringToAdd = " ";
        String expected = stringToAdd + givenValue;
        checkAddBeforeIfNotEmptyWith(givenValue, stringToAdd, expected);
    }

    @Test
    public void addAnAndBeforeGivenValue () {
        String givenValue = "test";
        String stringToAdd = " and ";
        String expected = stringToAdd + givenValue;
        checkAddBeforeIfNotEmptyWith(givenValue, stringToAdd, expected);
    }

    @Test
    public void doesNothingWithEmptyString() {
        String givenValue = "";
        String stringToAdd = " this shouldn't get added ";
        String expected = givenValue;
        checkAddBeforeIfNotEmptyWith(givenValue, stringToAdd, expected);
    }

    @Test
    public void returnsNullIfNullIsGiven() {
        String givenValue = null;
        String stringToAdd = " this can't get added ";
        String expected = givenValue;
        checkAddBeforeIfNotEmptyWith(givenValue, stringToAdd, expected);
    }

    private void checkAddBeforeIfNotEmptyWith(String givenValue, String stringToAdd, String expectedResult) {
        String actual = StringFormatHelper.addBeforeIfNotEmpty(givenValue, stringToAdd);
        Assert.assertEquals(expectedResult, actual);
    }
}
