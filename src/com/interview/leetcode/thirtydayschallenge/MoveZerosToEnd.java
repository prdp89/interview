package com.interview.leetcode.thirtydayschallenge;

import java.util.Arrays;

public class MoveZerosToEnd {

    public static void main( String[] args ) {
        int[] arr = {0, 1, 0, 3, 12};

        moveZeroes(arr);

        System.out.println(Arrays.toString(arr));
    }

    private static void moveZeroes( int[] nums ) {

        int j = 0, i = 0;
        for (; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        while (j < nums.length) {
            nums[j] = 0;
            j++;
        }
    }
}
