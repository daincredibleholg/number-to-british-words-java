package net.h0lg.java.tests.number2words;

/**
 * Provides boundary checks.
 *
 */
public class BoundaryChecker {

    /**
     * Values lower or equal are not below the supported numbers
     */
    public static final int LOWER_BOUNDARY = 0;
    /**
     * Values higher exceed the supported numbers
     */
    public static final int UPPER_BOUNDARY = 999999999;


    /**
     * Checks given value is greater LOWER_BOUNDARY and not greater than UPPER_BOUNDARY.
     * If the value is not within these boundaries, the method throws an IllegalArgumentException.
     *
     * @param value Value to check
     * @throws IllegalArgumentException
     */
    public static void checkBoundaries (int value) throws IllegalArgumentException {
        if (value <= LOWER_BOUNDARY) {
            throw new IllegalArgumentException(
                    "Given value (" + value + ") comes below supported numbers. Value must be > " + LOWER_BOUNDARY);
        }

        if (value > UPPER_BOUNDARY) {
            throw new IllegalArgumentException(
                    "Given value (" + value + ") exceeds supported numbers. Value must be <= " + UPPER_BOUNDARY);
        }
    }
}
