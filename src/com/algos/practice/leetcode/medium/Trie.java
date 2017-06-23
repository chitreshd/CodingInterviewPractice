package com.algos.practice.leetcode.medium;

import java.util.HashMap;

/**
 * Created by cdeshpande on 6/6/17.
 */
public class Trie {
    /** Initialize your data structure here. */
    private Node root;

    public Trie() {
        root = new Node('#',false);
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node current = root;

        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(!current.children.containsKey(c)) {
                Node next = new Node(c,false);
                current.children.put(c,next);
            }

            current = current.children.get(c);
        }

        if(current != root) {
            current.word = true;
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node node = searchNode(word);
        if(node == null || node == root)
            return false;

        return node.word;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node node = searchNode(prefix);
        if(node == null || node == root)
            return false;

        return true;
    }

    private Node searchNode(String s) {
        Node current = root;

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(!current.children.containsKey(c)) {
                return null;
            }

            current = current.children.get(c);
        }

        return current;
    }
    private static class Node {
        char key;
        boolean word;
        HashMap<Character, Node> children;

        Node(char k, boolean word) {
            this.key = k;
            this.word = word;
            children = new HashMap<>();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node node = (Node) o;

            return key == node.key;

        }

        @Override
        public int hashCode() {
            return (int) key;
        }
    }


}
