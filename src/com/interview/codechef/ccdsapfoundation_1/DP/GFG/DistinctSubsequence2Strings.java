package com.interview.codechef.ccdsapfoundation_1.DP.GFG;

import java.util.Arrays;

public class DistinctSubsequence2Strings {

    //https://leetcode.com/problems/distinct-subsequences/
    static int[][] dp = null;

    public static void main( String[] args ) {
       // System.out.println(numDistinct("babgbag", "bag")); //op: 5
        System.out.println(numDistinct("rabbbit", "rabbit")); //op: 5
    }

    private static int numDistinct( String s, String t ) {
        dp = new int[s.length() + 1][t.length() + 1];
        for (int[] arr : dp) Arrays.fill(arr, -1);
        return helper(s, t, 0, 0);
    }

    //Almost same as LCS
    private static int helper( String s, String t, int i, int j ) {
        if (j >= t.length()) return 1; //if second string reaches length then atleast one match

        if (i >= s.length()) return 0; //first string is greater if this reaches length then no matches

        if (dp[i][j] != -1) return dp[i][j];

        int sol = helper(s, t, i + 1, j); //try searching/including next char of first string

        if (s.charAt(i) == t.charAt(j))
            sol += helper(s, t, i + 1, j + 1); //if char matches then increment index and look for next pattern

        dp[i][j] = sol;

        return sol;
    }
}