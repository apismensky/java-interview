package com.apismensky;
import org.junit.Test;

import static com.apismensky.ReconstructDigits.originalDigits;
import static org.junit.Assert.assertEquals;

public class ReconstructDigitsTest {

    @Test(expected = NullPointerException.class)
    public void testNull() {
        originalDigits(null);
    }

    @Test
    public void testEmpty() {
        assertEquals("", originalDigits(""));
    }

    @Test
    public void test0() {
        assertEquals("0", originalDigits("orze"));
    }

    @Test
    public void test4() {
        assertEquals("4", originalDigits("rouf"));
    }

    @Test
    public void test8() {
        assertEquals("8", originalDigits("heigt"));
    }

    @Test
    public void test08() {
        assertEquals("08", originalDigits("heigtorze"));
    }

    @Test
    public void test3() {
        assertEquals("3", originalDigits("ereht"));
    }

    @Test
    public void test012() {
        assertEquals("012", originalDigits("owoztneoer"));
    }

    @Test
    public void test45() {
        assertEquals("45", originalDigits("fviefuro"));
    }

}
