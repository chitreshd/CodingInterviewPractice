package com.algos.practice.ctci.moderate;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.algos.practice.ctci.moderate.LivingPeople.*;
import static org.junit.Assert.*;

/**
 * Created by cdeshpande on 9/30/17.
 */
public class LivingPeopleTest {

    LivingPeople solve = new LivingPeople();

    @Test
    public void calculateYearWithMaxPopulation() throws Exception {
        List<LifeSpan> list1 = generateLifeSpans("1-2","1-1","2-3");
        assertEquals(1,solve.calculateYearWithMaxPopulation(list1));
        List<LifeSpan> list2 = generateLifeSpans("5-15","10-20","4-25","27-50");
        assertEquals(10,solve.calculateYearWithMaxPopulation(list2));
        list2.addAll(list1);
        assertEquals(10,solve.calculateYearWithMaxPopulation(list2));
    }

    private List<LifeSpan> generateLifeSpans(String ... ranges) {
        List<LifeSpan> spans = new ArrayList<>();

        for(String range : ranges) {
            String [] splits = range.split("-");
            int birth = Integer.parseInt(splits[0]);
            int death = Integer.parseInt(splits[1]);
            spans.add(new LifeSpan(birth, death));
        }

        return spans;
    }

}