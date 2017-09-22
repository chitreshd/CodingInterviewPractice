package com.algos.practice.concepts.datastructures;

/**
 * Created by cdeshpande on 9/21/17.
 */
public class WeightedPath<T> {

    private Node<T> node;
    private int weight;
    private WeightedPath<T> parent;

    public WeightedPath(Node<T> node, int weight, WeightedPath<T> parent) {
        this.node = node;
        this.weight = weight;
        this.parent = parent;
    }

    public Node<T> getNode() {
        return node;
    }

    public int getWeight() {
        return weight;
    }

    public WeightedPath<T> getParent() {
        return parent;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setParent(WeightedPath<T> parent) {
        this.parent = parent;
    }
}
