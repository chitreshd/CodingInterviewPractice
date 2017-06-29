package com.algos.practice.leetcode.medium;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by cdeshpande on 6/26/17.
 */
public class CourseScheduleTest {
    private CourseSchedule solve = new CourseSchedule();

    @Test
    public void canFinish() throws Exception {
        assertTrue(solve.canFinish(3, getSampleInput2()));
        assertFalse(solve.canFinish(2, getSampleInput1()));
    }

    private int[][] getSampleInput2() {
        return new int[][]
                {
                        {0,1},
                        {0,2},
                        {1,2}
                };
    }

    private int[][] getSampleInput1() {
        return new int[][]
                {
                        {0,1},
                        {1,0}
                };
    }

}