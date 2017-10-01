package com.algos.practice.ctci.moderate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by cdeshpande on 9/30/17.
 *
 * Problem:
 * Given a list of people with their birth and death years, implement a method to compute the year with the most number
 * of people alive.You may assume that all people were born between 1900 and 2000 (inclusive). If a person was alive
 * during any portion of that year, they should be included in that year's count. For example, Person (birth = 1908,
 * death = 1909) is included in the counts for both 1908 and 1909
 *
 */
public class LivingPeople {

    public int calculateYearWithMaxPopulation(List<LifeSpan> spans) {
        if(spans == null || spans.isEmpty())
            return 0;

        List<Integer> sortedBirths = getSortedBirths(spans);
        List<Integer> sortedDeaths = getSortedDeaths(spans);

        int birthIndex = 0;
        int deathIndex = 0;
        int currAlive = 0;
        int maxAlive = 0;
        int maxAliveYear = 0;

        while(birthIndex < sortedBirths.size()) {
            int birthYear = sortedBirths.get(birthIndex);
            int deathYear = sortedDeaths.get(deathIndex);

            if(birthYear <= deathYear) {
                currAlive++;
                if(currAlive > maxAlive) {
                    maxAlive = currAlive;
                    maxAliveYear = birthYear;
                }
                birthIndex++;
            } else /*if(birthYear > deathYear)*/{
                // death year is greater than current birth year, so a death was noted
                currAlive--;
                deathIndex++;
            }
        }
        System.out.println("Max Population: " + maxAlive);
        return maxAliveYear;
    }

    private static class BirthComparator implements Comparator<LifeSpan> {

        @Override
        public int compare(LifeSpan o1, LifeSpan o2) {
            return Integer.compare(o1.birth, o2.birth);
        }
    }

    private static class DeathComparator implements Comparator<LifeSpan> {

        @Override
        public int compare(LifeSpan o1, LifeSpan o2) {
            return Integer.compare(o1.death, o2.death);
        }
    }

    private List<Integer> getSortedDeaths(List<LifeSpan> spans) {
        Collections.sort(spans, new DeathComparator());
        List<Integer> sortedDeathYears = new ArrayList<>();

        for(LifeSpan span : spans) {
            sortedDeathYears.add(span.death);
        }

        return sortedDeathYears;
    }

    private List<Integer> getSortedBirths(List<LifeSpan> spans) {
        Collections.sort(spans, new BirthComparator());
        List<Integer> sortedBirthYears = new ArrayList<>();

        for(LifeSpan span : spans) {
            sortedBirthYears.add(span.birth);
        }

        return sortedBirthYears;
    }

    public static class LifeSpan {
        int birth;
        int death;

        public LifeSpan(int birth, int death) {
            this.birth = birth;
            this.death = death;
        }

        @Override
        public String toString() {
            return "LifeSpan{" +
                    "birth=" + birth +
                    ", death=" + death +
                    '}';
        }
    }


}
