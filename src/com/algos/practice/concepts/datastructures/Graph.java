package com.algos.practice.concepts.datastructures;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by cdeshpande on 9/21/17.
 */
public class Graph <T> {

    private Set<Node<T>> vertices;
    private Set<Edge<T>> edges;

    public Graph() {
        vertices = new HashSet<>();
        edges = new HashSet<>();
    }

    public void addNode(Node<T> node) {
        vertices.add(node);
    }

    public void addEdge(Node<T> source, Node<T> dest, int weight) throws IllegalAccessException {
        if(!vertices.contains(source) || !vertices.contains(dest)) {
            throw new IllegalAccessException("vertices should be added to graph before creating edges");
        }

        source.addEdge(dest, weight);
        edges.add(new Edge<>(source, dest, weight));
    }


    public Set<Node<T>> getVertices() {
        return vertices;
    }

    public Set<Edge<T>> getEdges() {
        return edges;
    }

    public void addAllNode(List<Node<T>> nodes) {
        for(Node<T> node : nodes) {
            vertices.add(node);
        }
    }
}

