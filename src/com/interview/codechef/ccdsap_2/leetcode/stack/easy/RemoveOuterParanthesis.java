package com.interview.codechef.ccdsap_2.leetcode.stack.easy;

import java.util.Stack;

public class RemoveOuterParanthesis {

    //https://leetcode.com/problems/remove-outermost-parentheses/
    public static void main( String[] args ) {
        String str = "(()())(())";

        //removeParanthesisTry(str);

        System.out.println(removeOuterParenthesesSolution(str));
    }

    //wrong logic, couldn't think :(
    private static String removeParanthesisTry( char[] str ) {

        Stack<Character> stack = new Stack<>();
        StringBuilder stringBuilder = new StringBuilder();

        int level = 0;
        for (Character c : str) {
            if (c == '(') {
                stack.push(c);
                level++;
            } else {
                while (level-- > 1) {
                    stringBuilder.append(stack.pop());

                    stringBuilder.append(c);
                }
                level = 1;
            }
        }

        return stringBuilder.toString();
    }

    private static String removeOuterParenthesesSolution( String S ) {

        StringBuilder sb = new StringBuilder();

        int open = 0, close = 0, start = 0;

        for (int i = 0; i < S.length(); i++) {

            if (S.charAt(i) == '(') {
                open++;
            } else if (S.charAt(i) == ')') {
                close++;
            }

            //start from Start+1 to avoid outer paranthesis, go until I (exclusive).
            if (open == close) {
                sb.append(S.substring(start + 1, i));

                //reset start to i+1
                start = i + 1;
            }
        }
        return sb.toString();
    }
}
