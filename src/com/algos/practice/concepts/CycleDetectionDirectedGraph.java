package com.algos.practice.concepts;

import java.util.*;

/**
 * Created by cdeshpande on 9/3/17.
 */
public class CycleDetectionDirectedGraph {

    public static class Node {
        int val;
        Collection<Node> neighbours;

        public Node(int val) {
            this.val = val;
            neighbours = new HashSet<>();
        }

        public void addNeighbour(Node ... nodes) {
            if(nodes == null)
                return;

            for(Node node : nodes) {
                if(node != null) {
                    neighbours.add(node);
                }
            }

        }

        public Collection<Node> getNeighbours() {
            return neighbours;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node node = (Node) o;

            return val == node.val;

        }

        @Override
        public int hashCode() {
            return val;
        }

        @Override
        public String toString() {
            StringBuffer buffer = new StringBuffer();
            buffer.append("{ val = ");
            buffer.append(val);
            buffer.append(", ");
            List<Integer> neighbourVals = new ArrayList<>();
            for(Node neighbour : neighbours) {
                neighbourVals.add(neighbour.val);
            }
            buffer.append("neighbours = ");
            buffer.append(neighbourVals.toString());
            buffer.append(" }");
            return buffer.toString();
        }


    }


    /**
     * This method detects a cycle given a start node.
     *
     * @param startNode
     * @return: Cyclic Node or Null if no cycle
     */
    protected Node detectCycleWrong(Node startNode) {
        Stack<Node> stack = new Stack<>();
        Set<Node> stackHash = new HashSet<>();
        Set<Node> visited = new HashSet<>();

        push(startNode, stack, stackHash);
        while(!stack.isEmpty()) {
            Node node = stack.peek();
            pop(stack, stackHash);
            if(visited.contains(node)) {
                continue;
            }

            visited.add(node);
            System.out.println("Visited: " + node);
            Collection<Node> neighbours = node.getNeighbours();
            for(Node neighbour : neighbours) {
                if(stackHash.contains(neighbour)) {
                    System.out.println("Stack: " + stack);
                    System.out.println("Cycle detected for node: " + neighbour);
                    return neighbour;
                }
                push(neighbour, stack, stackHash);
            }

        }
        return null;
    }

    private void push(Node node, Stack<Node> stack, Set<Node> stackHash) {
        stack.push(node);
        stackHash.add(node);
    }

    private void pop(Stack<Node> stack, Set<Node> stackHash) {
        Node node = stack.pop();
        stackHash.remove(node);
    }

    /**
     * This method detects a cycle given a start node.
     *
     * @param currNode
     * @return: Cyclic Node or Null if no cycle
     */
    protected Node detectCycleRecur(Node currNode, HashSet<Node> onStack, HashSet<Node> visited) {
        if(currNode == null)
            return null;

        if(visited.contains(currNode))
            return null;

        if(onStack.contains(currNode))
            return currNode; // detected cycle, return the cyclic node.


        onStack.add(currNode);

        Collection<Node> neighbours = currNode.getNeighbours();
        for(Node neighbour : neighbours) {
            Node node = detectCycleRecur(neighbour, onStack, visited);
            if(node != null) {
                // short circuit if we found a cycle.
                return node;
            }

        }

        visited.add(currNode);
        onStack.remove(currNode);
        return null;

    }
}
