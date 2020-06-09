package com.interview.leetcode.dp.lis;

import java.util.HashMap;

public class LongestArithmeticSqByDifference {

    //https://leetcode.com/problems/longest-arithmetic-subsequence-of-given-difference/
    public static void main( String[] args ) {
        int[] arr = {1, 2, 3, 4};
        int diff = 1;

        System.out.println(longestSubsequence(arr, diff));
    }

    //Runtime: 44 ms, faster than 55.97% of Java
    private static int longestSubsequence( int[] arr, int difference ) {
        HashMap<Integer, Integer> dp = new HashMap<>();
        int longest = 0;

        //First Iteration : 1 --> 0 + 1 = 1
        //Second Iteration: 2 --> (2-1) + 1 = 2 bcz 1 already exists in map.
        for (int i = 0; i < arr.length; i++) {
            dp.put(arr[i],
                    dp.getOrDefault(arr[i] - difference, 0) + 1);

            longest = Math.max(longest, dp.get(arr[i]));
        }

        return longest;
    }
}
