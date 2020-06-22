package com.interview.leetcode.dp.grokkingdp.stringmanipulation;

public class LongestCommonSubSeq {

    public static void main( String[] args ) {
        LongestCommonSubSeq lcs = new LongestCommonSubSeq();
        System.out.println(lcs.findLCSLength("abdca", "cbda"));

        System.out.println(lcs.findLCSLength_2D_DP("abdca", "cbda"));

        System.out.println(lcs.findLCSLength_1D_DP("abdca", "cbda"));
    }

    public int findLCSLength( String s1, String s2 ) {
        Integer[][] dp = new Integer[s1.length()][s2.length()];
        return findLCSLengthRecursive(dp, s1, s2, 0, 0);
    }

    //Runtime: 36 ms, faster than 7.89% of Java
    private int findLCSLengthRecursive( Integer[][] dp, String s1, String s2, int i1, int i2 ) {
        //if any string reach to end, we don't have anything common present
        if (i1 == s1.length() || i2 == s2.length())
            return 0;

        if (dp[i1][i2] == null) {
            if (s1.charAt(i1) == s2.charAt(i2))
                dp[i1][i2] = 1 + findLCSLengthRecursive(dp, s1, s2, i1 + 1, i2 + 1);
            else {
                int c1 = findLCSLengthRecursive(dp, s1, s2, i1, i2 + 1);
                int c2 = findLCSLengthRecursive(dp, s1, s2, i1 + 1, i2);
                dp[i1][i2] = Math.max(c1, c2);
            }
        }

        return dp[i1][i2];
    }

    private int findLCSLength_2D_DP( String s1, String s2 ) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        int maxLength = 0;

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {

                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);

                maxLength = Math.max(maxLength, dp[i][j]);
            }
        }

        return maxLength;
    }

    //oNLY PASSING 11 / 38 test cases passed.
    //SOLUTION USING 1 VARIABLE : https://leetcode.com/problems/longest-common-subsequence/discuss/398711/ALL-4-ways-Recursion-greater-Top-down-greaterBottom-Up-greater-Efficient-Solution-O(N)-including-VIDEO-TUTORIAL
    private int findLCSLength_1D_DP( String s1, String s2 ) {
        int[] dp = new int[s2.length() + 1];
        int maxLength = 0;

        for (int i = 1; i <= s1.length(); i++) {

            for (int j = s2.length(); j > 0; j--) {

                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[j] = 1 + dp[j - 1];
                else
                    dp[j] = Math.max(dp[i - 1], dp[j - 1]);

                maxLength = Math.max(maxLength, dp[j]);
            }
        }

        return maxLength;
    }

}
