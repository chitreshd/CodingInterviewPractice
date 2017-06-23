package com.algos.practice.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cdeshpande on 6/22/17.
 */
public class LetterCombinations {

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

    public List<String> letterCombinations(String digits) {
        return lc(digits);
    }


    private List<String> lc(String digits) {
        List<String> result = new ArrayList();
        if(digits == null || digits.isEmpty()) {
            result.add("");
            return result;
        }

        char d = digits.charAt(0);
        List<String> combs = lc(digits.substring(1));
        char [] chars = get(d);
        for(int i = 0; i < chars.length; i++) {
            for(String comb : combs) {
                String newComb = chars[i] + comb;
                result.add(newComb);
            }
        }

        return result;

    }

    private char[] get(char d) {
        int index = d - '0';
        return mappings[index].toCharArray();

    }

    public static void main(String[] args) {
        char [] r = new char[5];
        r[0] = 'a';
        System.out.println(new String(r).trim());
        r[0] = 'b';
        System.out.println(new String(r).trim());
    }
}
