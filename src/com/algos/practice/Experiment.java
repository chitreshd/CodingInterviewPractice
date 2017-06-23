package com.algos.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cdeshpande on 3/30/17.
 */
public class Experiment {

    public static void main(String[] args) {
        List<String> s = new ArrayList<>();
        s.add("a");
        s.add("b");

        System.out.println("Before foo: " + s);

        foo(s);

        System.out.println("After foo: " + s);
    }

    private static void foo(List<String> s) {
        s = new ArrayList<>();
    }

}
