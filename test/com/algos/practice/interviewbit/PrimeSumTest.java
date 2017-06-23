package com.algos.practice.interviewbit;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by cdeshpande on 6/19/17.
 */
public class PrimeSumTest {
    PrimeSum solve = new PrimeSum();
    @Test
    public void primesum() throws Exception {
        System.out.println(solve.primesum(15));
        System.out.println(solve.primesum(4));
        System.out.println(solve.primesum(10));


    }

    @Test
    public void getLexicographicallyFirst() throws Exception {

    }

    @Test
    public void getAllPrimes() throws Exception {
        System.out.println(solve.getAllPrimes(15));


    }

}