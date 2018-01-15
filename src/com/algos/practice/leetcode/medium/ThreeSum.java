package com.algos.practice.leetcode.medium;

import java.util.*;

/**
 * Created by cdeshpande on 8/29/17.
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        return usingHashMap(nums);

    }

    protected List<List<Integer>> threeSumOnSortedList(int [] nums) {
        Arrays.sort(nums);
        int i = 0;
        List<List<Integer>> result = new ArrayList<>();
        while(i < nums.length) {
            int third = nums[i];
            List<List<Integer>> twoSums = doTwoSumOnSortedList(nums, 0 - third, i + 1);
            addThirdToList(result, twoSums, third);
            while(i < nums.length && nums[i] == third) {
                i++;
            }
        }
        return result;
    }

    private void addThirdToList(List<List<Integer>> result, List<List<Integer>> twoSums, int third) {

        for(List<Integer> pair : twoSums) {
            List<Integer> threeSum = new ArrayList<>();
            threeSum.add(third);
            threeSum.addAll(pair);
            result.add(threeSum);
        }
    }

    protected List<List<Integer>> twoSumOnSortedList(int [] nums, int sum) {
        Arrays.sort(nums);
        return doTwoSumOnSortedList(nums, sum, 0);
    }

    private List<List<Integer>> doTwoSumOnSortedList(int[] nums, int sum, int startIndex) {
        // if calculated sum is greater than target one, move the right(tail end) pointer to left
        // if calculated sum is less than target one, move the left(head end) pointer to right
        // duplicates: duplicates will be registered only on success. after successfully finding the pair,
        // if the next value is same as previous one, then keep moving pointers.
        // -2 -1 0 1 2
        int head = startIndex;
        int tail = nums.length - 1;
        List<List<Integer>> pairs = new ArrayList<>();
        while(head < tail) {
            int pairSum = nums[head] + nums[tail];

            if(pairSum > sum) {
                tail--;
            } else if(pairSum < sum) {
                head++;
            } else {
                pairs.add(Arrays.asList(nums[head], nums[tail]));
                tail--;
                head++;
                while(head < tail && nums[tail] == nums[tail + 1]) {
                    tail--;
                }
                while(head < tail && nums[head] == nums[head - 1]) {
                    head++;
                }
            }
        }
        return pairs;
    }

    // Big(0) -> O(n^2)
    protected List<List<Integer>> usingHashMap(int[] nums) {
        Set<List<Integer>> results = new HashSet<>();
        Map<Integer, Integer> freqMap = createFreqMap(nums);

        for(int firstIndex = 0; firstIndex < nums.length; firstIndex++) {
            int first = nums[firstIndex];
            remove(freqMap, first);
            for(int secondIndex = firstIndex + 1; secondIndex < nums.length; secondIndex++) {
                int second = nums[secondIndex];
                remove(freqMap, second);
                int third = 0 - (first + second);
                // f + s + t = 0; t = 0 - (f + s)
                if(contains(freqMap, third)) {
                    addToResult(results, Arrays.asList(first, second, third));
                }
                add(freqMap, second);
            }
            add(freqMap, first);
        }

        return new ArrayList<>(results);

    }

    private void addToResult(Set<List<Integer>> results, List<Integer> result) {
        Collections.sort(result);
        results.add(result);
    }

    private void remove(Map<Integer, Integer> freqMap, int key) {
        if(!freqMap.containsKey(key)) {
            throw new IllegalArgumentException(String.format("didnt find %s in freqMap", key));
        }
        int curr = freqMap.get(key);
        if(curr < 0) {
            throw new IllegalStateException(String.format("value of %s is in illegal state: %s", key, curr));
        }
        freqMap.put(key, curr - 1);
    }

    private void add(Map<Integer, Integer> freqMap, int key) {
        if(!freqMap.containsKey(key)) {
            throw new IllegalArgumentException(String.format("didnt find %s in freqMap", key));
        }
        int curr = freqMap.get(key);
        if(curr < 0) {
            throw new IllegalStateException(String.format("value of %s is in illegal state: %s", key, curr));
        }
        freqMap.put(key, curr + 1);
    }

    private boolean contains(Map<Integer, Integer> freqMap, int third) {
        return freqMap.containsKey(third) && freqMap.get(third) > 0;
    }

    private Map<Integer, Integer> createFreqMap(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int num : nums) {

            if(freqMap.containsKey(num)) {
                int curr = freqMap.get(num);
                freqMap.put(num, curr + 1);
            } else {
                freqMap.put(num, 1);
            }
        }

        return freqMap;
    }

    // recursion, couldnt figure out recurrence relationship
    protected List<List<Integer>> usingPureRecursion(int[] nums, int sum) {
        List<List<Integer>> results = new ArrayList<>();
        for(int i = 0; i < nums.length - 2; i++) {
            int curr = nums[i];
            List<Integer> result = new ArrayList<>();
            result.add(curr);
            doThreeSum(i + 1, nums, result, results, sum - curr);
            result.remove((Integer) curr);
        }
        List<List<Integer>> filtered = filterDuplicates(results);
        return filtered;
    }

    private List<List<Integer>> filterDuplicates(List<List<Integer>> results) {
        Set<List<Integer>> filter = new HashSet<>();
        for(List<Integer> result : results) {
            Collections.sort(result);
            if(!filter.contains(result)) {
                filter.add(result);
            }
        }
        return new ArrayList<>(filter);
    }

    protected void doThreeSum(int currIndex,
                              int[] nums,
                              List<Integer> result,
                              List<List<Integer>> results,
                              int remainingSum) {

        if(result.size() == 3) {
            if(remainingSum == 0) {
                /*List<Integer> clone = new ArrayList<>(result.size());
                Collections.copy(clone, result);*/
                results.add(clone(result));
            }
        }

        for(int i = currIndex; i < nums.length; i++) {
            int curr = nums[i];
            result.add(curr);
            doThreeSum(i + 1, nums, result, results, remainingSum - curr);
            result.remove((Integer) curr);
        }
    }

    protected List<Integer> clone(List<Integer> integers) {
        ArrayList<Integer> clone = new ArrayList<>();
        for(int i : integers) {
            clone.add(i);
        }
        return clone;
    }
}
