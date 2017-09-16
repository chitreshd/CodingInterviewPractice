package com.algos.practice.leetcode.hard;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by cdeshpande on 9/16/17.
 */
public class TextJustificationTest {

    TextJustification solve = new TextJustification();

    @Test
    public void doJustifyBreak() throws Exception {

    }


    @Test
    public void testBadness() {
        int score = solve.calculateBadness(0, "first.", 7);
        System.out.println("score: " + score);
    }

}