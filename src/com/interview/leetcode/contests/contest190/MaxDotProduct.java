package com.interview.leetcode.contests.contest190;

public class MaxDotProduct {

    //https://leetcode.com/contest/weekly-contest-190/problems/max-dot-product-of-two-subsequences/
    public static void main( String[] args ) {
        int[] num1 = {2, 1, -2, 5};
        int[] num2 = {3, 0, -6};

        System.out.println(maxDotProduct(num1, num2));
    }

    //based on Inclusion-Exclusion principle
    //similar to LCS
    private static int maxDotProduct( int[] nums1, int[] nums2 ) {
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];


        for (int i = 0; i < dp.length; i++)
            dp[i][0] = -2000;

        for (int j = 0; j < dp[0].length; j++)
            dp[0][j] = -2000;


        for (int i = 1; i <= nums1.length; i++) {

            for (int j = 1; j <= nums2.length; j++) {
                int byExcluding = Math.max(dp[i - 1][j], dp[i][j - 1]);

                int curValue = nums1[i - 1] * nums2[j - 1];
                //see LCS: why we used dp[i - 1][j - 1]
                int byIncluding = Math.max(curValue, curValue + dp[i - 1][j - 1]);

                dp[i][j] = Math.max(byExcluding, byIncluding);
            }
        }

        return dp[nums1.length][nums2.length];
    }
}
