package com.interview.leetcode.nickwhite;

import java.util.Arrays;

public class ShortestUnSortedArray {

    //https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
    public static void main( String[] args ) {
        int[] arr = {2, 6, 4, 8, 10, 9, 15};

        System.out.println(findUnsortedSubarray(arr));
    }

    //Runtime: 6 ms, faster than 54.03% of Java
    private static int findUnsortedSubarray( int[] nums ) {
        int[] clone = nums.clone();
        Arrays.sort(clone);

        int start = nums.length, end = 0;
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] != clone[i]) {
                start = Math.min(start, i);
                end = Math.max(end, i);
            }
        }

        return end - start > 0 ? end - start + 1 : 0;
    }
}
