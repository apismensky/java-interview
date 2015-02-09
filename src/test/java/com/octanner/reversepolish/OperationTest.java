package com.octanner.reversepolish;

import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OperationTest {
    @Test
    public void testMinus() {
        Operation operation = Operation.value("-");
        assertEquals(Operation.MINUS, operation);
        assertEquals(-1, operation.getAction().apply(4, 5));
    }

    @Test
    public void testPlus() {
        Operation operation = Operation.value("+");
        assertEquals(Operation.PLUS, operation);
        assertEquals(2, operation.getAction().apply(1, 1));
    }

    @Test
    public void testDiv() {
        Operation operation = Operation.value("/");
        assertEquals(Operation.DIV, operation);
        assertEquals(3, operation.getAction().apply(15, 5));
    }

    @Test
    public void testMult() {
        Operation operation = Operation.value("*");
        assertEquals(Operation.MULT, operation);
        assertEquals(35, operation.getAction().apply(5, 7));
    }

    @Test
    public void testEmpty() {
        TestCase.assertNull(Operation.value(null));
    }

    @Test
    public void testDigit() {
        TestCase.assertNull(Operation.value("1"));
    }
}
