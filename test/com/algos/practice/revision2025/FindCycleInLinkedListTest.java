package com.algos.practice.revision2025;

import com.algos.practice.concepts.datastructures.LNode;
import com.algos.practice.util.Pair;
import org.junit.Test;

import static org.junit.Assert.*;

public class FindCycleInLinkedListTest {

    private LNode<Character> buildAcyclicList(String values) {
        LNode<Character> head = null;
        LNode<Character> tail = null;
        for (char c : values.toCharArray()) {
            LNode<Character> node = new LNode<>(c);
            if (head == null) {
                head = node;
                tail = node;
            } else {
                tail.setNext(node);
                tail = node;
            }
        }
        return head;
    }

    private LNode<Character> buildCyclicList(String values, int cycleStartIndex) {
        LNode<Character> head = null;
        LNode<Character> tail = null;
        LNode<Character> cycleStart = null;
        int idx = 0;
        for (char c : values.toCharArray()) {
            LNode<Character> node = new LNode<>(c);
            if (head == null) {
                head = node;
                tail = node;
            } else {
                tail.setNext(node);
                tail = node;
            }
            if (idx == cycleStartIndex) {
                cycleStart = node;
            }
            idx++;
        }
        // make cycle
        if (tail != null) {
            tail.setNext(cycleStart);
        }
        return head;
    }

    @Test
    public void noCycle_returnsFalseAndNullStart() {
        FindCycleInLinkedList algo = new FindCycleInLinkedList();
        LNode<Character> head = buildAcyclicList("ABCDE");

        Pair<Boolean, LNode<Character>> result = algo.IsCycle(head);

        assertFalse(result.fst);
        assertNull(result.snd);
    }

    @Test
    public void hasCycle_returnsTrueAndCycleStart() {
        FindCycleInLinkedList algo = new FindCycleInLinkedList();
        // List: A -> B -> C -> D -> E -> C (cycle starts at C index 2)
        LNode<Character> head = buildCyclicList("ABCDE", 2);

        Pair<Boolean, LNode<Character>> result = algo.IsCycle(head);

        assertTrue(result.fst);
        assertNotNull(result.snd);
        assertEquals(Character.valueOf('C'), result.snd.getData());
    }
}
