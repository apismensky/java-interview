import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * StringCalculatorTest
 * User: michael.felix
 * Date: 11/10/14
 */
public class StringCalculatorTest {
    @Test
    public void acceptsEmptyString(){
        int sum = sumForString("");
        assertEquals(0, sum);
    }

    @Test
    public void hasOneValue() {
        int sum = sumForString("1");
        assertEquals(1, sum);
    }

    @Test
    public void handlesCommaString() {
        int sum = sumForString("4,7");
        assertEquals(11, sum);
    }

    private int sumForString(String string) {
        StringCalculator calc = new StringCalculator();
        return calc.add(string);
    }
}
