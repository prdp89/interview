package com.interview.codechef.ccdsap_2.leetcode.dp.easy;

public class MaximumSubArray {

    //https://leetcode.com/problems/maximum-subarray/
    public static void main( String[] args ) {
        int[] arr = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(recurse(arr, arr.length - 1));
    }

    //returning wrong result...
    private static int recurse( int[] arr, int i ) {

        if (i == 0)
            return arr[i];

        return arr[i] + (recurse(arr, i - 1) < 0 ? 0 : recurse(arr, i - 1));
    }

    //Almost solved it..faling few test cases
    //Using Kadane Algo.
    public int maxSubArray( int[] nums ) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int max = nums[0], sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (sum < 0) {
                sum = nums[i];
            } else {
                sum += nums[i];
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}
