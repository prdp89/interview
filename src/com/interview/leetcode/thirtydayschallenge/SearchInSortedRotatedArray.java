package com.interview.leetcode.thirtydayschallenge;

public class SearchInSortedRotatedArray {

    //qut: https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/530/week-3/3304/
    //nice explanation : https://www.youtube.com/watch?v=84a8fQp5hJA
    public static void main( String[] args ) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};

        //finding num=0 and OP= index = 4
        System.out.println(search(arr, 0));

        System.out.println(searchInSortedRotatedII(arr, 0));
    }

    private static int search( int[] nums, int target ) {

        if (nums.length == 0)
            return -1;

        int low = 0, high = nums.length - 1;

        int firstNum = nums[0];

        //logic: we are searching if we are in increasing part of array or decreasing part of array.
        //       based on that, we are moving pointers : low, high
        while (low <= high) {

            int mid = (high + low) / 2;

            int midValue = nums[mid];

            if (midValue == target)
                return mid;

            boolean i_am_big = midValue >= firstNum; //this means we are somewhere in first half{increasing side of an array}
            boolean target_big = target >= firstNum;

            if (i_am_big == target_big) //this confirms we are in first half of array only..
            //we are in the same part as target we're allowed to do standard binary search
            {
                //this condition is equals to Binary search..
                if (midValue < target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else { //we are in second half of array probably..
                if (i_am_big) { //doing same Binary search and moving pointers
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }

    //https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
    private static boolean searchInSortedRotatedII( int[] nums, int target ) {
        if (nums.length == 0)
            return false;

        int low = 0, high = nums.length - 1;

        int firstNum = nums[0];

        //logic: we are searching if we are in increasing part of array or decreasing part of array.
        //       based on that, we are moving pointers : low, high
        while (low <= high) {

            //only diff-------
            while (low < high && nums[low] == nums[low + 1]) low++; // skip duplicates from the left
            while (high > low && nums[high] == nums[high - 1]) high--; // skip duplicates from the right
            //-----------------

            int mid = (high + low) / 2;

            int midValue = nums[mid];

            if (midValue == target)
                return true;

            boolean i_am_big = midValue >= firstNum; //this means we are somewhere in first half{increasing side of an array}
            boolean target_big = target >= firstNum;

            if (i_am_big == target_big) //this confirms we are in first half of array only..
            {
                //this condition is equals to Binary search..
                if (midValue < target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else { //we are in second half of array
                if (i_am_big) { //doing same Binary search as above..
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

        }

        return false;
    }
}
