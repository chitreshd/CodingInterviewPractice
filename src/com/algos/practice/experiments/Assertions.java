package com.algos.practice.experiments;


import org.junit.Assert;

/**
 * Created by cdeshpande on 9/9/17.
 */
public class Assertions {

    public static void main(String[] args) {

        foo(null);
    }

    private static void foo(String s) {
        Assert.assertNotNull(s);
        System.out.println("S was not null: " + s);
    }
}
