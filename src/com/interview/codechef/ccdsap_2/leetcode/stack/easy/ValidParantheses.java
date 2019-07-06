package com.interview.codechef.ccdsap_2.leetcode.stack.easy;

import java.util.Stack;

public class ValidParantheses {

    //https://leetcode.com/problems/valid-parentheses
    public static void main( String[] args ) {
        String str = "()";

        //System.out.println(sovleTry(str));

        System.out.println(solveAgain(str));
    }

    //almost solved :)
    private static boolean sovleTry( String str ) {

        int openRound = 0, closeRound = 0, openSquare = 0, closeSquare = 0, openCurly = 0, closeCurly = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                openRound++;
            } else if (str.charAt(i) == ')') {
                closeRound++;
            } else if (str.charAt(i) == '[') {
                openSquare++;
            } else if (str.charAt(i) == ']') {
                closeSquare++;
            } else if (str.charAt(i) == '{') {
                openCurly++;
            } else if (str.charAt(i) == '}') {
                closeCurly++;
            }
        }

        if (openRound == closeRound && openSquare == closeSquare && openCurly == closeCurly) {
            return true;
        }

        return false;
    }

    //working correctly; all test case passed.
    private static boolean solveAgain( String str ) {

        if (str.length() == 1)
            return false;

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {

            if (!stack.isEmpty() && (str.charAt(i) == ')' || str.charAt(i) == ']' || str.charAt(i) == '}')) {
                char c = stack.pop();
                if (c == '(' && str.charAt(i) != ')')
                    return false;
                else if (c == '[' && str.charAt(i) != ']')
                    return false;
                else if (c == '{' && str.charAt(i) != '}')
                    return false;
            } else
                stack.push(str.charAt(i));
        }

        return stack.isEmpty();
    }
}
