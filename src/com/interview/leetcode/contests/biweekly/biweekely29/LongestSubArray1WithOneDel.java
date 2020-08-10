package com.interview.leetcode.contests.biweekly.biweekely29;

public class LongestSubArray1WithOneDel {

    //https://leetcode.com/contest/biweekly-contest-29/problems/longest-subarray-of-1s-after-deleting-one-element/
    public static void main( String[] args ) {
        int[] nums = {1, 1, 0, 0, 1, 1, 1, 0, 1};
        System.out.println(longestSubArray(nums));
    }

    //same as MaxConsecutiveOnesIII
    private static int longestSubArray( int[] nums ) {
        int j = 0, i = 0, count = 0, zeros = 1; //why zeros = 1 : bcz deleting of 1 one zero is allowed..

        while (j < nums.length) {

            if (nums[j] == 0)
                zeros--;

            //this loop only execute until second zero arrives
            while (zeros < 0) {
                if (nums[i] == 0)
                    zeros++;

                i++;
            }

            count = Math.max(count, j - i);
            j++;
        }

        return count;
    }
}
