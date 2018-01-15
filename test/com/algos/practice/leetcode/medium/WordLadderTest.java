package com.algos.practice.leetcode.medium;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.*;

public class WordLadderTest {
    @Test
    public void ladderLength() throws Exception {
        int ladderLen = solve.ladderLength("hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog"));
        assertEquals(5, ladderLen);

        ladderLen = solve.ladderLength("hit", "cog", Arrays.asList("man"));
        assertEquals(0, ladderLen);


        ladderLen = solve.ladderLength("hit", "cog", Arrays.asList("hot","dot","dog","lot","log"));
        assertEquals(0, ladderLen);
    }

    private WordLadder solve = new WordLadder();

    @Test
    public void getAllValidTransformations() throws Exception {
        List<String> validTransformations = solve.getAllValidTransformations("hit", new HashSet<>(Arrays.asList("hot",
                "man", "tit")));
        assertEquals(validTransformations.size(), 2);
        assertTrue(validTransformations.containsAll(Arrays.asList("hot", "tit")));

        validTransformations = solve.getAllValidTransformations("hit", new HashSet<>(Arrays.asList("man")));
        assertTrue(validTransformations.isEmpty());

    }

}