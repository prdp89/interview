package com.interview.leetcode.dp.grokkingdp.stringmanipulation;

public class MinDeletionSeqSorted {

    /*
    Input: {4,2,3,6,10,1,12}
    Output: 2
    Explanation: We need to delete {4,1} to make the remaing sequence sorted {2,3,6,10,12}.
     */

    //This question is almost same as LongestIncreasingSubseq
    public static void main( String[] args ) {
        MinDeletionSeqSorted mdss = new MinDeletionSeqSorted();
        int[] nums = {4, 2, 3, 6, 10, 1, 12};
        System.out.println(mdss.findMinimumDeletions(nums));
    }

    private int findMinimumDeletions( int[] nums ) {
        // subtracting the length of LIS from the length of the input array to get minimum number of deletions
        return nums.length - findLISLength(nums);
    }

    private int findLISLength( int[] nums ) {
        int[] dp = new int[nums.length];
        dp[0] = 1;

        int maxLength = 1;
        for (int i = 1; i < nums.length; i++) {

            dp[i] = 1;

            for (int j = 0; j < i; j++)
                if (nums[i] > nums[j] && dp[i] <= dp[j]) {
                    dp[i] = dp[j] + 1;
                    maxLength = Math.max(maxLength, dp[i]);
                }
        }

        return maxLength;
    }
}
