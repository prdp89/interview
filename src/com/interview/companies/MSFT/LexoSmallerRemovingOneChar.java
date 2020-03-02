package com.interview.companies.MSFT;

import java.util.Stack;

public class LexoSmallerRemovingOneChar {

    //https://leetcode.com/discuss/interview-question/366869/
    public static void main( String[] args ) {
        String s1 = "abczd";

        System.out.println("Method 2 : " + getSmallString(s1));
        System.out.println("Method 2 : " + getSmallStringEasy(s1));
    }

    //Method 1 - Using Stack
    private static String getSmallString( String str ) {

        Stack<Character> stack = new Stack<>();
        int count = 0;

        for (int i = 0; i < str.length(); i++) {

            //comparing str.char(i) > str.charAt(i+1)
            if (!stack.isEmpty() && stack.peek() > str.charAt(i) && count < 1) {
                count++;
                stack.pop();
            }

            stack.push(str.charAt(i));
        }

        StringBuilder sb = new StringBuilder();

        if (count == 0 && stack.size() > 0)
            stack.pop();

        while (!stack.empty()) {
            sb.insert(0, stack.pop());
        }

        return sb.toString();
    }

    //Method 2 - Easy way :)
    private static String getSmallStringEasy( String str ) {
        StringBuilder sb = new StringBuilder(str);

        int i = 1;
        for (; i < str.length(); i++) {

            if (sb.charAt(i - 1) > sb.charAt(i))
                break;
        }

        return sb.deleteCharAt(i).toString();
    }
}
