package com.algos.practice.leetcode.hard;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test class for StrongPasswordChecker
 * Created by cdeshpande on 4/6/17.
 */
public class StrongPasswordCheckerTest {
    
    private StrongPasswordChecker checker = new StrongPasswordChecker();

    @Test
    public void testForLessThanLengthCases() {
        /*assertEquals(2, checker.strongPasswordChecker("abcd"));
        assertEquals(2, checker.strongPasswordChecker("abcdef"));
        assertEquals(2, checker.strongPasswordChecker("aaaaaa"));
        assertEquals(6, checker.strongPasswordChecker(""));
        assertEquals(2, checker.strongPasswordChecker("aaa111"));*/
        assertEquals(3, checker.strongPasswordChecker("..."));
    }

    @Test
    public void testForGreaterThanLengthCases() {
        // TODO: Since deleting the last character removes one repeat, the min should be 7 but current algo gives out 8.
        assertEquals(7, checker.strongPasswordChecker("aaaaaaaaaaaaaaaaaaaaa"));
        assertEquals(3, checker.strongPasswordChecker("ababababababababababa"));
        assertEquals(2, checker.strongPasswordChecker("1010101010aaaB10101010"));
    }
}
