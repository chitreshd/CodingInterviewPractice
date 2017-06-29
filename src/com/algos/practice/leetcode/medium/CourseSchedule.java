package com.algos.practice.leetcode.medium;

import java.util.*;

/**
 * Created by cdeshpande on 6/24/17.
 * Problem:
 * There are a total of n courses you have to take, labeled from 0 to n - 1.

 Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

 Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

 For example:

 2, [[1,0]]
 There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

 2, [[1,0],[0,1]]
 There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 */
public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = createGraph(prerequisites);
        Set<Integer> visited = new HashSet<>();
        Set<Integer> onStack = new HashSet<>();

        for(int n : graph.keySet()) {
            if(hasCycle(n, graph, visited, onStack)) {
                return false;
            }
        }
        return true;
    }

    private boolean hasCycle(int n, Map<Integer, List<Integer>> graph, Set<Integer> visited, Set<Integer> onStack) {
        visited.add(n);
        onStack.add(n);

        List<Integer> neighbours = graph.get(n);
        if(neighbours != null && !neighbours.isEmpty()) {
            for(int neighbour : neighbours) {
                if(onStack.contains(neighbour)) {
                    return true;
                }

                if(!visited.contains(neighbour)) {
                    boolean hasCycle = hasCycle(neighbour, graph, visited, onStack);
                    if(hasCycle) {
                        return hasCycle;
                    }
                }

            }
        }

        onStack.remove(n);
        return false;
    }

    private Map<Integer, List<Integer>> createGraph(int [][] prereqs) {

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int [] edge : prereqs) {
            int start = edge[0];
            int end = edge[1];
            if(!graph.containsKey(start)) {
                graph.put(start, new ArrayList<Integer>());

            }

            graph.get(start).add(end);
        }
        return graph;
    }


}
