package net.h0lg.java.tests.number2words.helper;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by holgersteinhauer on 05/07/15.
 */
public class StringFormatHelperTest {

    @Test
    public void addASpaceBeforeGivenValue () {
        String givenValue = "test";
        String stringToAdd = " ";
        String expected = stringToAdd + givenValue;

        String actual = StringFormatHelper.addBeforeIfNotEmpty(givenValue, stringToAdd);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addAnAndBeforeGivenValue () {
        String givenValue = "test";
        String stringToAdd = " and ";
        String expected = stringToAdd + givenValue;

        String actual = StringFormatHelper.addBeforeIfNotEmpty(givenValue, stringToAdd);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void doesNothingWithEmptyString () {
        String givenValue = "";
        String stringToAdd = " this shouldn't get added ";
        String expected = givenValue;

        String actual = StringFormatHelper.addBeforeIfNotEmpty(givenValue, stringToAdd);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void returnsNullIfNullIsGiven () {
        String givenValue = null;
        String stringToAdd = " this can't get added ";
        String expected = givenValue;

        String actual = StringFormatHelper.addBeforeIfNotEmpty(givenValue, stringToAdd);

        Assert.assertEquals(expected, actual);
    }
}
