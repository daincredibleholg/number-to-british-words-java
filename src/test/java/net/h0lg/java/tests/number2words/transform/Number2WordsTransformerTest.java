package net.h0lg.java.tests.number2words.transform;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by holgersteinhauer on 05/07/15.
 */
public class Number2WordsTransformerTest {

    @Test
    public void smallPositiveIntegerGetsTransformed () {
        int validInput = 2;
        String expected = "two";

        String actual = Number2WordsTransformer.transform(validInput);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void anotherSmallPositiveNumberGetsTransformed () {
        int validInput = 12;
        String expected = "twelve";

        String actual = Number2WordsTransformer.transform(validInput);

        Assert.assertEquals(expected, actual);
    }
}
