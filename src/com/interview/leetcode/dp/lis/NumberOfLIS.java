package com.interview.leetcode.dp.lis;

public class NumberOfLIS {

    //https://leetcode.com/problems/number-of-longest-increasing-subsequence/
    public static void main( String[] args ) {
        System.out.println(findNumberOfLIS_Optimal(new int[]{1, 3, 5, 4, 7}));
    }

    //Runtime: 13 ms, faster than 57.76% of Java
    private static int findNumberOfLIS_Optimal( int[] nums ) {
        if (nums.length == 0)
            return 0;

        int[] dp = new int[nums.length];
        int max = 1;

        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;

            for (int j = 0; j < i; j++) {

                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
            }

            max = Math.max(max, dp[i]);
        }

        if (max == 1)
            return nums.length;

        //NOw pending is, total ways to combine elements that create group, maybe similar to second part of LargestDivisibleSubset
        int[] ways = new int[nums.length];
        ways[0] = 1;

        for (int i = 0; i < nums.length; i++) {
            //ways[i] = 1;

            if (dp[i] == 1) {
                ways[i] = 1;
                continue;
            }

            for (int j = 0; j < i; j++) {

                //eg: {1,3,5,4,7} : ways => {1, 3, 4, 7} , {1, 3, 5, 7}
                //if we are at 7 : we can find two ways : {1,3,4} and {1,3,5}
                if (dp[j] + 1 == dp[i] && nums[j] < nums[i])
                    ways[i] += ways[j];
            }
        }

        int res = 0;

        //Finally, include only max number of ways..
        for (int i = 0; i < nums.length; i++)
            if (dp[i] == max)
                res += ways[i];

        return res;
    }

    //only 25 / 223 test cases passed.
    public int findNumberOfLIS( int[] nums ) {

        if (nums.length == 0)
            return 0;

        int[] dp = new int[nums.length];
        int max = 1;

        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;

            for (int j = 0; j < i; j++) {

                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
            }

            max = Math.max(max, dp[i]);
        }

        int count = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == max)
                count++;
        }

        return count;
    }
}
