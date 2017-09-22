package com.algos.practice.concepts;

import com.algos.practice.concepts.datastructures.Graph;
import com.algos.practice.concepts.datastructures.Node;
import com.algos.practice.concepts.datastructures.WeightedPath;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cdeshpande on 9/22/17.
 */
public class DijkstraTest {
    Dijkstra<Character> dijkstra = new Dijkstra<>();

    @Test
    public void shortestPath() throws Exception {
        Graph<Character> graph = new Graph<>();
        Map<Character, Node<Character>> map = createNodes('A','B','C','D','E');

        for(Node<Character> node : map.values()) {
            graph.addNode(node);
        }

        graph.addEdge(map.get('A'), map.get('B'), 10);
        graph.addEdge(map.get('A'), map.get('C'), 3);

        graph.addEdge(map.get('B'), map.get('C'), 1);
        graph.addEdge(map.get('B'), map.get('D'), 2);

        graph.addEdge(map.get('C'), map.get('B'), 4);
        graph.addEdge(map.get('C'), map.get('E'), 2);
        graph.addEdge(map.get('C'), map.get('D'), 8);

        graph.addEdge(map.get('D'), map.get('E'), 7);
        graph.addEdge(map.get('E'), map.get('D'), 9);

        for(Node<Character> nodes : graph.getVertices() ) {
            System.out.println(nodes);
        }

        Map<Node<Character>, WeightedPath<Character>> shortestPaths = dijkstra.shortestPath(graph, map.get('A'));
        for(Map.Entry<Node<Character>, WeightedPath<Character>> entry : shortestPaths.entrySet()) {
            Node<Character> node = entry.getKey();
            WeightedPath<Character> path = entry.getValue();
            Character parent = path.getParent() == null ? '#' : path.getParent().getNode().getData();
            int totalSum = path.getWeight();

            System.out.println(String.format("Parent: %s ----%s----- Node: %s", parent, totalSum, node.getData()));
        }

    }

    private Map<Character, Node<Character>> createNodes(char ... arr) {
        Map<Character, Node<Character>> nodes = new HashMap<>();
        for(char curr : arr) {
            nodes.put(curr, new Node<>(curr));
        }
        return nodes;
    }

}