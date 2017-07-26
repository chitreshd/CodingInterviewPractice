package com.algos.practice.leetcode.medium;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by cdeshpande on 7/25/17.
 */
public class ReversePolishNotationTest {
    ReversePolishNotation solve = new ReversePolishNotation();

    @Test
    public void evalRPN() throws Exception {
        assertEquals(9,solve.evalRPN(new String[]{"2", "1", "+", "3", "*"}));
        assertEquals(6,solve.evalRPN(new String[]{"4", "13", "5", "/", "+"}));
        assertEquals(-7,solve.evalRPN(new String[]{"4","-2","/","2","-3","-","-"}));
        assertEquals(-1,solve.evalRPN(new String[]{"3","-4","+"}));
    }

}