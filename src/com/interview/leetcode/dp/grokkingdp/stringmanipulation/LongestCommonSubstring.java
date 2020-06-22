package com.interview.leetcode.dp.grokkingdp.stringmanipulation;

public class LongestCommonSubstring {

    //https://leetcode.com/problems/maximum-length-of-repeated-subarray/

    /*
    Input: s1 = "abdca"
           s2 = "cbda"
    Output: 2
    Explanation: The longest common substring is "bd".
     */
    public static void main( String[] args ) {
        LongestCommonSubstring lcs = new LongestCommonSubstring();
        System.out.println(lcs.findLCSLength("abdca", "cbda"));

        System.out.println(lcs.findLCSLength_2D_DP("abdca", "cbda"));

        System.out.println(lcs.findLCSLength_2D_Memory_Optimized("abdca", "cbda"));

        System.out.println(lcs.findLCSLength_1D_DP("abdca", "cbda"));
    }


    //region TOP DOWN DP
    //Runtime: 352 ms, faster than 9.13% of Java
    private int findLCSLength( String A, String B ) {
        int[] max = new int[1];

        memo(A.length() - 1, B.length() - 1, A, B, new Integer[A.length()][B.length()], max);

        return max[0];
    }

    //This logic is almost same as LCS
    //Reccurrence : T(i, j) = 0 | 1 + T(i+1, j+1) when A[i] == B[j]
    private int memo( int i, int j, String A, String B, Integer[][] dp, int[] max ) {
        if (i < 0 || j < 0)
            return 0;

        if (dp[i][j] == null) {

            dp[i][j] = 0;

            // int a = 0;

            //only increase when both char matches
            if (A.charAt(i) == B.charAt(j))
                dp[i][j] = memo(i - 1, j - 1, A, B, dp, max) + 1;

            //This case is independent in Longest common subsequence
            memo(i - 1, j, A, B, dp, max);
            memo(i, j - 1, A, B, dp, max);

            //dp[i][j] = Math.max(b, c); //not working with this as in LOngestPalindromicSubstrinf
        }

        max[0] = Math.max(max[0], dp[i][j]);
        return dp[i][j];
    }
    //endregion

    //region 2D Bottom UP DP

    //we are ignoring the else or excluding part:
    /*
    if s1[i] == s2[j]
        dp[i][j] = 1 + dp[i-1][j-1]
    else
        dp[i][j] = 0
     */
    //Runtime: 98 ms, faster than 21.57% of Java
    public int findLCSLength_2D_DP( String s1, String s2 ) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        int maxLength = 0;

        for (int i = 1; i <= s1.length(); i++) {

            for (int j = 1; j <= s2.length(); j++) {

                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    maxLength = Math.max(maxLength, dp[i][j]);
                }
            }
        }

        return maxLength;
    }
    //endregion

    //region 2D Memory optimized
    //Runtime: 149 ms, faster than 11.90% of Java
    private int findLCSLength_2D_Memory_Optimized( String s1, String s2 ) {
        int[][] dp = new int[2][s2.length() + 1];
        int maxLength = 0;

        for (int i = 1; i <= s1.length(); i++) {

            for (int j = 1; j <= s2.length(); j++) {

                dp[i % 2][j] = 0;

                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i % 2][j] = 1 + dp[(i - 1) % 2][j - 1];
                    maxLength = Math.max(maxLength, dp[i % 2][j]);
                }
            }
        }
        return maxLength;
    }
    //endregion

    //region 1D DP :)
    //Runtime: 53 ms, faster than 44.55% of Java
    //loop Pattern of bounded knapsack ,check MinSubsetSumDiff : com.interview.leetcode.dp.grokkingdp.boundedknapsacktype
    private int findLCSLength_1D_DP( String s1, String s2 ) {
        int[] dp = new int[s2.length() + 1];

        int maxLength = 0, capacity = s2.length();

        for (int i = 1; i <= s1.length(); i++) {

            for (int j = capacity; j > 0; j--) {

                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[j] = 1 + dp[j - 1];
                    maxLength = Math.max(maxLength, dp[j]);
                } else { //must be in else part
                    dp[j] = 0;
                }
            }
        }

        return maxLength;
    }
    //endregion
}
