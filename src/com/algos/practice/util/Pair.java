package com.algos.practice.util;

public class Pair<K, V> {
    public final K fst;
    public final V snd;
    
    public Pair(K fst, V snd) {
        this.fst = fst;
        this.snd = snd;
    }
    
    public K getKey() { return fst; }
    public V getValue() { return snd; }
}
