package com.interview.companies.fb;

import java.util.HashSet;
import java.util.Stack;

public class MinRemoveValidParan {

    //https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
    public static void main( String[] args ) {
        String str = "lee(t(c)o)de)";

        System.out.println(minRemoveToMakeValid(str));
    }

    //similar to MinimumAddParnanValid
    //Runtime: 19 ms, faster than 51.31% of Java
    private static String minRemoveToMakeValid( String s ) {
        Stack<Integer> stack = new Stack<>();

        HashSet<Integer> removeIndices = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                stack.push(i);
            else if (s.charAt(i) == ')') {
                if (!stack.isEmpty())
                    stack.pop();
                else
                    removeIndices.add(i);
            }
        }

        //pop until brackets got balanced
        while (!stack.isEmpty()) {
            removeIndices.add(stack.pop());
        }

        //not appending the indices of brackets which are not balanced..
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!removeIndices.contains(i))
                sb.append(s.charAt(i));
        }

        return sb.toString();
    }
}
