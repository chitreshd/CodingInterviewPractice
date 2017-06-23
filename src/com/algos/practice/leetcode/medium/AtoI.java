package com.algos.practice.leetcode.medium;

import java.util.HashMap;

/**
 * Created by cdeshpande on 6/5/17.
 * Problem:
 * Implement atoi to convert a string to an integer.
 *
 * Input Cases:
 * 1. Valid: anything from Int.max to Int.min
 * 2. Check for whitespaces in between: Should it be returned as error? Eg: "2 7", asmp: yes
 * 3. Check for non-int chars: Should it be returned as error? Eg: "2&7", asump: yes
 * 4. Check for trailing or leading whitespace chars: Should it be returned as error? Eg: "27  ", asump: no
 * 5. Do i need to support all base representations?: Ex: hex, octal?, asmp: no
 */
public class AtoI {

    private static HashMap<Character, Integer> cToI = new HashMap<>();
    static {
        cToI.put('0',0);
        cToI.put('1',1);
        cToI.put('2',2);
        cToI.put('3',3);
        cToI.put('4',4);
        cToI.put('5',5);
        cToI.put('6',6);
        cToI.put('7',7);
        cToI.put('8',8);
        cToI.put('9',9);
    }

    public int myAtoi(String str) {
        if(str == null || str.isEmpty())
            return 0;

        char [] chars = str.trim().toCharArray();
        int sum = 0;
        int i = 0;
        int sign = 1;

        if(isSignChar(chars[i])) {
            if(isNeg(chars[i])) {
                sign = -1;
            }
            i++;
        }

        while(i < chars.length) {
            Integer digit = cToI.get(chars[i]);
            if(digit == null) {
                // error condition
                break;
            }

            if(goingOutOfBound(sum, digit)) {
                sum = (sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE);
                return sum;
            }

            sum *= 10;
            sum += digit;
            i++;
        }

        return sum * sign;
    }


    private boolean goingOutOfBound(int sum, int digit) {
        if( Integer.MAX_VALUE/10 < sum
            || Integer.MAX_VALUE/10 == sum && Integer.MAX_VALUE %10 < digit)
            return true;
        else
            return false;
    }

    private boolean isNeg(char aChar) {
        return aChar == '-';
    }

    private boolean isSignChar(char aChar) {
        return aChar == '+' || aChar == '-';
    }

    /*public static int myAtoiAns(String str) {
        int index = 0, sign = 1, total = 0;
        //1. Empty string
        if(str.length() == 0) return 0;

        //2. Remove Spaces
        while(str.charAt(index) == ' ' && index < str.length())
            index ++;

        //3. Handle signs
        if(str.charAt(index) == '+' || str.charAt(index) == '-'){
            sign = str.charAt(index) == '+' ? 1 : -1;
            index ++;
        }

        //4. Convert number and avoid overflow
        while(index < str.length()){
            int digit = str.charAt(index) - '0';
            if(digit < 0 || digit > 9) break;

            //check if total will be overflow after 10 times and add digit
            if(Integer.MAX_VALUE/10 < total || Integer.MAX_VALUE/10 == total && Integer.MAX_VALUE %10 < digit)
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

            total = 10 * total + digit;
            index ++;
        }
        return total * sign;
    }

    public static void main(String[] args) {
        System.out.println(myAtoiAns("  +b12102370352"));
    }*/
}
