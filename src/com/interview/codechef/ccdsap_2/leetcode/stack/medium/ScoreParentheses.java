package com.interview.codechef.ccdsap_2.leetcode.stack.medium;

import java.util.Stack;

public class ScoreParentheses {

    //very easy problem
    //https://leetcode.com/problems/score-of-parentheses/
    public static void main( String[] args ) {
        //String str = "(()))";
        String str = "(()(()))";

        //  System.out.println(solveTry(str));

        System.out.println(solveOptimal(str));
    }

    private static int solveTry( String str ) {
        int open = 0, close = 0;

        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) == '(')
                open++;
            else
                close++;
        }

        return (open + close) / 2;
    }

    private static int solveOptimal( String str ) {

        Stack<Integer> stack = new Stack<>();
        int cur = 0;

        for (char c : str.toCharArray()) {

            if (c == '(') {
                stack.push(cur);
                cur = 0;
            } else {
                cur = stack.pop() + Math.max(cur * 2, 1);
            }
        }
        return cur;
    }
}