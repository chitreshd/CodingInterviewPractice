package com.algos.practice.concepts.datastructures;

/**
 * Created by cdeshpande on 9/21/17.
 */
public class Edge<T> {

    private Node<T> source;
    private Node<T> target;
    private int weight;

    public Edge(Node<T> source, Node<T> target, int weight) {
        this.source = source;
        this.target = target;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "source=" + source.getData() +
                ", target=" + target.getData() +
                ", weight=" + weight +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Edge<?> edge = (Edge<?>) o;

        if (weight != edge.weight) return false;
        if (!source.equals(edge.source)) return false;
        return target.equals(edge.target);

    }

    @Override
    public int hashCode() {
        int result = source.hashCode();
        result = 31 * result + target.hashCode();
        result = 31 * result + weight;
        return result;
    }
}
