package com.interview.codechef.ccdsap_2.leetcode.stack.medium;

import java.util.Stack;

public class MinimumAddParnanValid {

    //https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/
    public static void main( String[] args ) {
        String str = "()";

        System.out.println(solveTry(str));
    }

    //solved; all test cases
    private static int solveTry( String str ) {

        if (str.isEmpty())
            return 0;

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {

            if (!stack.isEmpty() && str.charAt(i) == ')') {
                if (stack.peek() == '(')
                    stack.pop();
                else
                    stack.push(str.charAt(i));
            } else {
                stack.push(str.charAt(i));
            }
        }

        return stack.size();
    }
}
