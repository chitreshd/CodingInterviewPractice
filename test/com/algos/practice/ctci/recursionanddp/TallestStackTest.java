package com.algos.practice.ctci.recursionanddp;

import org.junit.Test;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.Arrays;

import static com.algos.practice.ctci.recursionanddp.TallestStack.*;
import static org.junit.Assert.*;

/**
 * Created by cdeshpande on 7/30/17.
 */
public class TallestStackTest {
    private TallestStack tallestStack = new TallestStack();

    @Test
    public void createStack() throws Exception {
        // b3, b2, b1 , b4, b1
        Box b1 = new Box(1,1,1);
        Box b2 = new Box(2,2,2);
        Box b3 = new Box(3,3,3);
        Box b4 = new Box(4,4,2);

        System.out.println(tallestStack.createStack(Arrays.asList(b1, b2, b3, b4)));


    }



}