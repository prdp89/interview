package com.interview.leetcode.dp.lis;

import java.util.Arrays;

public class DeleteAndEarn {

    //https://leetcode.com/problems/delete-and-earn/
    public static void main( String[] args ) {
        System.out.println(deleteAndEarn(new int[]{3, 4, 2}));
    }

    //Runtime: 24 ms, faster than 6.28% of Java
    private static int deleteAndEarn( int[] nums ) {
        int[] dp = new int[nums.length];

        Arrays.sort(nums);

        int max = 0;

        //we can get nums[i] for each element, even if we don't delete anything
        for (int i = 0; i < dp.length; i++)
            dp[i] = nums[i];

        //almost same as LIS pattern
        for (int i = 0; i < nums.length; i++) {

            //This is reverse way of thinking what the question is asking:
            //We are not picking the element where nums[j] == num[i] - 1, bcz by doing this it will delete the nums[j]th element
            //and we can collect more element in relation to nums[i]

            //eg; {2, 3, 4}; If we are at element = 4, we do not pick 3 bcz : 4- 1 == 3, this gives us opportunity to collect
            // 2 + 4 ==> 6, which is max.
            for (int j = 0; j < i; j++) {

                if (nums[i] - 1 != nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + nums[i]);
                }
            }

            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
