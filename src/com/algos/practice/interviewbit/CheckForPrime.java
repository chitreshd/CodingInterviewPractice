package com.algos.practice.interviewbit;

/**
 * Created by cdeshpande on 6/18/17.
 */
public class CheckForPrime {

    public int isPrime(int a) {
        int upperBound = (int) Math.sqrt(a);
        if(a < 2)
            return 0;

        for(int i = 2; i <= upperBound; i++) {
            if(a % i == 0)
                return 0;
        }

        return 1;

    }
}
