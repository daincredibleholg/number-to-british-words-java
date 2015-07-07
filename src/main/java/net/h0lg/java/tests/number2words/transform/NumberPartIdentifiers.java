package net.h0lg.java.tests.number2words.transform;

/**
 * Enumerates the parts of a number we have to process.
 *
 * The current max value supported is 999999999. This can be split
 * into three 3-digit numbers. Each of these 3-digit numbers are
 * pronounced similar (beside suffixes like "thousand" or "million").
 *
 * The parts are as follow (x marks the members of the 3-digit number):
 *
 *   * MILLIONS: xxx999999
 *   * HUNDRED_THOUSANDS: 999xxx999
 *   * THOUSANDS: 999999xxx
 *
 */
public enum NumberPartIdentifiers {
    MILLIONS(" million"),
    HUNDRED_THOUSANDS(" thousand"),
    THOUSANDS("");

    private String partsStringRepresentation;

    NumberPartIdentifiers(String partsStringRepresentation) {
        this.partsStringRepresentation = partsStringRepresentation;
    }

    public String getPartsStringRepresentation() {
        return partsStringRepresentation;
    }
}
