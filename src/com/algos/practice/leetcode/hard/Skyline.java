package com.algos.practice.leetcode.hard;

import java.util.*;

/**
 * Created by cdeshpande on 6/16/17.
 *
 * Description: https://leetcode.com/problems/the-skyline-problem/#/description
 */
public class Skyline {

    private Comparator<? super Triplet> pairCompatator = new Comparator<Triplet>() {
        @Override
        public int compare(Triplet o1, Triplet o2) {
            return Integer.compare(o1.x, o2.x);
        }
    };

    private Comparator<Integer> descCompatator = new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    };

    public List<int[]> getSkyline(int[][] buildings) {
        List<int []> result = new ArrayList<>();

        List<Triplet> triplets = split(buildings);
        Collections.sort(triplets, pairCompatator);
        int max = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(10, descCompatator);
        pq.add(0);
        for(Triplet triplet : triplets) {
            if(triplet.start) {
                // start of rectangle
                pq.add(triplet.h);
                if(max != pq.peek()) {
                    max = pq.peek();
                    // max height changed
                    result.add(new int[]{triplet.x, max});
                }
            } else {
                // end of rectangle
                pq.remove(triplet.h);
                if(max != pq.peek()) {
                    max = pq.peek();
                    // max height changed
                    result.add(new int[]{triplet.x, max});
                }

            }
        }
        System.out.println("Before cleaning: " + convertToString(result));
        result = cleanSameLineCoordinates(result);
        return result;
    }

    protected String convertToString(List<int[]> results) {
        StringBuffer buff = new StringBuffer();
        buff.append("[");
        for(int [] result : results) {
            buff.append(Arrays.toString(result));
        }
        buff.append("]");
        return buff.toString();
    }

    private List<int []> cleanSameLineCoordinates(List<int[]> result) {
        Stack<int []> filtered = new Stack<>();
        int [] curr = result.get(0);

        filtered.push(curr);
        int lastXCoordinate = curr[1];
        int i = 1;
        while(i < result.size()) {
            int j = i;
            curr = result.get(i);

            int maxHeightForRepeatedXs = -1;
            while(curr[0] == lastXCoordinate) {
                j++;
                maxHeightForRepeatedXs = Math.max(maxHeightForRepeatedXs, curr[1]);
                curr = result.get(j);
            }

            if(j != i) {
                // found points with same X value

                // remove the last added element, it was the first repetition.
                filtered.pop();
                int heightBeforeRepeatedX = filtered.isEmpty() ? -1 : filtered.peek()[1];

                if(maxHeightForRepeatedXs != heightBeforeRepeatedX) {
                    // height changed
                    filtered.push(new int[]{lastXCoordinate, maxHeightForRepeatedXs});
                }
                i = j;
            } else {
                filtered.push(curr);
                i++;
                lastXCoordinate = curr[0];
            }

        }
        return filtered;
    }

    protected List<Triplet> split(int[][] buildings) {
        List<Triplet> triplets = new ArrayList<>();

        for(int i = 0; i < buildings.length; i++ ) {
            int x1 = buildings[i][0];
            int x2 = buildings[i][1];
            int h  = buildings[i][2];
            triplets.add(new Triplet(x1,h, true));
            triplets.add(new Triplet(x2,h, false));
        }
        return triplets;
    }

    public static class Triplet {
        int x;
        int h;
        boolean start;

        Triplet(int x, int h, boolean start) {
            this.x = x;
            this.h = h;
            this.start = start;
        }

        public String toString() {
            return String.format("[%s, %s, start=%s]", x, h, start);
        }
    }

}
