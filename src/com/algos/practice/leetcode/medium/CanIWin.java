package com.algos.practice.leetcode.medium;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * Created by cdeshpande on 7/15/17.
 */
public class CanIWin {

    private boolean[] usedBools;
    private int usedBits = 0;

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        /*LinkedHashSet<Integer> remaining = new LinkedHashSet<>();

        for(int i = 1; i <= maxChoosableInteger;i++) {
            remaining.add(i);
        }

        //return canIWin(remaining, 0, desiredTotal, 2);
        return canIWinIterative(remaining, desiredTotal);*/
        usedBools = new boolean[maxChoosableInteger + 1];
        usedBits = 0;
        /*Map<String, Integer> results = new HashMap<>();
        int winningPlayer = canIWinMemoization(desiredTotal, 2, maxChoosableInteger, results);
        return winningPlayer == 1;*/

        Map<Integer, Boolean> results = new HashMap<>();
        return canIWinMemoizationV2(desiredTotal, results);
    }

    private int canIWinMemoization(int desiredTotal,
                                   int lastPlayer,
                                   int maxAllowedInteger,
                                   Map<String, Integer> results) {
        String key = key(desiredTotal, lastPlayer);
        if(results.containsKey(key)) {
            return results.get(key);
        }

        if(desiredTotal <= 0)
            return lastPlayer;

        int winningPlayer = lastPlayer;
        for(int i = 1; i <= maxAllowedInteger; i++) {
            if(!usedBools[i]) {
                usedBools[i] = true;
                setBit(i);
                int currPlayer = (lastPlayer == 1 ? 2 : 1);
                winningPlayer = canIWinMemoization(desiredTotal - i, currPlayer, maxAllowedInteger, results);
                usedBools[i] = false;
                clearBit(i);
                if(winningPlayer == currPlayer) {
                    break;
                }
            }

        }
        results.put(key, winningPlayer);
        return winningPlayer;
    }

    private boolean canIWinMemoizationV2(int desiredTotal,
                                   Map<Integer, Boolean> results) {
        //int key = getKey();
        if(results.containsKey(usedBits)) {
            return results.get(usedBits);
        }

        if(desiredTotal <= 0)
            return false;

        for(int i = 1; i < usedBools.length; i++) {
            if(!usedBools[i]) {
                usedBools[i] = true;
                setBit(i);
                if(!canIWinMemoizationV2(desiredTotal - i, results)) {
                    usedBools[i] = false;
                    clearBit(i);
                    results.put(usedBits, true);
                    return true;
                }

                usedBools[i] = false;
                clearBit(i);
            }

        }
        results.put(usedBits, false);
        return false;
    }

    private int getKey() {
        int key = 0;
        for(int i = 0; i < usedBools.length; i++) {

        }
        return 0;
    }

    private void setBit(int i) {
        usedBits |= ( 1 << i );
    }

    private void clearBit(int i) {
        usedBits &= ~( 1 << i );
    }

    private String key(int desiredTotal, int lastPlayer) {
        return String.format("%s_%s_%s",desiredTotal,lastPlayer,usedBits);
    }

    private boolean canIWinIterative(LinkedHashSet<Integer> remaining, int desiredTotal) {
        int runningTotal = 0;
        int currPlayer = 1;

        while(runningTotal < desiredTotal) {
            int optimalChoice = optimalPlay(remaining, runningTotal, desiredTotal);
            runningTotal += optimalChoice;
            currPlayer = (currPlayer == 1 ? 2 : 1);
        }

        return currPlayer == 2;
    }

    private boolean canIWin(LinkedHashSet<Integer> remaining, int runningTotal, int desiredTotal, int lastPlayer) {
        if(runningTotal >= desiredTotal)
            return lastPlayer == 1;

        int optimalChoice = optimalPlay(remaining, runningTotal, desiredTotal);
        remaining.remove(optimalChoice);
        int currPlayer = 2;

        if(lastPlayer == 2) {
            currPlayer = 1;
        }

        return canIWin(remaining, runningTotal + optimalChoice, desiredTotal, currPlayer);


    }

    private int optimalPlay(LinkedHashSet<Integer> remaining, int runningTotal, int desiredTotal) {
        int delta = desiredTotal - runningTotal;
        if(remaining.contains(delta)) {
            return delta;
        }

        for(int i : remaining) {
            return i;
        }

        return 0;
    }

    //
    Map<Integer, Boolean> map;
    boolean[] used;
    public boolean canIWinFromDiscuss(int maxChoosableInteger, int desiredTotal) {
        int sum = (1+maxChoosableInteger)*maxChoosableInteger/2;
        if(sum < desiredTotal) return false;
        if(desiredTotal <= 0) return true;

        map = new HashMap();
        used = new boolean[maxChoosableInteger+1];
        boolean result = helper(desiredTotal);
        return result;
    }

    public boolean helper(int desiredTotal){
        if(desiredTotal <= 0) return false;
        int key = format(used);
        if(!map.containsKey(key)){
            // try every unchosen number as next step
            for(int i=1; i<used.length; i++){
                if(!used[i]){
                    used[i] = true;
                    // check whether this lead to a win (i.e. the other player lose)
                    if(!helper(desiredTotal-i)){
                        map.put(key, true);
                        used[i] = false;
                        return true;
                    }
                    used[i] = false;
                }
            }
            map.put(key, false);
        }
        return map.get(key);
    }

    // transfer boolean[] to an Integer
    public int format(boolean[] used){
        int num = 0;
        for(boolean b: used){
            num <<= 1;
            if(b) num |= 1;
        }
        return num;
    }

    public static void main(String[] args) {
        CanIWin solve = new CanIWin();
        System.out.println(solve.canIWin(10,11));
    }
}
