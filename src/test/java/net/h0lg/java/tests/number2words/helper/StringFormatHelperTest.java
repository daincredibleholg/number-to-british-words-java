package net.h0lg.java.tests.number2words.helper;

import net.h0lg.java.tests.number2words.BoundaryChecker;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Checks the StringFormatHelper is functioning as expected.
 */
public class StringFormatHelperTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

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

    @Test
    public void returnOriginalValueIfNullShouldBeAddedInFront () {
        String givenValue = "perfectly fine string";
        String stringToAdd = null;
        String expected = givenValue;
        checkAddBeforeIfNotEmptyWith(givenValue, stringToAdd, expected);
    }

    @Test
    public void zeroPaddingForSmallValueWorks () {
        int givenValue = 42;
        String expected = "000000042";

        String actual = StringFormatHelper.zeroPadNumber(givenValue);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void zeroPaddingForBiggerValueWorks () {
        int givenValue = 123456;
        String expected = "000123456";

        String actual = StringFormatHelper.zeroPadNumber(givenValue);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addAnAndAfterGivenValue () {
        String givenValue = "test";
        String stringToAdd = " and ";
        String expected = givenValue + stringToAdd;
        checkAddAfterIfNotEmptyWith(givenValue, stringToAdd, expected);
    }

    @Test
    public void nothingGetsAddedToTheEndOfAnEmptyString() {
        String givenValue = "";
        String stringToAdd = " this shouldn't get added ";
        String expected = givenValue;
        checkAddAfterIfNotEmptyWith(givenValue, stringToAdd, expected);
    }

    @Test
    public void tryToAddStringAtTheEndOfNullReturnsNull() {
        String givenValue = null;
        String stringToAdd = " this can't get added ";
        String expected = givenValue;
        checkAddAfterIfNotEmptyWith(givenValue, stringToAdd, expected);
    }

    @Test
    public void addingNullToStringReturnsOriginalString() {
        String givenValue = "non empty string";
        String stringToAdd = null;
        String expected = givenValue;
        checkAddAfterIfNotEmptyWith(givenValue, stringToAdd, expected);
    }

    private void checkAddBeforeIfNotEmptyWith(String givenValue, String stringToAdd, String expectedResult) {
        String actual = StringFormatHelper.addBeforeIfNotEmpty(givenValue, stringToAdd);
        Assert.assertEquals(expectedResult, actual);
    }


    private void checkAddAfterIfNotEmptyWith(String givenValue, String stringToAdd, String expectedResult) {
        String actual = StringFormatHelper.addAfterIfNotEmpty(givenValue, stringToAdd);
        Assert.assertEquals(expectedResult, actual);
    }

}
