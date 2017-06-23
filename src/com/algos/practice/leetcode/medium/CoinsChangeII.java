package com.algos.practice.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cdeshpande on 6/22/17.
 */
public class CoinsChangeII {

    int hits = 0;

    public int change(int amount, int[] coins) {
        if(amount == 0)
            return 1;

        return getChangeUsingDP(amount, coins);
    }

    private int changeUsingRecursion(int amount, int[] coins) {
        if(amount == 0)
            return 1;

        Map<String, Integer> partialResults = new HashMap<>();
        return getChangeCombs(amount, coins, 0, partialResults);
    }

    private int getChangeCombs(int amount, int [] coins, int idx, Map<String, Integer> partialResults) {
        if(amount == 0)
            return 1;

        if(idx == coins.length) {
            return 0;
        }

        String key = getKey(amount, idx);
        if(partialResults.containsKey(key)) {
            hits++;
            System.out.println("hits: " + hits);
            return partialResults.get(key);
        }

        int sum = 0;
        int denom = coins[idx];
        for(int i = 0; (denom * i) <= amount; i++) {
            sum += getChangeCombs(amount - (denom * i), coins, idx + 1, partialResults);
        }
        partialResults.put(key, sum);
        return sum;
    }

    private String getKey(int amount, int idx) {
        return String.format("%s_%s", amount, idx);
    }

    private int getChangeUsingDP(int amount, int [] coins) {
        int [][] dp = new int[coins.length + 1][amount + 1];
        dp[0][0] = 1;
        for(int i = 1; i <= coins.length; i++) {
            dp[i][0] = 1;

            for(int j = 1; j <= amount; j++) {

                dp[i][j] = dp[i - 1][j] + (j >= coins[i - 1] ? dp[i][j - coins[i - 1]] : 0);
            }
        }
        return dp[coins.length][amount];
    }

}
