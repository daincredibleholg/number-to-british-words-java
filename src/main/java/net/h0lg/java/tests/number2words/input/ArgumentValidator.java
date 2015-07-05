package net.h0lg.java.tests.number2words.input;

import net.h0lg.java.tests.number2words.BoundaryChecker;

/**
 * Validator class for command line arguments.
 */
public class ArgumentValidator {

    private static final int FAULTY_DEFAULT_VALUE = -1;

    /**
     * This method return an instance of UserInput with a valid value, if
     *  a) the given arguments array contains only one element and
     *  b) the only element is an integer between 0 and 999,999,999.
     *
     * If the given requirements are not met, the returned UserInput will be marked
     * as faulty (@see UserInput.isFaulty()).
     *
     * @param arguments Array with arguments to check
     * @return UserInput instance as described above.
     */
    public static UserInput process(String[] arguments) {

        try {
            checkArguments(arguments);

            int value = Integer.parseInt(arguments[0]);
            BoundaryChecker.checkBoundaries(value);

            return new UserInput(value, false);
        } catch (IllegalArgumentException e) {
            return new UserInput(FAULTY_DEFAULT_VALUE, true);
        }
    }

    /**
     * Checks the given array contains exact one element and throws an IllegalArgumentException
     * if this isn't the case.
     *
     * @param arguments String array to check
     * @throws IllegalArgumentException
     */
    private static void checkArguments(String[] arguments) throws IllegalArgumentException {
        if (arguments == null || arguments.length ==0 ||  arguments.length > 1) {
            throw new IllegalArgumentException("Only exact one argument is supported.");
        }
    }

}
