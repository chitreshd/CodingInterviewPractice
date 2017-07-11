package com.algos.practice.leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by cdeshpande on 5/28/17.
 * Solution Ref: https://discuss.leetcode.com/topic/39656/short-java-binary-index-tree-beat-97-33-with-detailed-explanation/2
 */
public class CountOfSmallerNumbersAfterSelf {

    private int search(int i, int [] bit) {
        int sum = 0;
        while (i > 0) {
            sum += bit[i];
            i -= i & -i;
        }
        return sum;
    }

    private void update(int i, int [] bit) {
        while (i < bit.length) {
            bit[i] += 1;
            i += i & -i;
        }
    }

    private int index(int i, int [] sorted) {
        int idx = Arrays.binarySearch(sorted, i);
        return idx + 1;
    }

    public List<Integer> countSmaller(int [] nums) {
        if(nums == null || nums.length == 0)
            return new ArrayList<>();

        int [] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);
        int [] bit = new int[nums.length + 1];
        Integer [] result = new Integer[nums.length];

        for(int i = nums.length - 1; i >= 0; i--) {
            int num = nums[i];
            int idx = index(num, copy);
            int smallerThanSelf = search(idx, bit);
            result[i] = smallerThanSelf;
            update(idx + 1, bit);
        }

        return Arrays.asList(result);
    }

    public static List<Integer> getPathToLeaf(int i, int size) {
        List<Integer> path = new ArrayList();
        while (i < size) {
            path.add(i);
            i += i & -i;
        }
        return path;
    }


    public static List<Integer> getPathToRoot(int i) {
        List<Integer> path = new ArrayList();
        while (i > 0) {
            path.add(i);
            i -= i & -i;
        }
        return path;
    }

    public static void main(String[] args) {

        testCountSelf();
        runPrints();
    }

    private static void runPrints() {
        print(1);
        print(4);
        print(2);
        print(3);

    }

    private static void testCountSelf() {
        int [] input = {5, 2, 6, 1};
        List<Integer> output = new CountOfSmallerNumbersAfterSelf().countSmaller(input);
        System.out.println("Ans: " + output);

        int [] input1 = {-1, -1};
        output = new CountOfSmallerNumbersAfterSelf().countSmaller(input1);
        System.out.println("Ans: " + output);
    }

    private static void print(int i) {
        System.out.println(String.format("Search path: %s, Update Path: %s", getPathToRoot(i), getPathToLeaf(i,5)));
    }
}
