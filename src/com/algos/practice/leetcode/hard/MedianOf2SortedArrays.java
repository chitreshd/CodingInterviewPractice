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

    public double findMedianSortedArraysRev2(int[] nums1, int[] nums2) {

        if(nums1.length > nums2.length) {
            return doFindMedianSortedArrays(nums2, nums1);
        } else {
            return doFindMedianSortedArrays(nums1, nums2);
        }


    }

    protected double doFindMedianSortedArrays(int [] A, int [] B) {
        int m = A.length; // will be represented by i
        int n = B.length; // will be represented by j
        int c = 0;
        if(( m + n )% 2 != 0) {
            // odd total length
            c = 1;
        }

        int start = 0;
        int end = m;
        int halfLen = (1 + n + m) / 2;
        while(start <= end) {

            int i = (start + end) / 2;
            int j = halfLen - i;
            if(i > 0 && A[i - 1] > B[j]) {
                // decrease i
                end = i - 1;
            } else if (i < m && B[j - 1] > A[i]) {
                // increase i
                start = i + 1;
            } else {
                // coming here means we have found the the position of i such that it splits
                // combined array so that max(leftPart) > min(rightPart)
                // if c is 0 that is total length is even
                if(c == 0) {
                    /**
                     * Note: i and j represents the cut in the array. its the length of leftPart.
                     * Coming here means leftPart equal to rightPart with median
                     * condition satisfied. Thus we use i - 1 and j - 1 as indexes to get the
                     * max of leftPart (because its the last element of leftArray to find out the median.)
                     * and i and j indexes to get the rightPart (as its the start of rightArray)
                     */
                    int maxLeftPart = max(A, i - 1, B, j - 1);
                    int minRightPart = min(A, i , B, j);
                    return (( maxLeftPart + minRightPart ) * 1.0) / 2;
                } else {
                    /**
                     * Note: i and j represents the cut in the array. its the length of leftPart.
                     * Coming here means leftPart is one element larger than rightPart with median
                     * condition satisfied. Thus we use i - 1 and j - 1 as indexes; because its the
                     * last element of leftArray to find out the median.
                     */
                    int maxLeftPart = max(A, i - 1, B, j - 1);
                    return maxLeftPart;
                }

            }

        }
        //error, shouldn't come here
        return -1;
    }

    /*private int max(int [] A, int i, int [] B, int j) {
        int a = (i < 0 || i >= A.length) ? 0 : A[i];
        int b = (j < 0 || j >= B.length) ? 0 : B[j];
        return Math.max(a,b);
    }

    private int min(int [] A, int i, int [] B, int j) {
        int a = (i < 0 || i >= A.length) ? Integer.MAX_VALUE : A[i];
        int b = (j < 0 || j >= B.length) ? Integer.MAX_VALUE : B[j];
        return Math.min(a,b);
    }*/


}
