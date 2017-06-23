package com.algos.practice.interviewbit;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by cdeshpande on 6/19/17.
 */
public class RearrangeArrayTest {

    RearrangeArray solve = new RearrangeArray();

    @Test
    public void arrange() throws Exception {
        ArrayList<Integer> a = new ArrayList<>();
        a.addAll(Arrays.asList(1,2,0));
        solve.arrange(a);
        System.out.println(a);
    }

}