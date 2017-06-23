package com.algos.practice.leetcode.hard;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by cdeshpande on 4/6/17.
 *
 * Problem
 * A password is considered strong if below conditions are all met:

 It has at least 6 characters and at most 20 characters.
 It must contain at least one lowercase letter, at least one uppercase letter, and at least one digit.
 It must NOT contain three repeating characters in a row ("...aaa..." is weak, but "...aa...a..." is strong,
 assuming other conditions are met).
 Write a function strongPasswordChecker(s), that takes a string s as input, and return the MINIMUM change required
 to make s a strong password. If s is already strong, return 0.

 Insertion, deletion or replace of any one character are all considered as one change.
 *
 *Solution:
 *
 *
 */
public class StrongPasswordChecker {

    public int strongPasswordChecker(String s) {

        if(s == null || s.isEmpty())
            return 6;

        char [] input = s.toCharArray();
        char currRepeating = input[0];
        int currRepeatingCount = 0;
        int repeats = 0;
        int lowerCase = 1;
        int numeric = 1;
        int upperCase = 1;
        int vacantSpots = 0;

        for(int i = 1; i < s.length(); i++) {
            char c = input[i];
            if(currRepeating == c) {

                if(currRepeatingCount == 2) {
                    currRepeatingCount = 0;
                } else {
                    currRepeatingCount++;
                }

            } else {
                currRepeating = c;
                currRepeatingCount = 0;
            }


            if(currRepeatingCount == 2) {
                repeats++;
                //currRepeatingCount = -1;
            }

            if(Character.isLowerCase(c) && lowerCase > 0) {
                lowerCase--;
            }

            if(Character.isUpperCase(c) && upperCase > 0) {
                upperCase--;
            }

            if(Character.isDigit(c) && numeric > 0) {
                numeric--;
            }
        }

        if(s.length() < 6) {
            // would want to utilize repeats for adding missing chars
            if(repeats > 0) {
                int numOfChanges = 0; // TODO: Fix it, added 0 to fix compilation.
            }
            vacantSpots = 6 - s.length();
            return Math.max(vacantSpots + repeats, lowerCase + upperCase + numeric);
        }

        if(s.length() > 20) {
            int extraChars = s.length() - 20;
            // deletes can occur for repeats
            // we first delete repeats
            // then we use repeats to replace missing constraints: lowerCase, upperCase and numeric
            // if we still have repeats or deletes then those are also reported.
            // or we first use repeats to replace it with missings.
            // remaining repeats :
            // if repeats > extraChars: all repeats have to be deleted
            // if repeats == extraChars: all repeats have to be deleted
            // if repeats < extraChars: all extraChars have to be deleted (what if extraChars had repeats)
            // what if repeats also include the repeated ones outside of allowed char count?
            if(repeats > (lowerCase + upperCase + numeric)) {
                int repeatsAfterAddingMissing = repeats - (lowerCase + upperCase + numeric);
                return Math.max(repeatsAfterAddingMissing,extraChars) + (lowerCase + upperCase + numeric);
            } else {
                int missingAfterUsingRepeats = (lowerCase + upperCase + numeric) - repeats;
                return missingAfterUsingRepeats + extraChars + repeats;
            }

        }


        return Math.max(repeats, lowerCase + upperCase + numeric);
    }


    @Test
    public void testForLessThanLenghtCases() {
        /*assertEquals(2, strongPasswordChecker("abcd"));
        assertEquals(2, strongPasswordChecker("abcdef"));
        assertEquals(2, strongPasswordChecker("aaaaaa"));
        assertEquals(6, strongPasswordChecker(""));
        assertEquals(2, strongPasswordChecker("aaa111"));*/
        assertEquals(3, strongPasswordChecker("..."));
    }


    @Test
    public void testForGreaterThanLengthCases() {
        // TODO: Since deleting the last character removes one repeat, the min should be 7 but current algo gives out 8.
        assertEquals(7, strongPasswordChecker("aaaaaaaaaaaaaaaaaaaaa"));
        assertEquals(3, strongPasswordChecker("ababababababababababa"));
        assertEquals(2, strongPasswordChecker("1010101010aaaB10101010"));
    }




}
