package com.interview.leetcode.Arrays.prefix;

import java.util.Arrays;

public class Candy {

    //https://leetcode.com/problems/candy/
    public static void main( String[] args ) {
        System.out.println(candy(new int[]{1, 0, 2}));
    }

    private static int candy( int[] ratings ) {
        int[] nums = new int[ratings.length];
        Arrays.fill(nums, 1);

        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1])
                nums[i] = nums[i - 1] + 1; //one more than prev. ratinf
        }

        for (int i = ratings.length - 1; i > 0; i--) {
            if (ratings[i - 1] > ratings[i]) {
                nums[i - 1] = Math.max(nums[i] + 1, nums[i - 1]);
            }
        }

        int res = 0;
        for (int i = 0; i < nums.length; i++)
            res += nums[i];

        return res;
    }
}
