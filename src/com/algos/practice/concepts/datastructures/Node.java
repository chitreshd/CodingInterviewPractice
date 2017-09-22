package com.algos.practice.concepts.datastructures;

import java.util.*;

public class Node<T> {

    private T data;
    private Map<Node<T>, Integer> edges;


    public Node(T value) {
        this.data = value;
        this.edges = new HashMap<>();
    }

    public void addEdge(Node<T> target, int weight) {
        edges.put(target, weight);
    }

    public Collection<Map.Entry<Node<T>, Integer>> getEdges() {
        return Collections.unmodifiableSet(edges.entrySet());
    }

    private String getEdgesString() {
        StringBuilder builder = new StringBuilder();
        for(Map.Entry<Node<T>, Integer> entry : edges.entrySet()) {
            builder.append("[ ");
            builder.append(entry.getKey().getData());
            builder.append(":");
            builder.append(entry.getValue());
            builder.append(" ]");
        }
        return builder.toString();
    }
    @Override
    public String toString() {
        return String.format("{ val = %s, edges = {%s}", data, getEdgesString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node<?> node = (Node<?>) o;

        return data.equals(node.data);

    }

    @Override
    public int hashCode() {
        return data.hashCode();
    }

    public T getData() {
        return data;
    }
}
