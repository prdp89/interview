package com.interview.leetcode.binarysearch;

import java.util.HashSet;

public class MinInSortedRotatedArray {

    //https://leetcode.com/explore/learn/card/binary-search/126/template-ii/949/
    public static void main( String[] args ) {
        System.out.println(findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
    }

    //understood & done by me :)
    private static int findMin( int[] nums ) {
        int start = 0, end = nums.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] < nums[end])
                end = mid; //search in left part
            else if (nums[mid] > nums[end]) {//skip mid and search in right part
                start = mid + 1;
            }
        }

        return nums[end];
    }

    //https://leetcode.com/explore/learn/card/binary-search/144/more-practices/1031/
    public int findMinII(int[] nums) {

        int start = 0, end = nums.length - 1;

        while(start < end) {
            int mid = start + (end - start) / 2;

            if(nums[mid] < nums[end])
                end = mid;
            else if(nums[mid] > nums[end])
                start = mid + 1;
            else
                end--;
        }

        return nums[end];
    }

}
