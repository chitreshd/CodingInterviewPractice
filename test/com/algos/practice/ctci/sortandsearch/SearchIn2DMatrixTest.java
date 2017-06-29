package com.algos.practice.ctci.sortandsearch;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by cdeshpande on 6/26/17.
 */
public class SearchIn2DMatrixTest {
    private SearchIn2DMatrix solve = new SearchIn2DMatrix();

    @Test
    public void searchMatrix() throws Exception {
        int [][] input = new int[][]
                {
                        {15,20,70,85},
                        {20,35,80,95},
                        {30,55,95,105},
                        {40,80,100,120}
                };
        assertTrue(solve.searchMatrix(input, 85));
    }

}