package com.algos.practice.leetcode.medium;

import java.util.*;

/**
 * Created by cdeshpande on 7/26/17.
 */
public class RepeatedDNASeq {

    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> result = new HashSet<>();
        if(s.length() <= 10) {
            return Collections.emptyList();
        }

        /*if(s.length() == 10) {
            result.add(s);
            return result;
        }*/

        Set<String> cache = new HashSet<>();
        cache.add(s.substring(0,10));

        for(int i = 1; (i + 10) <= s.length(); i++) {
            String subSeq = s.substring(i, i + 10);
            if(cache.contains(subSeq)) {
                result.add(subSeq);
            } else {
                cache.add(subSeq);
            }
        }

        return new ArrayList<>(result);
    }
}
