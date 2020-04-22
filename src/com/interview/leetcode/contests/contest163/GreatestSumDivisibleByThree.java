package com.interview.leetcode.contests.contest163;

public class GreatestSumDivisibleByThree {

    //https://leetcode.com/contest/weekly-contest-163/problems/greatest-sum-divisible-by-three/
    public static void main( String[] args ) {
        int[] arr = {3, 6, 5, 1, 8};

        System.out.println(maxSumDivThree(arr));
    }

    //ref : https://leetcode.com/problems/greatest-sum-divisible-by-three/discuss/431095/JAVA-C%2B%2B-O(N)-Time-O(1)-Space-using-DP
    private static int maxSumDivThree( int[] nums ) {
        int[] dp = new int[3];

        dp[1] = dp[2] = Integer.MIN_VALUE;

        for (int x : nums) {

            int[] dpNext = new int[3];

            dpNext[0] = Math.max(dp[x % 3] + x, dp[0]);
            dpNext[1] = Math.max(dp[(x + 1) % 3] + x, dp[1]);
            dpNext[2] = Math.max(dp[(x + 2) % 3] + x, dp[2]);
            dp = dpNext;
        }

        return dp[0];
    }
}
