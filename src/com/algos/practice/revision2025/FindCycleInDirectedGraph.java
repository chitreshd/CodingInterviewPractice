package com.algos.practice.revision2025;

import com.algos.practice.concepts.datastructures.Graph;
import com.algos.practice.concepts.datastructures.Node;

import java.util.*;

/**
 * Algorithm to detect cycles in a directed graph.
 * 
 * A directed graph has a cycle if there is a path from a vertex back to itself 
 * following the direction of edges. This is different from undirected graphs 
 * where we need to avoid going back to the parent.
 * 
 * For directed graphs, we can use DFS with three states:
 * - WHITE (unvisited): Node hasn't been visited yet
 * - GRAY (visiting): Node is currently being processed (in recursion stack)
 * - BLACK (visited): Node and all its descendants have been processed
 * 
 * A cycle exists if we encounter a GRAY node during DFS traversal.
 * 
 * Time Complexity: O(V + E) where V is number of vertices and E is number of edges
 * Space Complexity: O(V) for the state tracking and recursion stack
 */
public class FindCycleInDirectedGraph {

    enum States {
        UNVISITED,
        VISITING,
        VISITED
    }

    /**
     * Detects if there's a cycle in the given directed graph.
     * 
     * Algorithm approach:
     * 1. Use DFS with three-color approach (WHITE, GRAY, BLACK)
     * 2. WHITE: unvisited node
     * 3. GRAY: node currently being processed (in recursion stack)
     * 4. BLACK: node completely processed
     * 5. If we encounter a GRAY node during traversal, we found a back edge (cycle)
     * 
     * Example with cycle:
     * A -> B -> C
     * ^         |
     * |         v
     * D <------ E
     * 
     * @param graph The directed graph to check for cycles
     * @return true if the graph contains a cycle, false otherwise
     */
    public boolean hasCycle(Graph<Character> graph) {
        Set<Node<Character>> nodes = graph.getVertices();
        Map<Node<Character>, Integer> nodeStates = new HashMap<>();
        for (Node<Character> node : nodes) {
            nodeStates.put(node, States.UNVISITED.ordinal());
        }

        for (Node<Character> node : nodes) {
            if (hasCycleDFS(node, nodeStates)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Helper method for DFS traversal with cycle detection.
     * 
     * @param node Current node being processed
     * @param nodeStates Map tracking the state of each node (WHITE=0, GRAY=1, BLACK=2)
     * @return true if a cycle is detected, false otherwise
     */
    private boolean hasCycleDFS(Node<Character> node, Map<Node<Character>, Integer> nodeStates) {
        if ( nodeStates.get(node) == States.VISITED.ordinal() ) {
            return false;
        }

        if ( nodeStates.get(node) == States.VISITING.ordinal() ) {
            // found cycle
            return true;
        }

        if ( nodeStates.get(node) == States.UNVISITED.ordinal() ) {
            nodeStates.replace(node, States.VISITING.ordinal());
        }

        Collection<Node<Character>> neighbours = getNeighbours(node);
        for (Node<Character> neighbour : neighbours) {
            if (hasCycleDFS(neighbour, nodeStates)) {
                return true;
            }
        }

        nodeStates.replace(node, States.VISITED.ordinal());

        return false;
    }

    private Collection<Node<Character>> getNeighbours(Node<Character> node) {
        Collection<Map.Entry<Node<Character>, Integer>> edges = node.getEdges();
        List<Node<Character>> neighbours = new ArrayList<>();
        for (Map.Entry<Node<Character>, Integer> edge : edges) {
            neighbours.add(edge.getKey());
        }
        return neighbours;
    }

    /**
     * Alternative approach using recursion stack tracking.
     * This method uses explicit tracking of nodes in the current recursion path.
     * 
     * @param graph The directed graph to check for cycles
     * @return true if the graph contains a cycle, false otherwise
     */
    public boolean hasCycleUsingRecursionStack(Graph<Character> graph) {
        // TODO: Implement alternative approach using visited set and recursion stack set
        return false;
    }

    /**
     * Helper method for recursion stack approach.
     * 
     * @param node Current node being processed
     * @param visited Set of all visited nodes
     * @param recursionStack Set of nodes currently in the recursion stack
     * @return true if a cycle is detected, false otherwise
     */
    private boolean hasCycleDFSRecursionStack(Node<Character> node, 
                                            Set<Node<Character>> visited, 
                                            Set<Node<Character>> recursionStack) {
        // TODO: Implement DFS with recursion stack tracking
        return false;
    }
}