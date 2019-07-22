package com.apismensky;

import static com.apismensky.TernaryExpressionParser.parseTernary;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TernaryExpressionParserTest {

    @Test
    public void test1() {
        assertEquals("2", parseTernary("T?2:3"));
    }

    @Test
    public void test2() {
        assertEquals("4", parseTernary("F?1:T?4:5"));
    }

    @Test
    public void test3() {
        assertEquals("F", parseTernary("T?T?F:5:3"));
    }

    @Test
    public void test4() {
        assertEquals("T", parseTernary("T?T:F?T?1:2:F?3:4"));
    }

    @Test
    public void test5() {
        assertEquals("8", parseTernary("T?8:F?7:6"));
    }

    @Test
    public void test6() {
        assertEquals("8", parseTernary("T?8:F?7:F?F?T?4:8:6:6"));
    }

    @Test
    public void test7() {
        assertEquals("F", parseTernary("F?F?3:8:T?F:T?0:F?8:T?T?F?F?0:T?5:3:T?F?F:F?F?7:6:0:F?F?F?T?0:T?7:6:6:8:F:T:F?F?F?T?0:T:T?T?9:F?T?T?2:T?F?8:T?7:0:T:T?6:F?3:F?F?F:9:9:5:2:7:T?8:F?6:T?6:F?9:T?T?2:T:F?F?F?9:2:T?0:2:T?T?F?F?9:1:T?3:F?4:F:0:5"));
    }
}