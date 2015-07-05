package net.h0lg.java.tests.number2words.transform;

/**
 * Enumerates the parts of a number we have to process.
 */
public enum NumberPartIdentifiers {
    MILLIONS("million"),
    HUNDRED_THOUSANDS("thousand"),
    THOUSANDS("");

    private String partsStringRepresentation;

    NumberPartIdentifiers(String partsStringRepresentation) {
        this.partsStringRepresentation = partsStringRepresentation;
    }

    public String getPartsStringRepresentation() {
        return partsStringRepresentation;
    }
}
