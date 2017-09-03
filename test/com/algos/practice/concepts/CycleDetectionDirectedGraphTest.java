package com.algos.practice.concepts;

import com.algos.practice.concepts.CycleDetectionDirectedGraph.Node;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by cdeshpande on 9/3/17.
 */
public class CycleDetectionDirectedGraphTest {
    private CycleDetectionDirectedGraph solve = new CycleDetectionDirectedGraph();

    private List<Node> createGraphNoCycle() {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);

        one.addNeighbour(two, three, six);
        two.addNeighbour(four, five);
        three.addNeighbour(two);
        four.addNeighbour(five);

        System.out.println(one);
        System.out.println(two);
        System.out.println(three);
        System.out.println(four);
        System.out.println(five);
        System.out.println(six);

        return Arrays.asList(one);
    }

    private List<Node> createGraphWithCycle() {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);

        one.addNeighbour(two, three, six);
        two.addNeighbour(four, five);
        three.addNeighbour(two);
        four.addNeighbour(five, one);

        System.out.println(one);
        System.out.println(two);
        System.out.println(three);
        System.out.println(four);
        System.out.println(five);
        System.out.println(six);

        return Arrays.asList(one);
    }

    @Test
    public void detectCycle() {
        List<Node> nodes = createGraphNoCycle();
        Node cyclicNode = solve.detectCycleRecur(nodes.get(0), new HashSet<Node>(), new HashSet<Node>());
        assertNull(cyclicNode);

        nodes = createGraphWithCycle();
        cyclicNode = solve.detectCycleRecur(nodes.get(0), new HashSet<Node>(), new HashSet<Node>());
        assertNotNull(cyclicNode);
        System.out.println("Cyclic node: " + cyclicNode);

    }

}