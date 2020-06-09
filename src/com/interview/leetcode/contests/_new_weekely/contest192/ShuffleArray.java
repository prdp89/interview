package com.interview.leetcode.contests._new_weekely.contest192;

import java.util.Arrays;

public class ShuffleArray {

    //https://leetcode.com/contest/weekly-contest-192/problems/shuffle-the-array/
    public static void main( String[] args ) {
        int[] nums = {2, 5, 1, 3, 4, 7};
        int n = 3;

        System.out.println(Arrays.toString(shuffle(nums, n)));
    }

    private static int[] shuffle( int[] nums, int n ) {
        int[] ans = new int[nums.length];

        for (int i = 0; i < n; ++i) {
            ans[2 * i] = nums[i];
            ans[2 * i + 1] = nums[i + n];
        }

        return ans;
    }
}
