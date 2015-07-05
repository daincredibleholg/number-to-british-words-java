package net.h0lg.java.tests.number2words.input;

/**
 * This class will check a given String array if
 *   a) it only contains one element and
 *   b) the only element is an integer between 0 and 999,999,999.
 * If both requirements are met, the main method process() returns a UserInput instance
 * with the fount int value. Otherwise the value will in the UserInput instance will -1
 * and the faulty flag is set.
 */
public class ArgumentValidator {

    private static final int FAULTY_DEFAULT_VALUE = -1;

    public static UserInput process(String[] arguments) {

        try {
            checkArguments(arguments);
            int value = Integer.parseInt(arguments[0]);
            return new UserInput(value, false);
        } catch (IllegalArgumentException e) {
            return new UserInput(FAULTY_DEFAULT_VALUE, true);
        }
    }

    private static void checkArguments(String[] arguments) throws IllegalArgumentException {
        if (arguments == null || arguments.length > 1) {
            throw new IllegalArgumentException("Only exact one argument is supported.");
        }
    }


}
