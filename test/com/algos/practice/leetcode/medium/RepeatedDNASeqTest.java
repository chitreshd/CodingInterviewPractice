package com.algos.practice.leetcode.medium;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * Created by cdeshpande on 7/26/17.
 */
public class RepeatedDNASeqTest {

    RepeatedDNASeq solve = new RepeatedDNASeq();

    @Test
    public void findRepeatedDnaSequences() throws Exception {

        test("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
                Arrays.asList("AAAAACCCCC", "CCCCCAAAAA"));
        test("AAAAAAAAAAA",Arrays.asList("AAAAAAAAAA"));
    }

    private void test(String s, List<String> expected) {
        List<String> actual = solve.findRepeatedDnaSequences(s);
        assertThat(actual, is(expected));
    }



}