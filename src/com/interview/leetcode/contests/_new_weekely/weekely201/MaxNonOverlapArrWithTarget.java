package com.interview.leetcode.contests._new_weekely.weekely201;

import java.util.HashMap;
import java.util.Map;

public class MaxNonOverlapArrWithTarget {

    //https://leetcode.com/contest/weekly-contest-201/problems/maximum-number-of-non-overlapping-subarrays-with-sum-equals-target/
    public static void main( String[] args ) {
        int[] arr = {1, 1, 1, 1, 1};
        System.out.println(maxNonOverlapping(arr, 2));

        //TLE approach using LIS pattern
        System.out.println(maxNonOverlapping_DP(arr, 2));
    }

    //similar or an extension to SubarraySumEqualsK
    private static int maxNonOverlapping( int[] nums, int target ) {

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);

        int res = 0, sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (map.containsKey(sum - target)) {
                res = Math.max(res, map.get(sum - target) + 1);
            }

            //or we store the existing sum in map with its occurance
            map.put(sum, res);
        }

        return res;
    }

    private static int maxNonOverlapping_DP( int[] nums, int target ) {
        int N = nums.length;
        int[] dp = new int[N + 1];

        for (int i = 0; i < N; ++i) {

            int sum = 0;

            for (int j = i; j >= 0; --j) {
                sum += nums[j];
                dp[i + 1] = Math.max(dp[i + 1], dp[j] + (sum == target ? 1 : 0));
            }
        }

        return dp[N];
    }

    public int maxNonOverlapping_another( int[] nums, int target ) {
        int sum = 0;
        int count = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int lastIndex = -1;

        for (int i = 0; i < nums.length; i++) {
            // calculate cumulative sum
            sum += nums[i];

            // check if there is subarray ending at index i & it starts after lastIndex
            if (map.containsKey(sum - target) && map.get(sum - target) >= lastIndex) {
                count++;
                lastIndex = i;
            }

            map.put(sum, i);
        }

        return count;

    }
}
