package com.algos.practice.leetcode.medium;

import java.util.Stack;

/**
 * Created by cdeshpande on 7/25/17.
 */

public class ReversePolishNotation {

    public int evalRPN(String[] tokens) {
        Stack<Integer> operands = new Stack<>();
        for(String token : tokens) {
            Integer operand = getDigit(token);
            if(operand != null) {
                operands.push(operand);
            } else {
                // found operator
                int operand2 = operands.pop();
                int operand1 = operands.pop();
                int result = eval(operand1, operand2, token);
                operands.push(result);
            }
        }

        return operands.pop();
    }

    private int eval(int operand1, int operand2, String token) {
        if(token == "+") {
            return operand1 + operand2;
        } else if(token == "*") {
            return operand1 * operand2;
        } else if(token == "-") {
            return operand1 - operand2;
        } else {
            return operand1 / operand2;
        }
    }

    private Integer getDigit(String token) {
        try {
            int digit = Integer.valueOf(token);
            return digit;
        } catch (Exception e) {

        }

        return null;
    }

}
