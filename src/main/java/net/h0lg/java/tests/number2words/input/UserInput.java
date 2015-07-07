package net.h0lg.java.tests.number2words.input;

/**
 * Simple data holder for (processed) user input.
 *
 */
public class UserInput {
    private int value;
    private boolean faulty;

    public UserInput(int value, boolean faulty) {
        this.value = value;
        this.faulty = faulty;
    }

    public void setValue(int arguments) {
        this.value = arguments;
    }

    public void setError(boolean faulty) {
        this.faulty = faulty;
    }

    public int getValue() {
        return value;
    }

    public boolean isFaulty() {
        return faulty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserInput userInput = (UserInput) o;

        if (value != userInput.value) return false;
        return faulty == userInput.faulty;

    }

    @Override
    public int hashCode() {
        int result = value;
        result = 31 * result + (faulty ? 1 : 0);
        return result;
    }
}
