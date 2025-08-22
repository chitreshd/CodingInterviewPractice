package com.algos.practice.revision2025;

import com.algos.practice.concepts.datastructures.Graph;
import com.algos.practice.concepts.datastructures.Node;
import org.junit.Test;

import static org.junit.Assert.*;

public class FindCycleInUndirectedGraphTest {

    private Graph<Character> buildAcyclicGraph() throws IllegalAccessException {
        Graph<Character> graph = new Graph<>();
        
        // Create nodes: A, B, C, D, E
        Node<Character> nodeA = new Node<>('A');
        Node<Character> nodeB = new Node<>('B');
        Node<Character> nodeC = new Node<>('C');
        Node<Character> nodeD = new Node<>('D');
        Node<Character> nodeE = new Node<>('E');
        
        // Add nodes to graph
        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        graph.addNode(nodeD);
        graph.addNode(nodeE);
        
        // Create acyclic structure: A-B-C, A-D-E
        // For undirected graph, we add edges in both directions
        graph.addEdge(nodeA, nodeB, 1);
        graph.addEdge(nodeB, nodeA, 1);
        graph.addEdge(nodeB, nodeC, 1);
        graph.addEdge(nodeC, nodeB, 1);
        graph.addEdge(nodeA, nodeD, 1);
        graph.addEdge(nodeD, nodeA, 1);
        graph.addEdge(nodeD, nodeE, 1);
        graph.addEdge(nodeE, nodeD, 1);
        
        return graph;
    }

    private Graph<Character> buildCyclicGraph() throws IllegalAccessException {
        Graph<Character> graph = new Graph<>();
        
        // Create nodes: A, B, C, D
        Node<Character> nodeA = new Node<>('A');
        Node<Character> nodeB = new Node<>('B');
        Node<Character> nodeC = new Node<>('C');
        Node<Character> nodeD = new Node<>('D');
        
        // Add nodes to graph
        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        graph.addNode(nodeD);
        
        // Create cyclic structure: A-B-C-D-A (forms a cycle)
        // For undirected graph, we add edges in both directions
        graph.addEdge(nodeA, nodeB, 1);
        graph.addEdge(nodeB, nodeA, 1);
        graph.addEdge(nodeB, nodeC, 1);
        graph.addEdge(nodeC, nodeB, 1);
        graph.addEdge(nodeC, nodeD, 1);
        graph.addEdge(nodeD, nodeC, 1);
        graph.addEdge(nodeD, nodeA, 1);
        graph.addEdge(nodeA, nodeD, 1);
        
        return graph;
    }

    private Graph<Character> buildSimpleCyclicGraph() throws IllegalAccessException {
        Graph<Character> graph = new Graph<>();
        
        // Create nodes: A, B, C
        Node<Character> nodeA = new Node<>('A');
        Node<Character> nodeB = new Node<>('B');
        Node<Character> nodeC = new Node<>('C');
        
        // Add nodes to graph
        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        
        // Create simple cycle: A-B-C-A
        graph.addEdge(nodeA, nodeB, 1);
        graph.addEdge(nodeB, nodeA, 1);
        graph.addEdge(nodeB, nodeC, 1);
        graph.addEdge(nodeC, nodeB, 1);
        graph.addEdge(nodeC, nodeA, 1);
        graph.addEdge(nodeA, nodeC, 1);
        
        return graph;
    }

    private Graph<Character> buildSingleNodeGraph() {
        Graph<Character> graph = new Graph<>();
        Node<Character> nodeA = new Node<>('A');
        graph.addNode(nodeA);
        return graph;
    }

    private Graph<Character> buildEmptyGraph() {
        return new Graph<>();
    }

    @Test
    public void noCycle_acyclicGraph_returnsFalse() throws IllegalAccessException {
        FindCycleInUndirectedGraph algo = new FindCycleInUndirectedGraph();
        Graph<Character> graph = buildAcyclicGraph();

        boolean result = algo.hasCycle(graph);

        assertFalse("Acyclic graph should not have a cycle", result);
    }

    @Test
    public void hasCycle_cyclicGraph_returnsTrue() throws IllegalAccessException {
        FindCycleInUndirectedGraph algo = new FindCycleInUndirectedGraph();
        Graph<Character> graph = buildCyclicGraph();

        boolean result = algo.hasCycle(graph);

        assertTrue("Cyclic graph should have a cycle", result);
    }

    @Test
    public void hasCycle_simpleCyclicGraph_returnsTrue() throws IllegalAccessException {
        FindCycleInUndirectedGraph algo = new FindCycleInUndirectedGraph();
        Graph<Character> graph = buildSimpleCyclicGraph();

        boolean result = algo.hasCycle(graph);

        assertTrue("Simple cyclic graph should have a cycle", result);
    }

    @Test
    public void noCycle_singleNode_returnsFalse() {
        FindCycleInUndirectedGraph algo = new FindCycleInUndirectedGraph();
        Graph<Character> graph = buildSingleNodeGraph();

        boolean result = algo.hasCycle(graph);

        assertFalse("Single node graph should not have a cycle", result);
    }

    @Test
    public void noCycle_emptyGraph_returnsFalse() {
        FindCycleInUndirectedGraph algo = new FindCycleInUndirectedGraph();
        Graph<Character> graph = buildEmptyGraph();

        boolean result = algo.hasCycle(graph);

        assertFalse("Empty graph should not have a cycle", result);
    }

    @Test
    public void noCycle_twoNodesConnected_returnsFalse() throws IllegalAccessException {
        FindCycleInUndirectedGraph algo = new FindCycleInUndirectedGraph();
        Graph<Character> graph = new Graph<>();
        
        Node<Character> nodeA = new Node<>('A');
        Node<Character> nodeB = new Node<>('B');
        
        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addEdge(nodeA, nodeB, 1);
        graph.addEdge(nodeB, nodeA, 1);

        boolean result = algo.hasCycle(graph);

        assertFalse("Two connected nodes should not form a cycle", result);
    }
}