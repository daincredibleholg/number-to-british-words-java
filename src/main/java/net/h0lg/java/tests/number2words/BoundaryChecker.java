package net.h0lg.java.tests.number2words;

/**
 * Provides boundary checks, lower (exclusive) and upper (inclusive)
 * boundaries and the 0-padding mask for the upper boundary.
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
     * 0-pad template for number-to-0-padded-string conversion.
     * This is not the optimal place for this padding. But at
     * least changes to the upper boundaries can now be done in
     * one place (regarding checks and 0-padding).
     */
    public static final String UPPER_BOUNDARY_PADDING_MASK = "000000000";


    /**
     * Checks given value is greater LOWER_BOUNDARY and not greater than UPPER_BOUNDARY.
     * If the value is not within these boundaries, the method throws an IllegalArgumentException.
     *
     * @param value Value to check
     * @throws IllegalArgumentException
     */
    public static void checkBoundaries(int value) throws IllegalArgumentException {
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
