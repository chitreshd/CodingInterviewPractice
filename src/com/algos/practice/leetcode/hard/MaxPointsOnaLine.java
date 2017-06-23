package com.algos.practice.leetcode.hard;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;

/**
 * Created by cdeshpande on 2/25/17.
 */
public class MaxPointsOnaLine {

    /**
     * 149. Max Points on a Line
     Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.

     how do you define a line?
     (y - y0)(x1 - x0) = (y1 - y0)(x - x0)
     can i use this equation to calculate y-intercept?

     (y - y0) = (y1 - y0)/(x1 - x0) (x - x0)

     y = m * (x - x0) + y0
     y = m*x - m*x0 + y0
     slope, y-intercept can be used
     s,i

     for every point i encounter, i would have to compare it with others; n^2 and hash map can store all linear points
     */

    public static class HashPoint {
        int x; int y;
        HashPoint() {x = 0; y = 0;}
        HashPoint(int _x, int _y) {x = _x; y = _y;}

        public String toString() {
            return "(" + x + ", " + y + ")";
        }
    }

    public static class Line {
        float slope;
        float y_intercept;

        Line(float _slope, float _y_intercept) {
            slope = _slope;
            y_intercept = _y_intercept;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Line line = (Line) o;

            if (Float.compare(line.slope, slope) != 0) return false;
            return Float.compare(line.y_intercept, y_intercept) == 0;

        }

        @Override
        public int hashCode() {
            int result = (slope != +0.0f ? Float.floatToIntBits(slope) : 0);
            result = 31 * result + (y_intercept != +0.0f ? Float.floatToIntBits(y_intercept) : 0);
            return result;
        }

        @Override
        public String toString() {
            return "Line{" +
                    "slope=" + slope +
                    ", y_intercept=" + y_intercept +
                    '}';
        }
    }

    public static int calculateMaxPoints(HashPoint[] hashPoints) {
        if(hashPoints.length == 1)
            return 1;

        Map<Line, Set<HashPoint>> counterMap = new HashMap<>();

        for (int i = 0; i < hashPoints.length; i++) {
            HashPoint hashPointA = hashPoints[i];

            for(int j = i + 1; j < hashPoints.length; j++) {

                HashPoint hashPointB = hashPoints[j];

                float slope = calcSlope(hashPointA, hashPointB);
                float y_intercept = calcIntercept(hashPointA, slope);
                Line line = new Line(slope, y_intercept);

                if(! counterMap.containsKey(line)) {
                    counterMap.put(line, new HashSet<HashPoint>());
                }

                counterMap.get(line).add(hashPointA);
                counterMap.get(line).add(hashPointB);
            }
        }

        int max = 0;
        for(Map.Entry<Line, Set<HashPoint>> entry : counterMap.entrySet()) {
            max = Math.max(max, entry.getValue().size());
        }
        return max;
    }

    private static float calcIntercept(HashPoint hashPoint, float slope) {
        // y = mx + c, c = y - mx
        if(slope == Float.POSITIVE_INFINITY)
            return hashPoint.x;
        return hashPoint.y - slope * hashPoint.x;
    }

    private static float calcSlope(HashPoint hashPointA, HashPoint hashPointB) {
        if(hashPointA.x == hashPointB.x)
            return Float.POSITIVE_INFINITY;

        return (hashPointA.y - hashPointB.y) / (hashPointA.x - hashPointB.x);
    }

    /*public static void main(String[] args) {
        //HashPoint[] points = new HashPoint[]{new HashPoint(0,0), new HashPoint(0,0)};

        int result = calculateMaxPoints(getInput());
        System.out.println(result);
        getInput();
    }*/

    private static HashPoint[] getInput() {
        String points = "[84,250];[0,0];[1,0];[0,-70];[0,-70];[1,-1];[21,10];[42,90];[-42,-230]";
        List<HashPoint> hps = new ArrayList<>();
        for(String point : points.split(";")) {
            //System.out.println(point);
            String [] a = point.split(",|\\[|\\]");
            hps.add(new HashPoint(Integer.parseInt(a[1]), Integer.parseInt(a[2])));

        }
        //System.out.println(hps);
        HashPoint [] hashPoints = new HashPoint[hps.size()];
        return hps.toArray(hashPoints);
    }

    public static void main(String[] args) {
        ArrayList<Integer> x = new ArrayList<>(Arrays.asList(1,2));
        ArrayList<Integer> y = new ArrayList<>(Arrays.asList(1,2));
        MaxPointsOnaLine solve = new MaxPointsOnaLine();
        System.out.println(solve.maxPoints(x,y));

        x = new ArrayList<>(Arrays.asList(0,1, -1));
        y = new ArrayList<>(Arrays.asList(0,1, -1));
        System.out.println(solve.maxPoints(x,y));
    }

    private NumberFormat formatter = new DecimalFormat("#0.00");

    public int maxPoints(ArrayList<Integer> x, ArrayList<Integer> y) {
        if(x == null || x.isEmpty() || y == null || y.isEmpty())
            return 0;

        HashMap<String, HashSet<String>> lineFreqCounter = new HashMap<>();
        int max = 1;

        for(int i = 0; i < x.size(); i++) {
            String a = getPointStr(x.get(i), y.get(i));

            for(int j = i + 1; j < x.size(); j++) {
                String b = getPointStr(x.get(j), y.get(j));

                double slope = 0.0;

                if(x.get(j) == x.get(i)) {
                    slope = Double.MAX_VALUE;
                } else {
                    slope = (y.get(j) - y.get(i)) * 1.0 / (x.get(j) - x.get(i));
                }

                double intercept = y.get(j) - slope*x.get(j);
                String key = getSlopeAndInterceptStr(slope, intercept);
                if(!lineFreqCounter.containsKey(key)) {
                    lineFreqCounter.put(key, new HashSet<String>());
                }

                lineFreqCounter.get(key).add(a);
                lineFreqCounter.get(key).add(b);
            }

        }

        for(Map.Entry<String, HashSet<String>> entry : lineFreqCounter.entrySet()) {
            max = Math.max(entry.getValue().size(), max);
        }

        return max;

    }

    private String getSlopeAndInterceptStr(double slope, double intercept) {
        String s = formatter.format(slope);
        String i = formatter.format(intercept);

        return s + "_" + i;
    }

    private String getPointStr(int x, int y) {
        return x + "_" + y;
    }

}
