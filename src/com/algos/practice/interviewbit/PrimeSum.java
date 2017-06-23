package com.algos.practice.interviewbit;

import java.util.*;

/**
 * Created by cdeshpande on 6/19/17.
 * Problem: Given an even number ( greater than 2 ),
 * return two prime numbers whose sum will be equal to given number.

 */
public class PrimeSum {

    public ArrayList<Integer> primesum(int a) {
        List<Integer> primeList = getAllPrimes(a);
        Set<Integer> primeSet = new HashSet<>(primeList);
        List<int []> listOfPairs = new ArrayList<>();
        int upperBound = primeList.size() / 2;
        for(int j = 0; j <= upperBound; j++) {
            int i = primeList.get(j);
            int pair = a - i;
            if(primeSet.contains(pair)) {
                listOfPairs.add(new int[]{i, pair});
            }
        }
        ArrayList<Integer> result = getLexicographicallyFirst(listOfPairs);
        return result;
    }

    protected ArrayList<Integer> getLexicographicallyFirst(List<int[]> listOfPairs) {
        int[] firstPair = listOfPairs.get(0);
        ArrayList<Integer> result = new ArrayList<>();
        result.add(firstPair[0]);
        result.add(firstPair[1]);
        return result;
    }

    protected List<Integer> getAllPrimes(int a) {
        int [] primes = new int[a + 1];
        // 0 by default represent prime, 1 means not prime
        primes[0] = primes[1] = 1;
        int upperBound = (int) Math.sqrt(a);

        for(int i = 2; i <= upperBound; i++) {
            for(int j = 2; j*i <= a; j++) {
                primes[j*i] = 1;
            }
        }

        List<Integer> primeList = new ArrayList<>();

        for(int i = 0; i <= a;i++ ) {
            if(primes[i] == 0) {
                primeList.add(i);
            }
        }
        return primeList;
    }


}
