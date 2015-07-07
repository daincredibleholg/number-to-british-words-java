package net.h0lg.java.tests.number2words;


import net.h0lg.java.tests.number2words.helper.NumberHelper;
import net.h0lg.java.tests.number2words.transform.Number2WordsConverter;

/**
 * This class is just the entry point for the application
 *
 */
public class App 
{

    public static void main( String[] args )
    {
        App app = new App();
        app.start(args);
    }

    private void start(String[] args) {
        if (!checkArgumentsAreValid(args)) {
            showUsage();
        } else {
            convertNumberFromArgs(args);
        }
    }

    private void convertNumberFromArgs(String[] args) {
        int givenNumber = NumberHelper.getNumberFromFirstArgument(args);
        String representation = Number2WordsConverter.convert(givenNumber);
        System.out.println(representation);
    }

    private void showUsage() {
        StringBuilder usageMsg = new StringBuilder();

        usageMsg.append("This program converts numbers between ")
                .append(BoundaryChecker.LOWER_BOUNDARY + 1)
                .append(" and ")
                .append(BoundaryChecker.UPPER_BOUNDARY)
                .append(" into british words. (E.g. 42 get converted to 'forty two')\n")
                .append("Usage:\n")
                .append("\tjava -jar number2words.jar <number>");

        System.out.println(usageMsg);
    }

    protected boolean checkArgumentsAreValid(String[] args) {

        if (exactOneArgumentGiven(args) && firstArgumentIsANumber(args) && givenArgumentIsWithinBoundaries(args)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean givenArgumentIsWithinBoundaries(String[] args) {
        boolean result = true;

        try {
            int argumentAsInteger = NumberHelper.getNumberFromFirstArgument(args);
            BoundaryChecker.checkBoundaries(argumentAsInteger);
        } catch (IllegalArgumentException e) {
            result = false;
        }

        return result;
    }

    private boolean firstArgumentIsANumber(String[] args) {
        boolean result = true;

        try {
            NumberHelper.getNumberFromFirstArgument(args);
        } catch (NumberFormatException e) {
            result = false;
        }

        return result;
    }

    private boolean exactOneArgumentGiven(String[] args) {
        boolean result = true;

        if (args == null || args.length != 1) {
            result = false;
        }

        return result;
    }
}
