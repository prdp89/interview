package com.interview.codechef.ccdsap_2.leetcode.dp.medium;

public class LargestSumOfAverages {

    //https://leetcode.com/problems/largest-sum-of-averages/
    public static void main( String[] args ) {
     /*   int[] arr = {9, 1, 2, 3, 9};
        int k = 3;*/

        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int k = 4;

        System.out.println(largestSumOfAverages(arr, k));
    }

    //ref: https://leetcode.com/problems/largest-sum-of-averages/discuss/123536/C%2B%2B-verbose-%2B-concise-solutions-(-EASY-to-understand-)-with-explanation
    //didn't understood properly.. :(
    private static double largestSumOfAverages( int[] A, int K ) {

        int N = A.length;

        int[] S = new int[N + 1];

        //calculating sum for each i
        for (int i = 1; i <= N; ++i)
            S[i] = S[i - 1] + A[i - 1];

        double[][] memo = new double[N + 1][N + 1];

        //storing average for each upto i average
        for (int i = 0; i < N; ++i)
            memo[i][1] = average(S, i, N);

        return recurse(S, 0, K, memo);
    }

    private static double recurse( int[] S, int i, int K, double[][] memo ) {

        if (memo[i][K] > 0)
            return memo[i][K];

        //generating subsets of different sizes
        for (int j = i + 1; j <= S.length - K; ++j) {

            //recurse on Next J subset with K-1 such that Max K subsets are generated
            memo[i][K] = Math.max(memo[i][K], average(S, i, j) + recurse(S, j, K - 1, memo));
        }

        return memo[i][K];
    }

    private static double average( int[] S, int i, int n ) {
        return (S[n] - S[i]) / (double) (n - i);
    }
}
