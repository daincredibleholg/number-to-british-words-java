package net.h0lg.java.tests.number2words.integrationtest;

import net.h0lg.java.tests.number2words.App;
import net.h0lg.java.tests.number2words.BoundaryChecker;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * This class contains a couple of simple integration tests.
 * <p/>
 * If one starts a Java command line application, the main() method gets
 * called and all arguments are handed in to it.
 * So to simulate a program call, we call the main method and check the
 * output.
 * <p/>
 * In more complex scenarios, where a lot of services and applications
 * are working together, more sophisticated integration tests are needed,
 * but this approach should be just right for this simple application.
 */
public class Number2WordsIT {

    private ByteArrayOutputStream baos;
    private PrintStream printStream;

    @Before
    public void initCharacterDevice() {
        this.baos = new ByteArrayOutputStream();
        this.printStream = new PrintStream(baos);
        System.setOut(this.printStream);
    }

    @Test
    public void checkUsageOutput() {
        StringBuilder expectedOutput = new StringBuilder();
        expectedOutput.append("Usage: This program converts numbers between ")
                .append(BoundaryChecker.LOWER_BOUNDARY + 1)
                .append(" and ")
                .append(BoundaryChecker.UPPER_BOUNDARY)
                .append(" into british words. (E.g. 42 get converted to 'forty two')\n")
                .append("Usage:\n")
                .append("\tjava -jar number2words.jar <number>")
                .append(System.lineSeparator());
        String[] emptyStringArray = {};

        App.main(emptyStringArray);

        String actual = baos.toString();

        Assert.assertEquals(expectedOutput.toString(), actual);
    }

    @Test
    public void checkNumberTransformation() {
        String expectedOutput = "forty two" + System.lineSeparator();
        String[] args = { "42" };

        App.main(args);

        String actual = baos.toString();

        Assert.assertEquals(expectedOutput, actual);
    }

    @Test
    public void checkInvalidArgumentCountOutput () {
        String[] args = { "1", "2", "3"};

        App.main(args);

        /*
         The correct usage string gets tested elsewhere, so we only want to know
          if in case more than one argument is given, the output starts with
          "Usage:".
        */
        boolean outputStartsWithUsage = baos.toString().startsWith("Usage:");

        Assert.assertTrue(outputStartsWithUsage);
    }
}
