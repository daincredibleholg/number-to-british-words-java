package net.h0lg.java.tests.number2words;


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
        int givenNumber = getNumberFromArguments(args);
    }

    private int getNumberFromArguments(String[] args) {
        int number = 0;
        if (args != null && args.length > 0) {
            number = Integer.parseInt(args[0]);
        }

        return number;
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
            int argumentAsInteger = Integer.parseInt(args[0]);
            BoundaryChecker.checkBoundaries(argumentAsInteger);
        } catch (IllegalArgumentException e) {
            result = false;
        }

        return result;
    }

    private boolean firstArgumentIsANumber(String[] args) {
        boolean result = true;

        try {
            int argumentAsInteger = Integer.parseInt(args[0]);
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
