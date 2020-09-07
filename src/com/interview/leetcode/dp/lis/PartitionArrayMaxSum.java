package com.interview.leetcode.dp.lis;

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

    // Let k be 2
    // Focus on "growth" of the pattern
    // Define A' to be a partition over A that gives max sum

    // #0
    // A = {1}
    // A'= {1} => 1

    // #1
    // A = {1, 2}
    // A'= {1}{2} => 1 + 2 => 3 X
    // A'= {1, 2} => {2, 2} => 4 AC

    // #2
    // A = {1, 2, 9}
    // A'= {1, 2}{9} => {2, 2}{9} => 4 + 9 => 13 X
    // A'= {1}{2, 9} => {1}{9, 9} => 1 + 18 => 19 AC

    // #3
    // A = {1, 2, 9, 30}
    // A'= {1}{2, 9}{30} => {1}{9, 9}{30} => 19 + 30 => 49 X
    // A'= {1, 2}{9, 30} => {2, 2}{30, 30} => 4 + 60 => 64 AC

    // Now, label each instance. Use F1() to represent how A is partitioned and use F2() to represent
    // the AC value of that partition. F2() is the dp relation we are looking for.

    // #4
    // A = {1, 2, 9, 30, 5}
    // A'= F1(#3){5} => F2(#3) + 5 => 69 X
    // A'= F1(#2){30, 5} => F2(#2) + 30 + 30 => 79 AC
    // => F2(#4) = 79
    private static int maxSumAfterPartitioning_bottomUP( int[] A, int K ) {
        int[] dp = new int[A.length];

        dp[0] = A[0];

        for (int i = 1; i < A.length; i++) {
            int maxSum = A[i] + dp[i - 1], maxVal = A[i];

            //pattern look like LIS, just diff of this condt:  j > i - K
            for (int j = i - 1; j >= 0 && j > i - K; j--) {

                maxVal = Math.max(maxVal, A[j]);

                if (j == 0) {
                    maxSum = Math.max(maxSum, maxVal * (i - j + 1)); //(i - j + 1) : nums between [i,j]
                } else {
                    maxSum = Math.max(maxVal * (i - j + 1) + dp[j - 1], maxSum);
                }

            }
            dp[i] = maxSum;
        }

        return dp[A.length - 1];
    }
}
