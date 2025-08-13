package com.algos.practice.concepts.datastructures;

/**
 * Generic implementation of a linkedlist node.
 * @param <T>
 */
public class LNode<T> {
    private T data;
    private LNode<T> next;

    public LNode(T data) {
        this(data, null);
    }

    public LNode(T data, LNode<T> next) {
        this.data = data;
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public LNode<T> next() {
        return next;
    }

    public void setNext(LNode<T> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return String.format("{data: %s, next: %s}", this.data, (this.next == null ? "null" : String.valueOf(this.next.data)));
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj;
    }

    @Override
    public int hashCode() {
        return System.identityHashCode(this);
    }
}
