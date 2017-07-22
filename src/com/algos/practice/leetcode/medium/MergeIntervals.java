package com.algos.practice.leetcode.medium;

import java.util.*;

/**
 * Created by cdeshpande on 7/20/17.
 */
public class MergeIntervals {

    public List<Interval> merge(List<Interval> intervals) {
        Map<Integer,Integer> cache = new HashMap<>();
        List<Interval> result = new ArrayList<>();

        for(Interval i : intervals) {
            if(cache.containsKey(i.start)) {
                // i.start in cache;
                merge(i,cache,result,i.start);
            } else if(cache.containsKey(i.end)) {
                merge(i,cache,result,i.end);
            }
            else {
                addToCache(i, cache, result);
            }

        }

        return result;

    }

    private Comparator<Interval> intervalComparator = new Comparator<Interval>() {
        @Override
        public int compare(Interval o1, Interval o2) {
            return Integer.compare(o1.start, o2.start);
        }
    };

    protected List<Interval> mergeUsingSort(List<Interval> intervals) {
        Collections.sort(intervals, intervalComparator);
        List<Interval> result = new ArrayList<>();
        result.add(intervals.get(0));
        for(int i = 1; i < intervals.size(); i++) {
            Interval lastInResult = result.get(result.size() - 1);
            Interval curr = intervals.get(i);
            if(lastInResult.end >= curr.start) {
                lastInResult.start = Math.min(lastInResult.start, curr.start);
                lastInResult.end = Math.max(lastInResult.end, curr.end);
            } else {
                result.add(curr);
            }
        }

        return result;

    }
    private void merge(Interval i, Map<Integer,Integer> cache, List<Interval> result, int matchingEnd) {
        int resultIndexPlusOne = cache.get(matchingEnd);
        Interval merged = result.get(resultIndexPlusOne - 1);
        merged.start = Math.min(merged.start, i.start);
        merged.end = Math.max(merged.end, i.end);

    }

    private void addToCache(Interval i, Map<Integer,Integer> cache, List<Interval> result) {
        int resultIndexPlusOne = result.size() + 1;
        for(int j = i.start; j <= i.end; j++) {
            cache.put(j,resultIndexPlusOne);
            //cache[j] = resultIndexPlusOne;
        }
        result.add(i);
    }

    public static class Interval {
             int start;
             int end;
             Interval() { start = 0; end = 0; }
             Interval(int s, int e) { start = s; end = e; }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Interval interval = (Interval) o;

            if (start != interval.start) return false;
            return end == interval.end;

        }

        @Override
        public int hashCode() {
            int result = start;
            result = 31 * result + end;
            return result;
        }

        @Override
        public String toString() {
            return "Interval{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }


}
