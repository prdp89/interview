package com.interview.codechef.ccdsap_2.leetcode.stack.medium;

import java.util.Objects;
import java.util.Stack;

public class RemoveKDigits {

    //https://leetcode.com/problems/remove-k-digits
    public static void main( String[] args ) {
        String num = "112";
        int k = 1;

        //System.out.println(solveTry(num, k));

        // System.out.println(solveTrySecond(num, k));

        System.out.println(solveOptimally(num, k));
    }

    private static String solveTry( String num, int k ) {

        String min = Integer.MAX_VALUE + "";
        for (int i = 0; i < num.length() - k; i++) {

            String start = num.substring(0, i);
            String val = num.substring(i + k);

            int comp = (start + val).compareTo(min);
            if (comp < 0)
                min = start + val;
        }

        return min;
    }

    /*
    The first algorithm is straight-forward. Let's think about the simplest case:
    how to remove 1 digit from the number so that the new number is the smallest possible？

    Well, one can simply scan from left to right, and remove the first "peak" digit;
    the peak digit is larger than its right neighbor. One can repeat this procedure k times
     */

    //Time complexity : O (K * N)
    private static String solveTrySecond( String num, int k ) {

        StringBuilder sb = new StringBuilder(num);

        while (k > 0) {
            int n = sb.length();

            int i = 0;

            while (i + 1 < n && sb.charAt(i) <= sb.charAt(i + 1))
                i++;

            sb.deleteCharAt(i);
            k--;
        }

        int s = 0;
        while (s < sb.length() - 1 && sb.charAt(s) == '0')
            s++;

        String str = sb.substring(s);

        return Objects.equals(str, "") ? "0" : str;
    }

    //We are checking if current num is greater than next using Stack.
    //This prevent us to iterate from array index = 0
    //Time : O ( N )
    private static String solveOptimally( String num, int k ) {

        if (k == num.length())
            return "0";

        Stack<Integer> stack = new Stack<>();

        int shouldKeep = num.length() - k;

        for (int i = 0; i < num.length(); i++) {

            while (!stack.isEmpty() && stack.peek() > (num.charAt(i) - 48) && k > 0) {
                stack.pop();
                k--;
            }

            stack.push(num.charAt(i) - 48);
        }

        //construct the number from the stack
        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty())
            sb.append(stack.pop());

        sb.reverse();

        //For test case like num = 112, k = 1 => op:11 bcz above loop didn't delete any char from stack
        if (k > 0) {
            sb = new StringBuilder(sb.subSequence(0, shouldKeep));
        }

        //remove all the 0 at the head
        while (sb.length() > 1 && sb.charAt(0) == '0')
            sb.deleteCharAt(0);

        return sb.toString();
    }
}
