package com.algos.practice.revision2025;

import java.util.*;

/**
 * Problem: Merge Intervals
 * 
 * Given an array of intervals where intervals[i] = [start_i, end_i], 
 * merge all overlapping intervals, and return an array of the non-overlapping 
 * intervals that cover all the intervals in the input.
 * 
 * Example 1:
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
 * 
 * Example 2:
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 * 
 * Constraints:
 * - 1 <= intervals.length <= 10^4
 * - intervals[i].length == 2
 * - 0 <= start_i <= end_i <= 10^4
 * 
 * Approach: Sort and Merge
 * 1. Sort intervals by start time
 * 2. Iterate through sorted intervals and merge overlapping ones
 * Time Complexity: O(n log n) - due to sorting
 * Space Complexity: O(n) - for the result list
 */
public class MergeIntervals {

    /**
     * Represents an interval with start and end points
     */
    public static class Interval {
        public int start;
        public int end;
        
        public Interval() {
            start = 0;
            end = 0;
        }
        
        public Interval(int s, int e) {
            start = s;
            end = e;
        }
        
        @Override
        public String toString() {
            return "[" + start + "," + end + "]";
        }
        
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Interval interval = (Interval) obj;
            return start == interval.start && end == interval.end;
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(start, end);
        }
    }

    /**
     * Merges overlapping intervals using sorting approach
     * 
     * @param intervals list of intervals to merge
     * @return list of merged non-overlapping intervals
     */
    public List<Interval> merge(List<Interval> intervals) {
        // Handle edge cases (null or empty input)
        if (intervals == null || intervals.isEmpty()) {
            return new ArrayList<>();
        }
        
        // Single interval case
        if (intervals.size() == 1) {
            return new ArrayList<>(intervals);
        }
        
        // Sort intervals by start time
        Collections.sort(intervals, Comparator.comparingInt(o -> o.start));
        
        List<Interval> merged = new ArrayList<>();
        Interval current = intervals.get(0);
        
        for (int i = 1; i < intervals.size(); i++) {
            Interval next = intervals.get(i);
            
            // Check if intervals overlap (including touching at boundary)
            if (next.start <= current.end) {
                // Merge intervals - extend the end to the maximum
                current.end = Math.max(current.end, next.end);
            } else {
                // No overlap, add current to result and move to next
                merged.add(current);
                current = next;
            }
        }
        
        // Add the last interval
        merged.add(current);
        
        return merged;
    }

    
    public static void main(String[] args) {
        MergeIntervals solution = new MergeIntervals();
        
        // Test case 1: Basic overlapping intervals
        System.out.println("Test 1: Basic overlapping intervals");
        List<Interval> intervals1 = Arrays.asList(
            new Interval(1, 3),
            new Interval(2, 6),
            new Interval(8, 10),
            new Interval(15, 18)
        );
        System.out.println("Input: " + intervals1);
        try {
            System.out.println("Output: " + solution.merge(intervals1));
        } catch (UnsupportedOperationException e) {
            System.out.println("Output: Not implemented yet");
        }
        System.out.println("Expected: [[1,6], [8,10], [15,18]]");
        System.out.println();
        
        // Test case 2: Adjacent intervals (touching)
        System.out.println("Test 2: Adjacent intervals");
        List<Interval> intervals2 = Arrays.asList(
            new Interval(1, 4),
            new Interval(4, 5)
        );
        System.out.println("Input: " + intervals2);
        try {
            System.out.println("Output: " + solution.merge(intervals2));
        } catch (UnsupportedOperationException e) {
            System.out.println("Output: Not implemented yet");
        }
        System.out.println("Expected: [[1,5]]");
        System.out.println();
        
        // Test case 3: No overlapping intervals
        System.out.println("Test 3: No overlapping intervals");
        List<Interval> intervals3 = Arrays.asList(
            new Interval(1, 2),
            new Interval(3, 4),
            new Interval(5, 6)
        );
        System.out.println("Input: " + intervals3);
        try {
            System.out.println("Output: " + solution.merge(intervals3));
        } catch (UnsupportedOperationException e) {
            System.out.println("Output: Not implemented yet");
        }
        System.out.println("Expected: [[1,2], [3,4], [5,6]]");
    }
}