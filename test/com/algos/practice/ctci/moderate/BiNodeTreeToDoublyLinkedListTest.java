package com.algos.practice.ctci.moderate;

import com.algos.practice.ctci.moderate.BiNodeTreeToDoublyLinkedList;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.algos.practice.ctci.moderate.BiNodeTreeToDoublyLinkedList.*;

/**
 * Created by cdeshpande on 6/23/17.
 */
public class BiNodeTreeToDoublyLinkedListTest {

    @Test
    public void convert() throws Exception {
        BiNodeTreeToDoublyLinkedList solve = new BiNodeTreeToDoublyLinkedList();
        BiNode root = createBiNodeTree();
        System.out.println(root);
        System.out.println(root.node1);
        System.out.println(root.node2);
        solve.convert(root);
        System.out.println(root);
        BiNode node = root;
        List<Integer> left = new ArrayList<>();
        while(node != null) {
            left.add(node.data);
            node = node.node1;
        }
        Collections.reverse(left);
        node = root.node2;
        while(node != null) {
            left.add(node.data);
            node = node.node2;
        }
        System.out.println(left);
    }

    private BiNode createBiNodeTree() {
        BiNode _15 = new BiNode(15);
        BiNode _10 = new BiNode(10);
        BiNode _20 = new BiNode(20);
        BiNode _5 = new BiNode(5);
        BiNode _12 = new BiNode(12);
        BiNode _17 = new BiNode(17);
        BiNode _21 = new BiNode(21);

        _15.node1 = _10; _15.node2 = _20;
        _10.node1 = _5; _10.node2 = _12;
        _20.node1 = _17; _20.node2 = _21;

        return _15;
    }

}