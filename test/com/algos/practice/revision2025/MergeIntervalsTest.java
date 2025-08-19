package com.algos.practice.revision2025;

import com.algos.practice.revision2025.MergeIntervals.Interval;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

/**
 * Test class for MergeIntervals
 * 
 * Comprehensive test coverage for the merge intervals problem including:
 * - Basic overlapping cases
 * - Edge cases (empty, single interval)
 * - Adjacent intervals (touching boundaries)
 * - Complex overlapping scenarios
 * - Unsorted input validation
 * - Both Interval object and int[][] array formats
 */
public class MergeIntervalsTest {

    private MergeIntervals solution;

    @BeforeEach
    void setUp() {
        solution = new MergeIntervals();
    }

    // Helper method to create intervals from 2D array
    private List<Interval> createIntervals(int[][] intervals) {
        List<Interval> result = new ArrayList<>();
        for (int[] interval : intervals) {
            result.add(new Interval(interval[0], interval[1]));
        }
        return result;
    }

    @Test
    void testBasicOverlappingIntervals() {
        // Test case: [[1,3],[2,6],[8,10],[15,18]] -> [[1,6],[8,10],[15,18]]
        List<Interval> intervals = createIntervals(new int[][]{{1,3},{2,6},{8,10},{15,18}});
        List<Interval> expected = createIntervals(new int[][]{{1,6},{8,10},{15,18}});
        
        assertEquals(expected, solution.merge(intervals));
    }

    @Test
    void testAdjacentIntervals() {
        // Test case: [[1,4],[4,5]] -> [[1,5]]
        // Adjacent intervals should be merged (touching at boundary)
        List<Interval> intervals = createIntervals(new int[][]{{1,4},{4,5}});
        List<Interval> expected = createIntervals(new int[][]{{1,5}});

        assertEquals(expected, solution.merge(intervals));

    }

    @Test
    void testNoOverlappingIntervals() {
        // Test case: [[1,2],[3,4],[5,6]] -> [[1,2],[3,4],[5,6]]
        // No intervals overlap, should return as-is (but sorted)
        List<Interval> intervals = createIntervals(new int[][]{{1,2},{3,4},{5,6}});
        List<Interval> expected = createIntervals(new int[][]{{1,2},{3,4},{5,6}});

        assertEquals(expected, solution.merge(intervals));

    }

    @Test
    void testSingleInterval() {
        // Test case: [[1,4]] -> [[1,4]]
        List<Interval> intervals = createIntervals(new int[][]{{1,4}});
        List<Interval> expected = createIntervals(new int[][]{{1,4}});

        assertEquals(expected, solution.merge(intervals));
    }

    @Test
    void testEmptyInput() {
        // Test case: [] -> []
        List<Interval> intervals = new ArrayList<>();
        List<Interval> expected = new ArrayList<>();

        assertEquals(expected, solution.merge(intervals));
    }

    @Test
    void testNullInput() {
        // Test case: null -> should handle gracefully
        assertEquals(Collections.emptyList(), solution.merge(null));
    }

    @Test
    void testCompletelyOverlappingIntervals() {
        // Test case: [[1,4],[2,3]] -> [[1,4]]
        // One interval completely contains another
        List<Interval> intervals = createIntervals(new int[][]{{1,4},{2,3}});
        List<Interval> expected = createIntervals(new int[][]{{1,4}});

        assertEquals(expected, solution.merge(intervals));
    }

    @Test
    void testIdenticalIntervals() {
        // Test case: [[1,3],[1,3]] -> [[1,3]]
        List<Interval> intervals = createIntervals(new int[][]{{1,3},{1,3}});
        List<Interval> expected = createIntervals(new int[][]{{1,3}});

        assertEquals(expected, solution.merge(intervals));
    }

    @Test
    void testUnsortedInput() {
        // Test case: [[6,7],[2,4],[5,9]] -> [[2,4],[5,9]]
        // Input is not sorted by start time
        List<Interval> intervals = createIntervals(new int[][]{{6,7},{2,4},{5,9}});
        List<Interval> expected = createIntervals(new int[][]{{2,4},{5,9}});

        assertEquals(expected, solution.merge(intervals));
    }

    @Test
    void testMultipleOverlappingChains() {
        // Test case: [[1,3],[2,6],[8,10],[9,12],[15,18]] -> [[1,6],[8,12],[15,18]]
        List<Interval> intervals = createIntervals(new int[][]{{1,3},{2,6},{8,10},{9,12},{15,18}});
        List<Interval> expected = createIntervals(new int[][]{{1,6},{8,12},{15,18}});

        assertEquals(expected, solution.merge(intervals));
    }

    @Test
    void testAllIntervalsOverlap() {
        // Test case: [[1,4],[2,5],[3,6]] -> [[1,6]]
        // All intervals overlap into one big interval
        List<Interval> intervals = createIntervals(new int[][]{{1,4},{2,5},{3,6}});
        List<Interval> expected = createIntervals(new int[][]{{1,6}});

        assertEquals(expected, solution.merge(intervals));
    }

    @Test
    void testZeroLengthIntervals() {
        // Test case: [[1,1],[2,2],[2,2]] -> [[1,1],[2,2]]
        // Zero-length intervals (point intervals)
        List<Interval> intervals = createIntervals(new int[][]{{1,1},{2,2},{2,2}});
        List<Interval> expected = createIntervals(new int[][]{{1,1},{2,2}});

        assertEquals(expected, solution.merge(intervals));
    }

    @Test
    void testLargeNumbers() {
        // Test case with larger numbers: [[100,200],[150,300],[400,500]]
        List<Interval> intervals = createIntervals(new int[][]{{100,200},{150,300},{400,500}});
        List<Interval> expected = createIntervals(new int[][]{{100,300},{400,500}});
        
        assertEquals(expected, solution.merge(intervals));
    }

    // Edge case: intervals that just touch at one point
    @Test
    void testIntervalsTouchingAtPoint() {
        // Test case: [[1,2],[2,3]] -> [[1,3]]
        // Intervals touching at exactly one point should merge
        List<Interval> intervals = createIntervals(new int[][]{{1,2},{2,3}});
        List<Interval> expected = createIntervals(new int[][]{{1,3}});
        
        assertEquals(expected, solution.merge(intervals));
    }

    // Performance test
    @Test
    void testLargeInput() {
        // Create a large input to test performance
        List<Interval> intervals = new ArrayList<>();
        List<Interval> expected = new ArrayList<>();
        for (int i = 0; i < 1000; i += 2) {
            intervals.add(new Interval(i, i + 1));
            expected.add(new Interval(i, i + 1));
        }
        
        assertEquals(expected, solution.merge(intervals));
    }

    // Test the helper methods work correctly
    @Test
    void testIntervalEquality() {
        Interval a = new Interval(1, 3);
        Interval b = new Interval(1, 3);
        Interval c = new Interval(2, 4);
        
        assertEquals(a, b);
        assertNotEquals(a, c);
        assertEquals(a.hashCode(), b.hashCode());
    }

    @Test
    void testIntervalToString() {
        Interval interval = new Interval(1, 3);
        assertEquals("[1,3]", interval.toString());
    }
}