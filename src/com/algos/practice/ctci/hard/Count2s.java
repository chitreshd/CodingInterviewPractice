package com.algos.practice.ctci.hard;

/**
 * Created by cdeshpande on 6/25/17.
 */
public class Count2s {

    // Bugs
    public int count2(int n) {

        if(n < 2) {
            return 0;
        }

        int residue = n;
        int count = 0;
        for(int i = 0; residue > 0; i++) {
            double powOf10 = Math.pow(10,i);
            double nextPowOf10 = powOf10 * 10;
            int leftPart = (int) ( n / nextPowOf10);

            int rightPart = (int) (n % powOf10);

            int d = residue % 10;
            if(i == 0) {
                rightPart = 1;
            }
            if(d < 2) {
                count += (leftPart) * powOf10;
            } else if(d > 2) {
                count += (leftPart + 1) * powOf10;
            } else {
                // d == 2
                if( leftPart == 0) {
                    // processing last digit, example: 2 in 20, 2 in 210 etc.
                    count += rightPart + 1;
                } else {
                    count += (leftPart * powOf10) + rightPart;
                }

            }

            residue = residue / 10;

        }
        return count;

    }

    // Ref: https://github.com/careercup/CtCI-6th-Edition/blob/master/Java/Ch%2017.%20Hard/Q17_06_Count_of_2s/Question.java
    public static int count2sInRangeAtDigit(int number, int d) {
        int powerOf10 = (int) Math.pow(10, d);
        int nextPowerOf10 = powerOf10 * 10;
        int right = number % powerOf10;

        int roundDown = number - number % nextPowerOf10;
        int roundUp = roundDown + nextPowerOf10;

        int digit = (number / powerOf10) % 10;
        if (digit < 2) { // if the digit in spot digit is
            return roundDown / 10;
        } else if (digit == 2) {
            return roundDown / 10 + right + 1;
        } else {
            return roundUp / 10;
        }
    }

    public static int count2sInRange(int number) {
        int count = 0;
        int len = String.valueOf(number).length();
        for (int digit = 0; digit < len; digit++) {
            count += count2sInRangeAtDigit(number, digit);
        }
        return count;
    }


}
