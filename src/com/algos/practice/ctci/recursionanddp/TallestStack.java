package com.algos.practice.ctci.recursionanddp;

import java.util.*;

/**
 * Created by cdeshpande on 7/30/17.
 * Problem:
 * You have a stack of n boxes with width wi, height hi and depths di. The boxes can;t be
 * rotated and can only be stacked on top of one another if each box is strictly larger than
 * the box above it in width, height and depth. Implement a method to build tallest stack
 * possible, where the height of stack is sum of all boxes' heights.
 *
 */
public class TallestStack {

    public static class Box {
        int height;
        int width;
        int depth;

        public Box(int height, int width, int depth) {
            this.height = height;
            this.width = width;
            this.depth = depth;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Box box = (Box) o;

            if (height != box.height) return false;
            if (width != box.width) return false;
            return depth == box.depth;

        }

        @Override
        public int hashCode() {
            int result = height;
            result = 31 * result + width;
            result = 31 * result + depth;
            return result;
        }

        @Override
        public String toString() {
            return "Box{" +
                    "height=" + height +
                    ", width=" + width +
                    ", depth=" + depth +
                    '}';
        }
    }


    public ArrayList<Box> createStack(List<Box> input) {
        Set<Box> unUsed = new HashSet<>(input);
        Map<Box, ArrayList<Box>> results = new HashMap<>();
        ArrayList<Box> max = new ArrayList<>();

        for(Box box : input) {
            unUsed.remove(box);
            ArrayList<Box> curr = doCreateStack(box, unUsed, results);
            unUsed.add(box);
            //curr.add(box);
            if(max.size() < curr.size()) {
                max = curr;
            }
        }

        return max;


    }
    public ArrayList<Box> doCreateStack(Box box,
                                 Set<Box> unUsed,
                                 Map<Box, ArrayList<Box>> results) {
        System.out.println("Evaluating bx: " + box);

        if(results.containsKey(box)) {
            System.out.println("used cache for box: " + box);
            return results.get(box);
        }

        ArrayList<Box> max = new ArrayList<>();


        for(Box unUsedBox : new ArrayList<>(unUsed)) {
            if(isSmaller(unUsedBox, box)) {
                unUsed.remove(unUsedBox);
                ArrayList<Box> stack = doCreateStack(unUsedBox, unUsed, results);
                if(stack.size() > max.size()) {
                    max = stack;
                }
                unUsed.add(unUsedBox);
            }

        }

        ArrayList<Box> maxClone = (ArrayList<Box>) max.clone();
        maxClone.add(box);
        results.put(box, maxClone);

        return results.get(box);
    }

    private boolean isSmaller(Box target, Box ref) {
        return      target.height < ref.height
               &&   target.width < ref.width
               &&   target.depth < ref.depth;
    }
}
