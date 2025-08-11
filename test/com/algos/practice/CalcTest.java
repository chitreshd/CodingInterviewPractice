package com.algos.practice;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by cdeshpande on 8/10/17.
 */
public class CalcTest {
    private StripeInterview solve = new StripeInterview();


    @Test
    public void test() {
        assertEquals(solve.nextServerNumber(new int[]{5, 3, 1}), 2);
            assertEquals(solve.nextServerNumber(new int[] {5, 4, 1, 2}),3);
            assertEquals(solve.nextServerNumber(new int[] {3, 2, 1}), 4);
            assertEquals(solve.nextServerNumber(new int[] {2, 3}), 1);
            assertEquals(solve.nextServerNumber(new int[] {}), 1);

    }

    @Test
    public void testAllocateAndDeallocate() {
        assertEquals("apibox1",solve.allocate("apibox"));
        assertEquals("apibox2",solve.allocate("apibox"));
        solve.deallocate("apibox1");
        assertEquals("apibox1",solve.allocate("apibox"));
    }


    @Test
    public void testParse() {
        Pair<Integer, String> number = solve.parseNumberAndHT("apibox1");
        assertNotNull(number);
    }
}
