package com.interview.leetcode.thirtydayschallenge;

import java.util.Stack;

public class BackSpaceStringCompare {

    //https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/529/week-2/3291/
    public static void main( String[] args ) {
        String S = "a##c", T = "#a#c";

        System.out.println(backspaceCompare(S, T));

        System.out.println("Optimal sol: " + buildOPtimal(S).equals(buildOPtimal(T)));
    }

    private static boolean backspaceCompare( String S, String T ) {

        StringBuilder sb = new StringBuilder(S);
        StringBuilder sb1 = new StringBuilder(T);

        return replaceHash(sb).equals(replaceHash(sb1));
    }

    private static String replaceHash( StringBuilder sb ) {
        int length = sb.length();

        for (int i = 1; i < length; i++) {
            if (sb.charAt(i) == '#' && i > 0) {
                sb.delete(i - 1, i + 1);
                length -= 2;
                i -= 2;
            }
        }

        return sb.toString().replaceAll("#", "");
    }

    //TIME : O(M + N)
    private static String buildOPtimal( String S ) {
        Stack<Character> ans = new Stack();

        for (char c : S.toCharArray()) {
            if (c != '#')
                ans.push(c);
            else if (!ans.empty())
                ans.pop();
        }

        return String.valueOf(ans);
    }
}
