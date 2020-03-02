package com.interview.codechef.ccdsap_2.leetcode.contests.contest178;

import java.util.Arrays;

public class NumbersSmallerThanCurrent {

    //https://leetcode.com/contest/weekly-contest-178/problems/how-many-numbers-are-smaller-than-the-current-number/
    public static void main( String[] args ) {

        int[] nums = {8, 1, 2, 2, 3};
        System.out.println(Arrays.toString(smallerNumbersThanCurrent(nums)));
    }

    private static int[] smallerNumbersThanCurrent( int[] nums ) {

        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {

            for (int j = 0; j < nums.length; j++) {

                //if(j !=i && arr[])
            }
        }

        return dp;
    }
}
