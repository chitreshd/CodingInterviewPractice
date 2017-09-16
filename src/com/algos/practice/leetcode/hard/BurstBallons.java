package com.algos.practice.leetcode.hard;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by cdeshpande on 9/14/17.
 */
public class BurstBallons {

    public int maxCoins(int[] nums) {

        if(nums == null || nums.length == 0)
            return 0;

            if(nums.length == 1)
                return nums[0];

        //  get min from middle
        //  burst it: get left and right and eliminate it
        //  when i get min, i should also get the index
        // what if i store index in min order
        Comparator<IndexValPair> comparator = new IndexValPairComparator();
        PriorityQueue<IndexValPair> pq = new PriorityQueue<>(nums.length, comparator);
        for(int i = 1; i < nums.length - 1; i++) {
            pq.add(new IndexValPair(i, nums[i]));
        }

        int sum = 0;

        while(!pq.isEmpty()) {
            IndexValPair valPair = pq.poll();
            int left = getLeft(nums, valPair.index);
            int right = getRight(nums, valPair.index);
            //burst balloon by marking it negative
            nums[valPair.index] = -1;
            int product = nums[left] * valPair.val * nums[right];
            sum += product;
        }

        if(nums[0] > nums[nums.length - 1]) {
            // burst last balloon
            sum += (nums[0] * nums[nums.length - 1]);
            // burst 0th balloon
            sum += nums[0];

        } else {

            // burst 0th balloon
            sum += (nums[0] * nums[nums.length - 1]);
            // burst last balloon
            sum += nums[nums.length - 1];

        }
        return sum;
    }

    protected int getLeft(int[] nums, int index) {
        int i = index - 1;
        while(nums[i] < 0) {
            i--;
        }
        return i;
    }

    protected int getRight(int[] nums, int index) {
        int i = index + 1;
        while(nums[i] < 0) {
            i++;
        }
        return i;
    }

    private void print(PriorityQueue<IndexValPair> pq) {
        while(!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }

    private static class IndexValPairComparator implements Comparator<IndexValPair> {

        @Override
        public int compare(IndexValPair o1, IndexValPair o2) {
            return Integer.compare(o1.val, o2.val);
        }
    }

    private static class IndexValPair {
        int index;
        int val;

        public IndexValPair(int index, int val) {
            this.index = index;
            this.val = val;
        }

        @Override
        public String toString() {
            return "IndexValPair{" +
                    "index=" + index +
                    ", val=" + val +
                    '}';
        }
    }
}
