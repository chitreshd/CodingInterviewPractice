package com.algos.practice.concepts;

/**
 * Created by cdeshpande on 5/16/17.
 * Refs: https://www.topcoder.com/community/data-science/data-science-tutorials/binary-indexed-trees/#read
 *
 */
public class BinaryIndexedTree {

    int [] tree;
    int size;

    public BinaryIndexedTree(int size){
        this.tree = new int[size + 1];
        this.size = size + 1;
    }

    public int lookup(int index){
        int sum = 0;
        int lastDigit;

        while(index > 0) {
            sum += tree[index];
            lastDigit = (-index & index);
            index = index - lastDigit;
        }

        return sum;
    }

    public void update(int index, int value){
        int lastDigit;

        while(index < size) {
            tree[index] += value;
            lastDigit = (-index & index);
            index = index + lastDigit;
        }

    }


}
