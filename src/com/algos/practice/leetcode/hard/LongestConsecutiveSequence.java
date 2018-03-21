package com.algos.practice.leetcode.hard;

import java.util.*;

public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        return longestConsecutiveUsingHashMap(nums);


    }

    protected int usingStartingStreak(int [] nums) {
        Set<Integer> numSet = toSet(nums);
        int max = 0;
        for(int num : nums) {
            if(!numSet.contains(num - 1)) {
                // here means num can be start of streak as there is no consecutive number lesser than num
                int y = num + 1;
                while(numSet.contains(y)) {
                    y++;
                }
                max = Math.max(max, y - num);
            }

        }

        return max;
    }

    protected int longestConsecutiveUsingHashMap(int [] nums) {
        Set<Integer> numSet = toSet(nums);
        Map<Integer, Integer> consSeqCounter = new HashMap<>();
        int maxCount = 0;

        for(int num : nums) {
            if(consSeqCounter.containsKey(num)) {
                // dont process duplicates
                continue;
            }

            int count = 1;
            int i = num - 1;
            while(numSet.contains(i)) {
                if(consSeqCounter.containsKey(i)) {
                    count = count + consSeqCounter.get(i);
                    break;
                } else {
                    count++;
                }
                i--;
            }
            consSeqCounter.put(num, count);
            maxCount = Math.max(count, maxCount);
        }

        return maxCount;

    }

    private Set<Integer> toSet(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }
        return set;
    }

    public static void main(String[] args) {
        int [] nums = new int[] {1,2,0,1};
        LongestConsecutiveSequence solve = new LongestConsecutiveSequence();
        int result = solve.longestConsecutive(nums);
        System.out.println("result: " + result);
    }

}

