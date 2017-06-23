package com.algos.practice.concepts;

/**
 * Created by cdeshpande on 6/13/17.
 */
public class SegmentTreeSumOfGivenRange extends SegmentTree{


    public SegmentTreeSumOfGivenRange(int[] nums) {
        super(nums);
    }

    protected int applySegmentFunction(int leftResult, int rightResult) {
        return leftResult + rightResult;
    }

    protected int defaultValue() {
        return 0;
    }
}
