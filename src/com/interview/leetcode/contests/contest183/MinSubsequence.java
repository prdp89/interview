package com.interview.leetcode.contests.contest183;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinSubsequence {

    //https://leetcode.com/contest/weekly-contest-183/problems/minimum-subsequence-in-non-increasing-order/
    public static void main( String[] args ) {
        int[] nums = {1};
        minSubsequence(nums).forEach(System.out::println);
    }

    //101 / 103 test cases passed.
    private static List<Integer> minSubsequence( int[] nums ) {
        List<Integer> list = new ArrayList<>();

        if (nums.length == 1) {
            list.add(nums[0]);
            return list;
        }

        Integer[] integers = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++)
            integers[i] = nums[i];

        Arrays.sort(integers, Collections.reverseOrder());

        int sum = 0, div;
        for (int num : nums) {
            sum += num;
        }

        div = sum / 2;

        int i = 0;
        while (sum >= div) {
            sum -= integers[i++];
        }

        for (int j = 0; j <= i - 1; j++)
            list.add(integers[j]);

        return list;
    }

    private static List<Integer> minSubsequenceAllTestPassed( int[] nums ) {
        Arrays.sort(nums);
        List<Integer> arr = new ArrayList<>();

        long sum = 0;

        for (int i : nums)
            sum += i;

        long ans = 0;

        for (int i = nums.length - 1; i >= 0; i--) {

            arr.add(nums[i]);
            ans += nums[i];

            if (ans > sum - ans)
                return arr;
        }

        return arr;
    }
}
