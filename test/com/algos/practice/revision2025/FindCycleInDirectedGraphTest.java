package com.algos.practice.revision2025;

import com.algos.practice.concepts.datastructures.Graph;
import com.algos.practice.concepts.datastructures.Node;
import org.junit.Test;

import static org.junit.Assert.*;

public class FindCycleInDirectedGraphTest {

    private Graph<Character> buildAcyclicDirectedGraph() throws IllegalAccessException {
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
        
        // Create acyclic DAG: A->B->C, A->D->E
        // For directed graph, we only add edges in one direction
        graph.addEdge(nodeA, nodeB, 1);
        graph.addEdge(nodeB, nodeC, 1);
        graph.addEdge(nodeA, nodeD, 1);
        graph.addEdge(nodeD, nodeE, 1);
        
        return graph;
    }

    private Graph<Character> buildCyclicDirectedGraph() throws IllegalAccessException {
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
        
        // Create cyclic structure: A->B->C->D->A (forms a cycle)
        graph.addEdge(nodeA, nodeB, 1);
        graph.addEdge(nodeB, nodeC, 1);
        graph.addEdge(nodeC, nodeD, 1);
        graph.addEdge(nodeD, nodeA, 1); // Creates cycle back to A
        
        return graph;
    }

    private Graph<Character> buildSelfLoopGraph() throws IllegalAccessException {
        Graph<Character> graph = new Graph<>();
        
        // Create node: A
        Node<Character> nodeA = new Node<>('A');
        
        // Add node to graph
        graph.addNode(nodeA);
        
        // Create self-loop: A->A
        graph.addEdge(nodeA, nodeA, 1);
        
        return graph;
    }

    private Graph<Character> buildComplexCyclicGraph() throws IllegalAccessException {
        Graph<Character> graph = new Graph<>();
        
        // Create nodes: A, B, C, D, E, F
        Node<Character> nodeA = new Node<>('A');
        Node<Character> nodeB = new Node<>('B');
        Node<Character> nodeC = new Node<>('C');
        Node<Character> nodeD = new Node<>('D');
        Node<Character> nodeE = new Node<>('E');
        Node<Character> nodeF = new Node<>('F');
        
        // Add nodes to graph
        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        graph.addNode(nodeD);
        graph.addNode(nodeE);
        graph.addNode(nodeF);
        
        // Create complex structure with cycle: A->B->C->E->F, B->D->E (E->B creates cycle)
        graph.addEdge(nodeA, nodeB, 1);
        graph.addEdge(nodeB, nodeC, 1);
        graph.addEdge(nodeC, nodeE, 1);
        graph.addEdge(nodeE, nodeF, 1);
        graph.addEdge(nodeB, nodeD, 1);
        graph.addEdge(nodeD, nodeE, 1);
        graph.addEdge(nodeE, nodeB, 1); // Creates cycle: B->D->E->B
        
        return graph;
    }

    private Graph<Character> buildDisconnectedAcyclicGraph() throws IllegalAccessException {
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
        
        // Create disconnected components: A->B, C->D (no cycles)
        graph.addEdge(nodeA, nodeB, 1);
        graph.addEdge(nodeC, nodeD, 1);
        
        return graph;
    }

