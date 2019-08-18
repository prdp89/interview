package com.interview.codechef.ccdsap_2.leetcode.arrays.twopointers.easy;

import java.util.Arrays;

public class RemoveDuplicateSortedList {

    //https://leetcode.com/problems/remove-duplicates-from-sorted-array/
    public static void main( String[] args ) {
        int[] arr = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

        solve(arr);
    }

    //in one attempt
    private static void solve( int[] arr ) {

        //count is initially 0, we don't need to set first element
        int count = 0;

        //if prev is not equals to next
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] != arr[i]) {
                arr[count++] = arr[i];
            }
        }

        System.out.println(Arrays.toString(arr));

    }
}
