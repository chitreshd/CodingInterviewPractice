package com.algos.practice.leetcode.hard;

import java.util.*;

/**
 * Created by cdeshpande on 6/6/17.
 */
public class WordBreakII {

    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        Map<String, List<String>> result = new HashMap<>();
        result.put("",Arrays.asList(""));
        return doWordBreak(s, dict, result);

    }

    private List<String> doWordBreak(String s, Set<String> dict, Map<String, List<String>> results) {
        if(results.containsKey(s)) {
            return results.get(s);
        }

        List<String> subLists = new ArrayList<>();

        for(int i = 0; i < s.length(); i++) {

            String subWord = s.substring(0,i + 1);
            if(dict.contains(subWord)) {
                List<String> rightPartLists = doWordBreak(s.substring(i + 1), dict, results);
                if(rightPartLists.isEmpty()) {
                    continue;
                }

                for(String rightPart : rightPartLists) {
                    // check if not cloning is causing an issue.
                    subLists.add((subWord + " " + rightPart).trim());
                }
            }

        }

        results.put(s, subLists);
        return results.get(s);
    }


}
