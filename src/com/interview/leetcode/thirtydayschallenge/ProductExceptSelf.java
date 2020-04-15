package com.interview.leetcode.thirtydayschallenge;

import java.util.Arrays;

public class ProductExceptSelf {

    //https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/530/week-3/3300/
    public static void main( String[] args ) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 2, 3, 4})));
    }

    private static int[] productExceptSelf( int[] nums ) {

        int leftArr[] = new int[nums.length];
        int rightArr[] = new int[nums.length];
        int opArr[] = new int[nums.length];

        leftArr[0] = 1;
        rightArr[nums.length - 1] = 1;

        for (int i = 1; i < nums.length; i++) {
            leftArr[i] = leftArr[i - 1] * nums[i - 1];
        }

        for (int i = nums.length - 2; i >= 0; i--) {
            rightArr[i] = rightArr[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < nums.length; i++)
            opArr[i] = leftArr[i] * rightArr[i];

        return opArr;
    }
}