    private Graph<Character> buildDisconnectedCyclicGraph() throws IllegalAccessException {
        Graph<Character> graph = new Graph<>();
        
        // Create nodes: A, B, C, D, E, F
        Node<Character> nodeA = new Node<>('A');
        Node<Character> nodeB = new Node<>('B');
        Node<Character> nodeC = new Node<>('C');
        Node<Character> nodeD = new Node<>('D');
        Node<Character> nodeE = new Node<>('E');
        Node<Character> nodeF = new Node<>('F');
        
        // Add nodes to graph
        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        graph.addNode(nodeD);
        graph.addNode(nodeE);
        graph.addNode(nodeF);
        
        // Create disconnected components: A->B (acyclic), C->D->E->C (cyclic)
        graph.addEdge(nodeA, nodeB, 1);
        graph.addEdge(nodeC, nodeD, 1);
        graph.addEdge(nodeD, nodeE, 1);
        graph.addEdge(nodeE, nodeC, 1); // Creates cycle in second component
        
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
    public void noCycle_acyclicDirectedGraph_returnsFalse() throws IllegalAccessException {
        FindCycleInDirectedGraph algo = new FindCycleInDirectedGraph();
        Graph<Character> graph = buildAcyclicDirectedGraph();

        boolean result = algo.hasCycle(graph);

        assertFalse("Acyclic directed graph should not have a cycle", result);
    }

    @Test
    public void hasCycle_cyclicDirectedGraph_returnsTrue() throws IllegalAccessException {
        FindCycleInDirectedGraph algo = new FindCycleInDirectedGraph();
        Graph<Character> graph = buildCyclicDirectedGraph();

        boolean result = algo.hasCycle(graph);

        assertTrue("Cyclic directed graph should have a cycle", result);
    }

    @Test
    public void hasCycle_selfLoop_returnsTrue() throws IllegalAccessException {
        FindCycleInDirectedGraph algo = new FindCycleInDirectedGraph();
        Graph<Character> graph = buildSelfLoopGraph();

        boolean result = algo.hasCycle(graph);

        assertTrue("Self-loop should be detected as a cycle", result);
    }

    @Test
    public void hasCycle_complexCyclicGraph_returnsTrue() throws IllegalAccessException {
        FindCycleInDirectedGraph algo = new FindCycleInDirectedGraph();
        Graph<Character> graph = buildComplexCyclicGraph();

        boolean result = algo.hasCycle(graph);

        assertTrue("Complex graph with cycle should be detected", result);
    }

    @Test
    public void noCycle_disconnectedAcyclicGraph_returnsFalse() throws IllegalAccessException {
        FindCycleInDirectedGraph algo = new FindCycleInDirectedGraph();
        Graph<Character> graph = buildDisconnectedAcyclicGraph();

        boolean result = algo.hasCycle(graph);

        assertFalse("Disconnected acyclic graph should not have a cycle", result);
    }

    @Test
    public void hasCycle_disconnectedCyclicGraph_returnsTrue() throws IllegalAccessException {
        FindCycleInDirectedGraph algo = new FindCycleInDirectedGraph();
        Graph<Character> graph = buildDisconnectedCyclicGraph();

        boolean result = algo.hasCycle(graph);

        assertTrue("Disconnected graph with one cyclic component should have a cycle", result);
    }

    @Test
    public void noCycle_singleNode_returnsFalse() {
        FindCycleInDirectedGraph algo = new FindCycleInDirectedGraph();
        Graph<Character> graph = buildSingleNodeGraph();

        boolean result = algo.hasCycle(graph);

        assertFalse("Single node graph should not have a cycle", result);
    }

    @Test
    public void noCycle_emptyGraph_returnsFalse() {
        FindCycleInDirectedGraph algo = new FindCycleInDirectedGraph();
        Graph<Character> graph = buildEmptyGraph();

        boolean result = algo.hasCycle(graph);

        assertFalse("Empty graph should not have a cycle", result);
    }

    @Test
    public void noCycle_twoNodesDirected_returnsFalse() throws IllegalAccessException {
        FindCycleInDirectedGraph algo = new FindCycleInDirectedGraph();
        Graph<Character> graph = new Graph<>();
        
        Node<Character> nodeA = new Node<>('A');
        Node<Character> nodeB = new Node<>('B');
        
        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addEdge(nodeA, nodeB, 1); // Only one direction for directed graph

        boolean result = algo.hasCycle(graph);

        assertFalse("Two nodes with single directed edge should not form a cycle", result);
    }

    @Test
    public void hasCycle_twoNodesBidirectional_returnsTrue() throws IllegalAccessException {
        FindCycleInDirectedGraph algo = new FindCycleInDirectedGraph();
        Graph<Character> graph = new Graph<>();
        
        Node<Character> nodeA = new Node<>('A');
        Node<Character> nodeB = new Node<>('B');
        
        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addEdge(nodeA, nodeB, 1);
        graph.addEdge(nodeB, nodeA, 1); // Bidirectional creates cycle

        boolean result = algo.hasCycle(graph);

        assertTrue("Two nodes with bidirectional edges should form a cycle", result);
    }
}