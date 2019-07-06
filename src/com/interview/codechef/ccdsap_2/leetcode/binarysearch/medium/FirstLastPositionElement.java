package com.interview.codechef.ccdsap_2.leetcode.binarysearch.medium;

import java.util.Arrays;

public class FirstLastPositionElement {

    public static void main( String[] args ) {
        int[] a = {5, 7, 7, 8, 8, 10};
        int target = 8;

        /*int[] a = {5, 7, 7, 8, 8, 10};
        int target = 6;*/

        System.out.println(Arrays.toString(searchRange(a, target)));
    }

    //Logic is similiar to this : https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/discuss/14701/A-very-simple-Java-solution-with-only-one-binary-search-algorithm

    //Almost solved it.
    private static int[] searchRange( int[] nums, int target ) {

        int start = 0, end = nums.length - 1;

        Integer[] arr = new Integer[nums.length];
        int i = 0;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                arr[i++] = mid;
                end = mid;
            } else if (nums[mid] < target)
                start = mid + 1;
            else
                end = mid;
        }

        int[] op = new int[2];
        int k = 0;
        boolean allNull = false;

        for (Integer j : arr) {
            if (j != null) {
                allNull = true;
                op[k++] = j;
            }

            if (k > 1)
                break;
        }

        if (!allNull) {
            op[0] = op[1] = -1;
        }

        Arrays.sort(op);

        return op;
    }
}
