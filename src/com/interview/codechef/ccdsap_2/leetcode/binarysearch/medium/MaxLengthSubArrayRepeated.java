package com.interview.codechef.ccdsap_2.leetcode.binarysearch.medium;

//https://leetcode.com/problems/maximum-length-of-repeated-subarray/
public class MaxLengthSubArrayRepeated {

    public static void main( String[] args ) {
        int[] a = {1, 2, 3, 2, 1};
        int[] b = {3, 2, 1, 4, 7};
        System.out.println(findLength(a, b));

        System.out.println("Bottom Up : " + findLengthBottomUp(a, b));
    }

    private static int findLength( int[] A, int[] B ) {
        int[] max = new int[1];

        memo(A.length - 1, B.length - 1, A, B, new Integer[A.length][B.length], max);

        return max[0];
    }

    //This logic is almost same as LCS
    //Reccurrence : T(i, j) = 0 | 1 + T(i+1, j+1) when A[i] == B[j]
    private static int memo( int i, int j, int[] A, int[] B, Integer[][] dp, int[] max ) {
        if (i < 0 || j < 0)
            return 0;

        if (dp[i][j] == null) {

            dp[i][j] = 0;

            //only increase when both char matches
            if (A[i] == B[j])
                dp[i][j] = memo(i - 1, j - 1, A, B, dp, max) + 1;

            //This case is independent in Longest common subsequence
            memo(i - 1, j, A, B, dp, max);
            memo(i, j - 1, A, B, dp, max);
        }

        max[0] = Math.max(max[0], dp[i][j]);
        return dp[i][j];
    }

    private static int findLengthBottomUp( int[] a, int[] b ) {
        int m = a.length, n = b.length;

        if (m == 0 || n == 0)
            return 0;

        int[][] dp = new int[m + 1][n + 1];

        int max = 0;

        for (int i = m - 1; i >= 0; i--)
            for (int j = n - 1; j >= 0; j--)
                max = Math.max(max
                        , dp[i][j] = a[i] == b[j] ? 1 + dp[i + 1][j + 1] : 0);

        return max;
    }

    //didn't understood properly...
    public int findLengthBottomUpSpaceOptimal( int[] a, int[] b ) {
        int m = a.length, n = b.length;

        if (m == 0 || n == 0)
            return 0;

        int[] dp = new int[n + 1];

        int max = 0;

        for (int i = m - 1; i >= 0; i--)
            for (int j = 0; j < n; j++)
                max = Math.max(max
                        , dp[j] = a[i] == b[j] ? 1 + dp[j + 1] : 0);

        return max;
    }
}
