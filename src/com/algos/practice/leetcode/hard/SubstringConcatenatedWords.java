package com.algos.practice.leetcode.hard;

import java.util.*;

/**
 * Created by cdeshpande on 12/17/16.
 */
public class SubstringConcatenatedWords {

    public static class WordCounter {
        private HashMap<String, Integer> freq = new HashMap<>();

        public WordCounter(String [] array) {
            for(String word : array) {
                if(freq.containsKey(word)) {
                    int prevCount = freq.get(word);
                    freq.put(word, prevCount + 1);
                } else {
                    freq.put(word, 1);
                }
            }
        }

        public boolean allCovered(String word) {
            if(freq.containsKey(word)) {
                int count = freq.get(word);
                if(count <= 0) {
                    return true;
                }
            }

            return false;
        }

        public void add(String word) {
            if(freq.containsKey(word)) {
                int count = freq.get(word);
                if(count > 0) {
                    freq.put(word, count - 1);
                }
            }
        }

    }
    public List<Integer> findSubstring(String s, String[] words) {
        Set<String> wordSet = new HashSet<>(Arrays.asList(words));
        int wordLen = words[0].length();
        int subStringLen = wordLen * words.length;
        List<Integer> indices = new ArrayList<>();

        for(int i = 0; i <= s.length() - subStringLen; i++) { // N
            String subString = s.substring(i, i + subStringLen);// some overhead to extract substring, ignoring for now

            WordCounter discovered = new WordCounter(words);
            int start = 0;
            while( start <= subStringLen - wordLen) {
                String word = subString.substring(start, start + wordLen);
                if(discovered.allCovered(word) || ! wordSet.contains(word)) {
                    break;
                }
                start += wordLen;
                discovered.add(word);
            }

            if(start >= subStringLen) {
                // found all words
                indices.add(i);
            }

        }

        return indices;
    }

    public static void main(String[] args) {
        SubstringConcatenatedWords sol = new SubstringConcatenatedWords();
        System.out.println(sol.findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));
        System.out.println(sol.findSubstring("barfoofoobarthefoobarman", new String[]{"bar","foo","the"}));
        System.out.println(sol.findSubstring("wordgoodgoodgoodbestword", new String[]{"word","good","best","good"}));
    }
}
