package com.algos.practice.experiments;

/**
 * Created by cdeshpande on 9/9/17.
 */
public class Assertions {

    public static void main(String[] args) {
        foo(null);
    }

    private static void foo(String s) {
        if (s == null) {
            throw new RuntimeException("Assertion failed: s was null");
        }
        System.out.println("S was not null: " + s);
    }
}
