package com.interview.codechef.ccdsap_2.leetcode.dp.medium;

import java.util.Arrays;

public class DeleteEarn {

    //https://leetcode.com/problems/delete-and-earn/

    //This problem is similar to HouseRobber
    public static void main( String[] args ) {
        // int[] arr = {3, 4, 2}; //op : 6

        int[] arr = {2, 2, 3, 3, 3, 4};

        //each number in an array must between 1..10000
        int[] buckets = new int[10001];
        int[] dp = new int[10001];

        Arrays.fill(dp, -1);

        //similar to count array; storing sum of repeated numbers.
        for (int num : arr) {
            buckets[num] += num;
        }

        System.out.println(rob(buckets, buckets.length - 1, dp));
    }

    //recurrence working but returns TLE
    private static int rob( int[] nums, int i, int[] dp ) {
        if (i < 0) {
            return 0;
        }

       /* if (dp[i] != -1 && dp[i] != 0)
            return dp[i];*/

        if (nums[i] != 0) {
            return Math.max(

                    rob(nums, i - 2, dp) + nums[i] //checking if looting current house and next->next will work

                    //or

                    , rob(nums, i - 1, dp));       //Looting of next house will work :)
        }

        return rob(nums, i - 1, dp);
    }

    //BOTTOM UP DP CODE LIKE    HouseRobber
    public int deleteAndEarn( int[] nums ) {
        int[] buckets = new int[10001];
        for (int num : nums) {
            buckets[num] += num;
        }

        int[] dp = new int[10001];

        dp[0] = buckets[0];
        dp[1] = buckets[1];

        for (int i = 2; i < buckets.length; i++) {
            dp[i] = Math.max(buckets[i] + dp[i - 2], dp[i - 1]);
        }
        return dp[10000];
    }
}
