package com.interview.leetcode.dp;

public class PartitionArrayMaxSum {

    //https://leetcode.com/problems/partition-array-for-maximum-sum/
    public static void main( String[] args ) {
        int A[] = {1, 15, 7, 9, 2, 5, 10};
        int k = 3;
        System.out.println("DFS:" + maxSumAfterPartitioning_DFS(A, k));

        System.out.println("Bottom up DP:" + maxSumAfterPartitioning_bottomUP(A, k));
    }

    private static int dfs( int[] A, int K, int start, int[] dp ) {
        int n = A.length;

        if (start >= n)
            return 0;

        if (dp[start] != 0) {
            return dp[start];
        }

        int maxSum = 0, maxEle = 0;
        for (int i = start; i < Math.min(n, start + K); i++) {
            maxEle = Math.max(maxEle, A[i]);

            maxSum = Math.max(maxSum, maxEle * (i - start + 1) + dfs(A, K, i + 1, dp));
        }

        dp[start] = maxSum;
        return maxSum;
    }

    private static int maxSumAfterPartitioning_DFS( int[] A, int K ) {
        int n = A.length;
        int[] dp = new int[n];
        return dfs(A, K, 0, dp);
    }

    private static int maxSumAfterPartitioning_bottomUP( int[] A, int K ) {
        int N = A.length, dp[] = new int[N];

        //logic is little bit similar to CoinChangeMinCoins
        for (int i = 0; i < N; ++i) {

            int curMax = 0;

            for (int k = 1; k <= K && i - k + 1 >= 0; ++k) {

                //previous max
                curMax = Math.max(curMax, A[i - k + 1]);

                dp[i] = Math.max(dp[i], (i >= k ? dp[i - k] : 0) + curMax * k);
            }
        }
        return dp[N - 1];
    }
}
