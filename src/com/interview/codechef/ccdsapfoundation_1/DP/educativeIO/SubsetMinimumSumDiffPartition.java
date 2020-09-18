package com.interview.codechef.ccdsapfoundation_1.DP.educativeIO;

import java.util.Arrays;
import java.util.Scanner;

public class SubsetMinimumSumDiffPartition {

    //This problem recursive relation is same Hackerrank->Recursion->Advanve -> GroupSum problems..
    /*
    2
    4
    1 6 5 11
    4
    36 7 46 40

    Output :
    1
    23
     */
    //Ref : SplitArray Problem

    private static long totalSum = 0;

    //https://www.geeksforgeeks.org/partition-a-set-into-two-subsets-such-that-the-difference-of-subset-sums-is-minimum/
    public static void main( String[] args ) {

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] arr = new int[n];

            totalSum = 0;

            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
                totalSum += arr[i];
            }

            //recursive
            // System.out.println(splitHelper(0, arr, 0, 0));

            //top down dp
            long[][] dp = new long[n + 1][(int) totalSum + 1];

            for (long[] a : dp) {
                Arrays.fill(a, -1);
            }

            System.out.println(diffDpSolution(0, 0, n, dp, arr));
        }
    }

    private static int splitHelper( int start, int[] nums, int groupSum1, int groupSum2 ) {

        if (start >= nums.length) {
            return Math.abs(groupSum1 - groupSum2);
        }

        return Math.min(splitHelper(start + 1, nums, groupSum1 + nums[start], groupSum2),

                splitHelper(start + 1, nums, groupSum1, groupSum2 + nums[start]));
    }

    private static long diffDpSolution( int pos, long sum, int N, long dp[][], int arr[] ) {

        if (pos == N) {
            return Math.abs(sum - (totalSum - sum)); //equal to groupsum1 - grupsum2
        }

        if (dp[pos][(int) sum] != -1)
            return dp[pos][(int) sum];

        long ret1 = diffDpSolution(pos + 1, sum + arr[pos], N, dp, arr); //include
        long ret2 = diffDpSolution(pos + 1, sum, N, dp, arr); //exclude

        dp[pos][(int) sum] = Math.min(ret1, ret2);

        return dp[pos][(int) sum];
    }
}
