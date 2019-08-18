package com.interview.codechef.ccdsap_2.leetcode.binarysearch.medium;

import java.util.Arrays;

public class FirstLastPositionElement {

    //https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
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

    //this logic is same as PeakIndexMountainArray
    private static int searchEqualOrGreater( int[] nums, int target ) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            //mid is always biased towards left
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < target)
                lo = mid + 1;
            else
                //we want to move hi to the left
                hi = mid;
        }
        return lo;
    }

    public int[] searchRangeOPtimal( int[] nums, int target ) {
        if (nums.length == 0)
            return new int[]{-1, -1};

        //this returns lower_bound of target
        int left = searchEqualOrGreater(nums, target);

        if (nums[left] != target)
            return new int[]{-1, -1};

        //searching for target+1 : if it is found then index of target will be "left_1_index - 1"
        //otherwise we already reach to correct index.
        int left_1 = searchEqualOrGreater(nums, target + 1);

        int right;
        if (nums[left_1] >= target + 1)
            right = left_1 - 1;
        else
            right = left_1;

        return new int[]{left, right};
    }
}
