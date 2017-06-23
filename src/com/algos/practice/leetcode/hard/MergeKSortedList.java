package com.algos.practice.leetcode.hard;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by cdeshpande on 5/27/17.
 *
 * Problem:
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 *
 * Solution:
 * Using Heap/Priority Queue.
 * 1. Add all the head elements of all the lists to the PQ. k* log(k)
 * 2. remove the head of PQ (this is guaranteed to be the min) log(k)
 * 3. replace the removed element from PQ, from the same element log(k)
 */
public class MergeKSortedList {


    public ListNode mergeKLists(ListNode[] lists) {
        Comparator<ListNode> comparator = new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return Integer.compare(o1.val, o2.val);
            }
        };
        ListNode sortedListHead = null;
        ListNode sortedListCurr = null;

        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length,comparator);

        prefillPQWithHeads(pq, lists);

        while(!pq.isEmpty()) {
            ListNode nextSmallest = pq.poll();
            ListNode toBeAdded = nextSmallest.next;
            nextSmallest.next = null;



            if(sortedListHead == null) {
                sortedListHead = nextSmallest;
                sortedListCurr = nextSmallest;
            } else {
                sortedListCurr.next = nextSmallest;
                sortedListCurr = nextSmallest;
            }

            if(toBeAdded != null) {
                pq.add(toBeAdded);
            }

        }

        return sortedListHead;
    }

    private void prefillPQWithHeads(PriorityQueue<ListNode> pq, ListNode[] lists) {
        for(ListNode head : lists) {
            if(head != null) {
                pq.add(head);
            }
        }
    }



    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }
}
