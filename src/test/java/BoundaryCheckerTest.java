import net.h0lg.java.tests.number2words.BoundaryChecker;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Tests the boundary checks provided by BoundaryChecker
 */
public class BoundaryCheckerTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void doesNotThrowExceptionIfValidValueIsGiven() {
        int validValue = 42;

        BoundaryChecker.checkBoundaries(validValue);

        // This line gets only executed if no exception was thrown.
        Assert.assertTrue(true);
    }

    @Test
    public void upperBoundaryIsInclusive() {
        int validValue = BoundaryChecker.UPPER_BOUNDARY;
        BoundaryChecker.checkBoundaries(validValue);

        // This line gets only executed if no exception was thrown.
        Assert.assertTrue(true);
    }

    @Test
    public void throwsExceptionIfValueExceedsUpperBoundary() {
        int tooBigValue = BoundaryChecker.UPPER_BOUNDARY + 1;

        expectedException.expect(IllegalArgumentException.class);
        BoundaryChecker.checkBoundaries(tooBigValue);
    }

    @Test
    public void lowerBoundaryIsExclusive() {
        int tooSmallValue = BoundaryChecker.LOWER_BOUNDARY;

        expectedException.expect(IllegalArgumentException.class);
        BoundaryChecker.checkBoundaries(tooSmallValue);
    }

    @Test
    public void throwsExceptionForNegativeValues() {
        int negative = -42;

        expectedException.expect(IllegalArgumentException.class);
        BoundaryChecker.checkBoundaries(negative);
    }
}
