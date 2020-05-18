package com.interview.leetcode.contests.contest178;

import java.util.Arrays;

public class NumbersSmallerThanCurrent {

    //https://leetcode.com/contest/weekly-contest-178/problems/how-many-numbers-are-smaller-than-the-current-number/
    public static void main( String[] args ) {

        int[] nums = {8, 1, 2, 2, 3};
        // System.out.println(Arrays.toString(smallerNumbersThanCurrent(nums)));

        //System.out.println(Arrays.toString(smallerNumbersThanCurrentBSTry(nums))); //not working

        System.out.println(Arrays.toString(smallerNumbersThanCurrentOptimal(nums)));
    }

    //TIME: O(N ^ 2)
    private static int[] smallerNumbersThanCurrent( int[] nums ) {

        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {

            for (int j = 0; j < nums.length; j++) {

                if (j != i && nums[i] > nums[j]) {
                    dp[i] += 1;
                }
            }
        }

        return dp;
    }

    //MOre optimal : https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/discuss/524996/JAVA-beats-100-O(n)
    //TIME O(N)
    private static int[] smallerNumbersThanCurrentOptimal_ON( int[] nums ) {
        int[] bucket = new int[102];

        for (int i = 0; i < nums.length; i++)
            bucket[nums[i] + 1]++;

        for (int i = 1; i < 102; i++)
            bucket[i] += bucket[i - 1];

        for (int i = 0; i < nums.length; i++)
            nums[i] = bucket[nums[i]];

        return nums;
    }

    //similar to PeakIndexMountainArray
    //Runtime: 3 ms, faster than 79.30% of Java
    //O(N LOG N)
    private static int[] smallerNumbersThanCurrentOptimal( int[] nums ) {
        int[] numsCopy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(numsCopy);

        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = binarySearch(numsCopy, nums[i]);
        }

        return res;
    }

    private static int binarySearch( int[] nums, int target ) {
        int l = 0, r = nums.length - 1;

        while (l < r) {
            int mid = ((l + r) / 2);

            if (nums[mid] < target)
                l = mid + 1;
            else r = mid;
        }

        return l;
    }
}
