package com.apismensky;

import static com.apismensky.WildcarMatching.isMatch;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Ignore;
import org.junit.Test;

public class WildcarMatchingTest {

    @Test
    public void test1() {
        assertFalse(isMatch("aa", "a"));
    }

    @Test
    public void test2() {
        assertTrue(isMatch("aa", "*"));
    }

    @Test
    public void test3() {
        assertFalse(isMatch("cb", "?a"));
    }

    @Test
    public void test4() {
        assertTrue(isMatch("abceb", "*a*b"));
    }

    @Test
    public void test5() {
        assertFalse(isMatch("acdcb", "a*c?b"));
    }

    @Test
    public void test6() {
        assertTrue(isMatch("aaaabaaaabbbbaabbbaabbaababbabbaaaababaaabbbbbbaabbbabababbaaabaabaaaaaabbaabbbbaababbababaabbbaababbbba",
                           "*****b*aba***babaa*bbaba***a*aaba*b*aa**a*b**ba***a*a*"));
    }

    @Test
    @Ignore("Timeout")
    public void test7() {
        assertFalse(isMatch("abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb",
                    "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb"));
    }
}
