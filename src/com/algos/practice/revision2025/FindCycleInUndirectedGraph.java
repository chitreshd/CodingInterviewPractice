package com.algos.practice.revision2025;

import com.algos.practice.concepts.datastructures.Graph;
import com.algos.practice.concepts.datastructures.Node;

import java.util.*;

/**
 * Algorithm to detect cycles in an undirected graph.
 * 
 * An undirected graph has a cycle if and only if a depth-first search (DFS) 
 * finds an edge that points to an already-visited vertex (other than the parent 
 * of the current vertex in the DFS tree).
 * 
 * Time Complexity: O(V + E) where V is number of vertices and E is number of edges
 * Space Complexity: O(V) for the visited set and recursion stack
 */
public class FindCycleInUndirectedGraph {

    /**
     * Detects if there's a cycle in the given undirected graph.
     *
     * Algo: A - B - C
     *             - D - A
     * vertices: [ A, B, C, D ]
     * edges: [ AB, BA, BC, CB, DB, BD, DA, AD ]
     *
     * 
     * @param graph The undirected graph to check for cycles
     * @return true if the graph contains a cycle, false otherwise
     */
    public boolean hasCycle(Graph<Character> graph) {
        if (graph == null || graph.getVertices().isEmpty()) {
            return false;
        }

        Set<Node<Character>> visited = new HashSet<>();

        for (Node<Character> node : graph.getVertices()) {
            // now DFS with this node as a starting point
            if (visited.contains(node)) {
                continue;
            }

            // TODO: revise - tracking parent is very important, because you dont want to chase parent again..GOTO-B
            boolean cycle = hasCycleDFS(node, null, visited);
            if (cycle) {
                return true;
            }

        }
        
        return false;
    }

    private boolean hasCycleDFS(Node<Character> node, Node<Character> parent, Set<Node<Character>> visited) {
        if ( node == null) {
            return false;
        }
        if ( visited.contains(node) ) {
            return true;
        }
        visited.add(node);
        for (Map.Entry<Node<Character>, Integer> edge : node.getEdges()) {
            Node<Character> neighbour = edge.getKey();
            // TODO: B see how we didn't chase parent, or else every graph will be cycle ( self cycle )
            if ( neighbour.equals(parent)) {
                continue;
            }
            if ( hasCycleDFS(neighbour, node, visited) ) {
                return true;
            }
        }
        return false;
    }
}