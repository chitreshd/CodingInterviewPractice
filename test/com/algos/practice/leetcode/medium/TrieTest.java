package com.algos.practice.leetcode.medium;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by cdeshpande on 6/7/17.
 */
public class TrieTest {

    @Test
    public void testAll() {
        Trie trie = new Trie();
        trie.insert("bad");
        trie.insert("bat");
        trie.insert("a");

        assertTrue(trie.search("bad"));
        assertTrue(trie.search("bat"));
        assertTrue(trie.search("a"));
        assertFalse(trie.search("ab"));
        assertFalse(trie.search("ba"));
        assertFalse(trie.search(""));
        assertFalse(trie.search("z"));

        assertTrue(trie.startsWith("ba"));
        assertTrue(trie.startsWith("bad"));
        assertFalse(trie.startsWith("z"));
    }

}