package com.algos.practice.leetcode.hard;

import org.junit.Test;

/**
 * Created by cdeshpande on 5/27/17.
 */
public class MergeKSortedListTest {


    @Test
    public void mergeKLists() throws Exception {

        MergeKSortedList.ListNode of3 = create(3,6,9);
        MergeKSortedList.ListNode of2 = create(2,4);
        MergeKSortedList.ListNode of7 = create(7,14,21);
        MergeKSortedList.ListNode[] lists = new MergeKSortedList.ListNode[]{of3, of2, of7};

        MergeKSortedList mergeKSortedList = new MergeKSortedList();
        MergeKSortedList.ListNode merged = mergeKSortedList.mergeKLists(lists);
        System.out.println(toString(merged));

    }



    private MergeKSortedList.ListNode create(int ... input) {
        MergeKSortedList.ListNode head = new MergeKSortedList.ListNode(input[0]);
        MergeKSortedList.ListNode curr = head;

        for(int i = 1; i < input.length; i++) {
            curr.next = new MergeKSortedList.ListNode(input[i]);
            curr = curr.next;
        }

        return head;
    }

    private String toString(MergeKSortedList.ListNode listNode) {
        MergeKSortedList.ListNode curr = listNode;
        StringBuffer buffer = new StringBuffer("[");
        while(curr != null) {
            buffer.append(curr.val);
            buffer.append("->");
            curr = curr.next;
        }
        buffer.append("]");
        return buffer.toString();
    }

    public static void main(String[] args) {
        MergeKSortedListTest testClass = new MergeKSortedListTest();
        MergeKSortedList.ListNode head = testClass.create(1,2,3,4);
        System.out.println(testClass.toString(head));
        head = testClass.create(3,5,1);
        System.out.println(testClass.toString(head));
    }

}