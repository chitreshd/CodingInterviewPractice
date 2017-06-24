package com.algos.practice.ctci.sortandsearch;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by cdeshpande on 6/23/17.
 */
public class RankOfNumberTest {


    @Test
    public void getRankOfNumber() throws Exception {

    }

    @Test
    public void track() throws Exception {
        RankOfNumber number = new RankOfNumber();
        List<Integer> integers = Arrays.asList(5,1,4,4,5,9,7,13,3);
        for(int i : integers) {
            number.track(i);
        }
        System.out.println(number);
    }

}