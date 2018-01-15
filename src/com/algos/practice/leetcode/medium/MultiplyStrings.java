package com.algos.practice.leetcode.medium;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MultiplyStrings {

    public String multiply(String num1, String num2) {
        return doMultiplyUsingIndexPositions(num1, num2);
    }



    private String doMultiplyUsingIndexPositions(String num1, String num2) {


        char [] num1chars = lsbFirst(num1);
        char [] num2chars = lsbFirst(num2);
        int [] ans = new int[num1chars.length + num2chars.length];

        for(int i = 0; i < num1chars.length; i++) {

            for(int j = 0; j < num2chars.length; j++) {
                int startPosn = i + j;
                int pairProduct = toInt(num1chars[i]) * toInt(num2chars[j]);
                int base = pairProduct % 10;
                int carry = pairProduct / 10;
                int startPosnDigit = ans[startPosn] + base;
                ans[startPosn] = startPosnDigit % 10;
                int carryPosnDigit = ans[startPosn + 1] + carry + (startPosnDigit / 10);
                ans[startPosn + 1] = carryPosnDigit % 10;
                if(carryPosnDigit / 10 > 0) {
                    ans[startPosn + 2] = ans[startPosn + 2] + carryPosnDigit / 10;
                }



            }
        }

        StringBuffer ansbuffer = new StringBuffer();
        for(int i : ans) {
            ansbuffer.append(i);
        }
        ansbuffer = ansbuffer.reverse();
        int startIndex = 0;
        while(startIndex < ansbuffer.length()) {
            if(ansbuffer.charAt(startIndex) != '0') {
                break;
            }
            startIndex++;
        }

        return startIndex == ansbuffer.length() ? "0" : ansbuffer.substring(startIndex);

    }

    private char[] lsbFirst(String num1) {
        return new StringBuffer(num1).reverse().toString().toCharArray();
    }

    private String doMultiplyUsingBigInteger(String num1, String num2) {

        int tenPower = 0;
        //BigInteger product = new BigInteger();
        long prod = 0;
        for(int i = num2.length() - 1; i >= 0 ; i--) {
            int n2Digit = toInt(num2.charAt(i));
            int subProd = 0;
            int carry = 0;

            for(int j = num1.length() - 1; j >= 0; j--) {
                int n1Digit = toInt(num1.charAt(j));
                int digitProd = (n1Digit * n2Digit) + carry;
                subProd += (digitProd);
                carry = digitProd / 10;
            }

            prod += subProd * Math.pow(10,tenPower++);

        }
        return Long.toString(prod);
    }

    private int toInt(char c) {
        return Character.getNumericValue(c);
    }
}
