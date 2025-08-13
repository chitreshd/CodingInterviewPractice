package com.algos.practice.revision2025;

import com.algos.practice.concepts.datastructures.LNode;
import com.algos.practice.util.Pair;

public class FindCycleInLinkedList {

    /**
     * This function will detect if there's a cycle in the linkedList. Will return true if there's a cycle.
     * If true, it will also return the LNode<Character> which is the start of the loop/cycle.
     * @param linkedListHead
     * @return
     */
    public Pair<Boolean, LNode<Character>> IsCycle(LNode<Character> linkedListHead) {
        // Run two pointers, one fast and one slow, when they meet, thats the linkedList's cycle.
        // If they dont meet, then there's no cycle.
        LNode<Character> fastPointer = linkedListHead;
        LNode<Character> slowPointer = linkedListHead;
        boolean cycleExist = false;

        while(slowPointer != null) {
            if (fastPointer.equals(slowPointer) && !slowPointer.equals(linkedListHead)) {
                // we found the cycle
                cycleExist = true;
                break;
            }
            slowPointer = slowPointer.next();
            if (fastPointer.next() == null) {
                return new Pair<>(cycleExist, null);
            }
            fastPointer = fastPointer.next().next();
        }

        // Then we reset fast to start of the cycle. Doesn;t matter which pointer as in this step, both pointers
        // will move at step at a time.
        fastPointer = linkedListHead;
        while(!fastPointer.equals(slowPointer)) {
            fastPointer = fastPointer.next();
            slowPointer = slowPointer.next();
        }
        return new Pair<>(cycleExist, fastPointer);
    }
}
