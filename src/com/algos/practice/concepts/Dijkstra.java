package com.algos.practice.concepts;

import com.algos.practice.concepts.datastructures.Graph;
import com.algos.practice.concepts.datastructures.Node;
import com.algos.practice.concepts.datastructures.WeightedPath;

import java.util.*;

/**
 * Created by cdeshpande on 9/20/17.
 * Ref: https://ocw.mit.edu/courses/electrical-engineering-and-computer-science/6-006-introduction-to-algorithms-fall-2011/lecture-videos/MIT6_006F11_lec16.pdf
 */
public class Dijkstra <T> {

    public Map<Node<T>, WeightedPath<T>> shortestPath(Graph<T> graph, Node<T> start) {
        Map<Node<T>,WeightedPath<T>> paths = new HashMap<>();
        Set<Node<T>> done = new HashSet<>();

        Comparator<WeightedPath<T>> pathComparator = new Comparator<WeightedPath<T>>() {
            @Override
            public int compare(WeightedPath<T> o1, WeightedPath<T> o2) {
                return Integer.compare(o1.getWeight(), o2.getWeight());
            }
        };

        PriorityQueue<WeightedPath<T>> queue = new PriorityQueue<>(10,pathComparator);
        WeightedPath<T> startPath = new WeightedPath<>(start, 0, null);
        queue.add(startPath);

        while(!queue.isEmpty()) {
            WeightedPath<T> curr = queue.poll();
            paths.put(curr.getNode(), curr);
            done.add(curr.getNode());

            Collection<Map.Entry<Node<T>, Integer>> neighbours = curr.getNode().getEdges();
            for(Map.Entry<Node<T>, Integer> neighbour : neighbours) {
                Node<T> node = neighbour.getKey();
                if(done.contains(node))
                    continue;

                int edgeWeight = neighbour.getValue();
                if(!paths.containsKey(node)) {
                    WeightedPath<T> weightedPath = new WeightedPath<>(node, Integer.MAX_VALUE, curr);
                    paths.put(node, weightedPath);
                    queue.add(weightedPath);
                }

                // Relax edge
                WeightedPath<T> weightedPath = paths.get(node);
                int newWeight = curr.getWeight() + edgeWeight;
                if(weightedPath.getWeight() > newWeight) {
                    weightedPath.setWeight(newWeight);
                    weightedPath.setParent(curr);
                }

            }
        }

        return paths;

    }
}
