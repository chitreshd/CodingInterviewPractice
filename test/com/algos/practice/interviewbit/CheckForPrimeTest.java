package com.algos.practice.interviewbit;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by cdeshpande on 6/18/17.
 */
public class CheckForPrimeTest {
    @Test
    public void isPrime() throws Exception {

        assertEquals(1, new CheckForPrime().isPrime( 41443));
        assertEquals(0, new CheckForPrime().isPrime( 1));
        assertEquals(0, new CheckForPrime().isPrime( 84923));

    }

}