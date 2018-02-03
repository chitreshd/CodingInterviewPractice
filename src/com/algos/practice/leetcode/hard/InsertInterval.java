package com.algos.practice.leetcode.hard;

import java.util.*;

/**
 * Created by cdeshpande on 8/15/17.
 */
public class InsertInterval {


    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        return secondPass(intervals, newInterval);
    }

    private List<Interval> secondPass(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<>();
        if(intervals.isEmpty()) {
            result.add(newInterval);
            return result;
        }

        int i = 0;
        int size = intervals.size();
        while(i < size && intervals.get(i).end < newInterval.start) {
            result.add(intervals.get(i));
            i++;
        }
        if(i >= size) {
            result.add(newInterval);
            return result;
        }

        Interval merged = new Interval(Integer.MAX_VALUE, Integer.MIN_VALUE);
        boolean didMerge = false;
        while(i < size && intervals.get(i).start <= newInterval.end) {
            merged.start = Math.min(intervals.get(i).start, Math.min(newInterval.start, merged.start));
            merged.end = Math.max(intervals.get(i).end, Math.max(newInterval.end, merged.end));
            i++;
            didMerge = true;
        }

        if(didMerge) {
            result.add(merged);
        } else {
            result.add(newInterval);
        }

        while(i < size) {
            result.add(intervals.get(i));
            i++;
        }
        return result;
    }

    private List<Interval> firstPass(List<Interval> intervals, Interval newInterval) {
        List<Interval> mergeCandidates = new ArrayList<>();
        List<Interval> result = new ArrayList<>();
        if(intervals.isEmpty()) {
            result.add(newInterval);
            return result;
        }

        int i = 0;
        int size = intervals.size();
        Interval curr = null;

        Interval first = intervals.get(0);
        if(first.start > newInterval.end) {
            result.add(newInterval);
            result.addAll(intervals);
            return result;
        }

        while(i < size) {
            curr = intervals.get(i);
            if(inRange(curr, newInterval.start)) {
                mergeCandidates.add(curr);
                i++;
                break;
            } else {
                result.add(curr);
            }
            i++;
        }

        while(i < size) {
            curr = intervals.get(i);
            if(curr.end >= newInterval.end) {
                // found end
                if(curr.start <= newInterval.end) {
                    // add curr to merge candidates
                    mergeCandidates.add(curr);
                    i++;
                }
                break;
            } else {
                mergeCandidates.add(curr);
            }
            i++;
        }

        // merge
        if(!mergeCandidates.isEmpty()) {
            Interval firstMergeCandidate = mergeCandidates.get(0);
            Interval lastMergeCandidate = mergeCandidates.get(mergeCandidates.size() - 1);
            int mergedStart = firstMergeCandidate.start;
            int mergedEnd = Math.max(lastMergeCandidate.end, newInterval.end);

            Interval merged = new Interval(mergedStart, mergedEnd);
            result.add(merged);
        } else {
            Interval last = intervals.get(intervals.size() - 1);
            if(last.end < newInterval.start) {
                result.add(newInterval);
            }
        }

        while(i < size) {
            result.add(intervals.get(i++));
        }

        return result;
    }

    private boolean inRange(Interval curr, int start) {
        return curr.start <= start && curr.end >= start;
    }

    static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }

        @Override
        public String toString() {
            return "(" + start + ", " +end + ")";
        }
    }

    protected List<Interval> revisedAndSimplified(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<>();

        if(intervals.isEmpty()) {
            result.add(newInterval);
            return result;
        }

        // lets add all the intervals which are to the left of new interval
        Iterator<Interval> intIterator = intervals.iterator();

        Interval curr = intIterator.hasNext() ? intIterator.next() : null;

        while(curr != null && curr.end < newInterval.start) {
            result.add(curr);
            curr = intIterator.hasNext() ? intIterator.next() : null;
        }

        if(curr == null) {
            result.add(newInterval);
            return result;
        }

        // lets evaluate if we have merge candidates
        Interval merged = new Interval(newInterval.start, newInterval.end);
        while(curr != null && curr.start <= newInterval.end) {
            merged.start = Math.min(merged.start, curr.start);
            merged.end = Math.max(merged.end, curr.end);
            curr = intIterator.hasNext() ? intIterator.next() : null;
        }

        // either we have merged some intervals or have just added the newInterval
        result.add(merged);

        // rest of all the intervals are on the right
        while(curr != null) {
            result.add(curr);
            curr = intIterator.hasNext() ? intIterator.next() : null;
        }

        return result;
    }
}
