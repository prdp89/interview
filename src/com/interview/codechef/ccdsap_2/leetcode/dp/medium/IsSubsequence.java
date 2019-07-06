package com.interview.codechef.ccdsap_2.leetcode.dp.medium;

import java.util.Arrays;

//https://leetcode.com/problems/is-subsequence/
public class IsSubsequence {

    public static void main( String[] args ) {
        String s = "abc", t = "ahbgdc";

        int dp[][] = new int[s.length() + 1][t.length() + 1];

        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        System.out.println(recurse(s, t, 0, 0, dp));
    }

    //adding DP will cause toll more memory.
    private static boolean recurse( String s, String t, int i, int j, int[][] dp ) {

        if (i >= s.length())
            return true;

        if (j >= t.length())
            return false;

        if (dp[i][j] != -1)
            return dp[i][j] == 1;

        if (s.charAt(i) == t.charAt(j)) {
            boolean res = recurse(s, t, i + 1, j + 1, dp);

            if (res)
                dp[i][j] = 1;
            else
                dp[i][j] = 0;

            return res;
        }


        boolean res1 = recurse(s, t, i, j + 1, dp);
        if (res1)
            dp[i][j] = 1;
        else
            dp[i][j] = 0;

        return res1;
    }
}
