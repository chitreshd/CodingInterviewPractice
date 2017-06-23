package com.algos.practice.leetcode.medium;

import java.util.*;

/**
 * Created by cdeshpande on 6/22/17.
 */
public class PalindromeMatching {

    public List<List<String>> partition(String s) {
        List<List<String>> results = doPartition(s);
        return results;
    }

    public List<List<String>> doPartition(String s) {
        List<List<String>> results = new ArrayList<>();

        if(s == null || s.isEmpty()) {
            results.add(new ArrayList<String>());
            return results;
        }

        for(int i = 0; i < s.length(); i++) {

            String lft = s.substring(0,i + 1);
            if(palindrome(lft)) {
                List<List<String>> remainingResults = doPartition(s.substring(i + 1));
                addInResults(results, remainingResults, lft);
            }
        }

        return results;
    }

    private boolean palindrome(String s) {
        if(s.length() == 1)
            return true;
        int l = s.length();
        for(int i = 0; i < l / 2; i++) {
            if(s.charAt(i) != s.charAt(l - 1 - i))
                return false;
        }
        return true;
    }

    private void addInResults(List<List<String>> results, List<List<String>> remainingResults, String word) {
        for(List<String> remainingResult : remainingResults) {
            ArrayList<String> clne = (ArrayList<String>) ((ArrayList<String>) remainingResult).clone();
            clne.add(0,word);
            results.add(0,clne);
        }
    }

    public static void main(String[] args) {
        String s = "ab";
        char i = 'i';
        String g = i + s;
        //System.out.println(s);
        String [] mappings = new String[]{
                " ",
                "",
                "abc",
                "def",
                "ghi",
                "jkl",
                "mno",
                "pqrs",
                "tuv",
                "wxyz"
        };



        System.out.println('0' - '0');
    }
}
