import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

public class CalculatorTest {


    @Test
    @DisplayName("Ensure correct handling of 1 basic operation")
    public void testAddition() {
        assertEquals("5/6", Calculator.solve("1/2 + 1/3"), "Simple addition should work properly");
    }

    @Test
    @DisplayName("Ensure correct handling of 1 basic operation")
    public void testSubtraction() {
        assertEquals("-543/40", Calculator.solve("4/5 - 115/8"), "Simple subtraction should work properly");
    }

    @Test
    @DisplayName("Ensure correct handling of 1 basic operation")
    public void testMultiplication() {
        assertEquals("-25/54", Calculator.solve("5/6 * -5/9"), "Simple multiplication should work properly");
    }

    @Test
    @DisplayName("Ensure correct handling of 1 basic operation")
    public void testDivision() {
        assertEquals("-3/2", Calculator.solve("5/6 : -5/9"), "Simple division should work properly");
    }

    @Test
    public void testComplexExpressionEqualP() {
        assertEquals("11/18", Calculator.solve("5/8 - 8/9 + 7/8"), "Complex expression should be calculated accurately");
    }

    @Test
    public void testComplexExpressionUnequalP() {
        assertEquals("103/72", Calculator.solve("5/8 * 8/9 + 7/8"), "Complex expression should be calculated accurately");
        assertEquals("-11/72", Calculator.solve("5/8 - 8/9 * 7/8"), "Complex expression should be calculated accurately");
    }

    @Test
    public void testIllegalExpression() {
        Assertions.assertThrows(NumberFormatException.class, () -> Calculator.solve("5/6 +_ 8/7"), "Exception expected to be thrown");
    }


    @Test
    public void testZeroDen() {                                                                                        //lambda: (parameters) -> (method code)
        Fraction.ZeroDenominatorException exception = assertThrows(Fraction.ZeroDenominatorException.class, () -> {
            Calculator.solve("9/0 + 7/4");
        });
        assertEquals("ERROR -> denominator can't be zero", exception.getMessage(), "Exception expected to be thrown");
    }

    @Test
    public void testZeroFraction() {
        Fraction.ZeroDenominatorException exception = assertThrows(Fraction.ZeroDenominatorException.class, () -> {
            Calculator.solve("9/10 : 0/0");
        });
        assertEquals("ERROR -> denominator can't be zero", exception.getMessage(), "Exception expected to be thrown");
    }
}