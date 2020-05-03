package com.interview.leetcode.contests.contest187;

import java.util.TreeMap;

public class LongestContinuousSubArray {

    /*
    Given an array of integers nums and an integer limit,
    return the size of the longest continuous subarray such that the absolute difference between any
    two elements is less than or equal to limit.

    In case there is no subarray satisfying the given condition return 0.

    Input: nums = [8,2,4,7], limit = 4
    Output: 2

    eg: [2,4] with maximum absolute diff |2-4| = 2 <= 4.
     */
    //https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/
    public static void main( String[] args ) {
        int[] nums = {4, 2, 2, 2, 4, 4, 2, 2};
        int limit = 0;

        System.out.println(longestSubarray(nums, limit));
    }

    //Runtime: 57 ms, faster than 100.00% of Java
    private static int longestSubarray( int[] nums, int limit ) {
        int i = 0, j, max = Integer.MIN_VALUE;

        //this passed 50/54 test cases..
        /*TreeMap<Integer, Integer> treeSet = new TreeSet<>();
        for (j = 0; j < nums.length; j++) {
            treeSet.put(nums[j], j);

            if (treeSet.lastEntry().getValue() - treeSet.firstEntry().getValue() > limit)
                treeSet.remove(nums[i++]);
        }

        return j - i;*/

        //Runtime: 57 ms, faster than 100.00% of Java
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        for (j = 0; j < nums.length; j++) {

            treeMap.put(nums[j], 1 + treeMap.getOrDefault(nums[j], 0));

            if (treeMap.lastEntry().getKey() - treeMap.firstEntry().getKey() > limit) {
                treeMap.put(nums[i], treeMap.get(nums[i]) - 1);

                if (treeMap.get(nums[i]) == 0)
                    treeMap.remove(nums[i]);

                i++;
            }
        }

        return j - i;
    }
}
