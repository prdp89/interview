package com.interview.leetcode.dp.grokkingdp.stringmanipulation;

public class MaxSumIncreasingSubSeq {

    //This is diff. from Kadane Algo: https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
    public static void main( String[] args ) {
        MaxSumIncreasingSubSeq msis = new MaxSumIncreasingSubSeq();
        int[] nums = {4, 1, 2, 6, 10, 1, 12};
        System.out.println(msis.findMSIS(nums));
    }

    /*
   Given a number sequence, find the increasing subsequence with the highest sum. Write a method that returns the highest sum.

   Example 1:

   Input: {4,1,2,6,10,1,12}
   Output: 32
   Explanation: The increaseing sequence is {4,6,10,12}.
   Please note the difference, as the LIS is {1,2,6,10,12} which has a sum of '31'.
    */

    //Time : O(n ^ 2), Space : O(N)
    private int findMSIS( int[] nums ) {
        int[] dp = new int[nums.length];

        int max = Integer.MIN_VALUE;

        dp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {

            for (int j = 0; j < i; j++) {

                if (nums[j] < nums[i] && dp[i] < dp[j] + nums[i])
                    dp[i] = dp[j] + nums[i];
            }

            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
