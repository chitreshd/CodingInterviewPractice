package com.algos.practice.leetcode.hard;


import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;

/**
 * Created by cdeshpande on 6/5/17.
 *
 * Problem:
 There are two sorted arrays nums1 and nums2 of size m and n respectively.

 Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

 Example 1:
 nums1 = [1, 3]
 nums2 = [2]

 The median is 2.0
 Example 2:
 nums1 = [1, 2]
 nums2 = [3, 4]

 The median is (2 + 3)/2 = 2.5

 <u>Confusion with Binary Search</u>
 With Binary Search in mind, i was confused as to why we only decrease or move i in one direction
 when comparing nums1 with nums2 (given we do increase or move i in other direction when
 comparing nums2 with nums1 i.e. reverse comparison, still it wasn't clear). In Binary
 Search we are looking for or checking for equality. But here, we are testing inequality.
 So when comparing nums1 vs nums2, either we have met the desired inequality or there's
 only one direction to go for achieving that inequality.

 <u>Other Learnings</u>
 1. Screwed up simple things like finding mid index in an array
 Instead of (end + start) / 2, i ended up doing (end - start) / 2, which will give incorrect results.

 2. Didn't test the code thoroughly before submitting.

 3.
 *
 */
public class MedianOf2SortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if(isEmpty(nums1)) {
            return medianFromOneArray(nums2);
        }

        if(isEmpty((nums2))) {
            return medianFromOneArray(nums1);
        }

        // if here, means both arrays are non-empty.
        if(nums1.length < nums2.length) {
            return doExecute1(nums1, nums2);
        } else {
            return doExecute1(nums2, nums1);
        }


    }

    private double medianFromOneArray(int[] arr) {
        if(isEmpty(arr)) {
            return -1;
        }
        int mid = arr.length / 2;
        if(arr.length % 2 == 0) {
            // even
            return ( arr[mid] + arr[mid - 1] ) * 1.0 / 2;
        } else {
            // odd
            return arr[mid];
        }

    }

    private double doExecute(int[] nums1, int[] nums2) {
        int start = 0;
        int end = nums1.length;
        int m = nums1.length;
        int n = nums2.length;
        int halfLen = (m + n + 1) / 2;

        while(start <= end) {

            int i = ( end + start ) / 2;
            int j = halfLen - i;

            if(i > 0  && (nums1[i - 1] > nums2[j] )) {
                // i.e. left part from nums1 is greater than right part from nums2, decrease i
                end = i - 1;
                continue;
            }

            if(i < m && (nums2[j - 1] > nums1[i] )) {
                // i.e. left part from nums2 is greater than right part from nums1, decrease j i.e. increase i
                start = i + 1;
                continue;
            }

            // coming here, means we have found i and j that splits nums1 and nums2 such that
            // max (left part) >= min(right part)
            if((m + n) % 2 == 0 ) {
                // total length is even
                return ( max(nums1, i - 1,nums2, j - 1) + min( nums1, i, nums2, j) ) * 1.0 / 2;
            } else {
                // odd
                return max(nums1, i - 1,nums2, j - 1);
            }

        }

        return -1; // error, shouldn't come here
    }

    private double doExecute1(int[] nums1, int[] nums2) {
        int start = 0;
        int end = nums1.length;
        int m = nums1.length;
        int n = nums2.length;
        int halfLen = (m + n) / 2;

        while(start <= end) {

            int i = ( end + start ) / 2;
            int j = halfLen - i - 1;

            if(i > 0  && j < n && (nums1[i] > nums2[j + 1] )) {
                // i.e. left part from nums1 is greater than right part from nums2, decrease i
                end = i - 1;
                continue;
            }

            if(i < m - 1 && (nums2[j] > nums1[i + 1] )) {
                // i.e. left part from nums2 is greater than right part from nums1, decrease j i.e. increase i
                start = i + 1;
                continue;
            }

            // coming here, means we have found i and j that splits nums1 and nums2 such that
            // max (left part) >= min(right part)
            if((m + n) % 2 == 0 ) {
                // total length is even
                return ( max(nums1, i,nums2, j) + min( nums1, i, nums2, j) ) * 1.0 / 2;
            } else {
                // odd
                return max(nums1, i,nums2, j);
            }

        }

        return -1; // error, shouldn't come here
    }

    private int min(int[] nums1, int n1Index, int[] nums2, int n2Index) {
        if(isIndexOutOfBound(nums1, n1Index)) {
            return nums2[n2Index];
        }

        if(isIndexOutOfBound(nums2, n2Index)) {
            return nums1[n1Index];
        }

        return Math.min(nums1[n1Index], nums2[n2Index]);
    }

    private int max(int[] nums1, int n1Index, int[] nums2, int n2Index) {
        if(isIndexOutOfBound(nums1, n1Index)) {
            return nums2[n2Index];
        }

        if(isIndexOutOfBound(nums2, n2Index)) {
            return nums1[n1Index];
        }

        return Math.max(nums1[n1Index], nums2[n2Index]);
    }

    private boolean isIndexOutOfBound(int [] arr, int index) {
        return index < 0 || index >= arr.length;
    }

    private boolean isEmpty(int [] arr) {
        return arr == null || arr.length == 0;
    }


}
