package com.algos.practice.leetcode.hard;

/**
 * Created by cdeshpande on 12/6/16.
 */
public class WildCardMatcher {

    private static class StateNode {
        char value;
        StateNode next;
        boolean isTerminal;

        StateNode(char value, StateNode next, boolean isTerminal) {
            this.value = value;
            this.next = next;
            this.isTerminal = isTerminal;
        }

        private StateNode getNext(char nextValue) {
            if(isStar()) {

                if(this.next != null && this.next.value == nextValue) {
                    return this.next;
                }

                return this;
            }
            return this.next;
        }

        private boolean matches(char c) {
            return isStar() || isQuestion() || c == this.value;
        }

        private boolean isStar() {
            return this.value == '*';
        }

        private boolean isQuestion() {
            return this.value == '?';
        }
    }

    public boolean isMatch(String s, String p) {

        StateNode root = construct(p);
        char [] input = s.toCharArray();
        StateNode curr = root;

        for(char c : input) {
            curr = curr.getNext(c);

            if(curr == null || !curr.matches(c)) {
                return false;
            }

        }

        return curr.isTerminal;

    }

    private StateNode construct(String pattern) {
        char [] ptrn = pattern.toCharArray();
        StateNode root = new StateNode('r', null, false);
        StateNode prev = root;

        for(char p : ptrn) {
            StateNode sn = new StateNode(p, null, false);
            prev.next = sn;
            prev = sn;
        }

        prev.isTerminal = true;
        return root;
    }

    public boolean isMatch_usingPointers(String input, String pattern) {
        // Ref: https://discuss.leetcode.com/topic/3040/linear-runtime-and-constant-space-solution/2

        int inputPtr = 0;
        int ptrnPtr = 0;
        int starStart = -1;

        while(inputPtr < input.length()) {

            // simple case of regular char match

            if(ptrnPtr < pattern.length()
                    && (pattern.charAt(ptrnPtr) == '?' || input.charAt(inputPtr) == pattern.charAt(ptrnPtr)) ) {
                // increment input and pattern pointers
                inputPtr++;
                ptrnPtr++;
            } else if (ptrnPtr < pattern.length() && pattern.charAt(ptrnPtr) == '*') {
                starStart = ptrnPtr;
                ptrnPtr++;
            } else if(starStart != -1) {
                // in * mode, increment both starStart and inputPtr
                ptrnPtr = starStart + 1;
                inputPtr++;
            } else {
                return false;
            }
        }

        while(ptrnPtr < pattern.length() && pattern.charAt(ptrnPtr) == '*') {
            ptrnPtr++;
        }

        return ptrnPtr == pattern.length();

    }
    public static boolean doExecute(String s, String p, WildCardMatcher matcher) {
        boolean result = matcher.isMatch_usingPointers(s,p);
        System.out.println(String.format("input: %s, pattern: %s, isMatch: %s", s, p, result));
        return result;
    }
    public static void main(String[] args) {
        WildCardMatcher matcher = new WildCardMatcher();
        doExecute("aa","a", matcher); // false
        doExecute("aa","aa", matcher); //true
        doExecute("aaa","aa", matcher); //false
        doExecute("aa", "*", matcher); //true
        doExecute("aa", "a*", matcher); //true
        doExecute("ab", "?*", matcher); //true
        doExecute("aab", "c*a*b", matcher); //false
        doExecute("abefcdgiescdfimde", "ab*cd?i*de", matcher); // true;
    }
}
