package com.interview.leetcode.dp.lis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset {

    //https://leetcode.com/problems/largest-divisible-subset/
    public static void main( String[] args ) {
        largestDivisibleSubset(new int[]{1, 2, 4, 8}).forEach(System.out::println);

        System.out.println("optimal:");
        largestDivisibleSubset_Optimal(new int[]{1, 2, 4, 8}).forEach(System.out::println);
    }

    //19/41 test cases passed
    private static List<Integer> largestDivisibleSubset( int[] nums ) {

        Arrays.sort(nums);

        int[] dp = new int[nums.length];

        List<Integer> list = new ArrayList<>();

        if (nums.length == 0)
            return list;

        dp[0] = 1;

        if (nums.length < 2) {
            list.add(nums[0]);
            return list;
        }

        dp[1] = nums[1] % nums[0] == 0 || nums[0] % nums[1] == 0 ? 2 : 1;

        int maxIndex = dp[1] > dp[0] ? 1 : 0;

        for (int i = 2; i < nums.length; i++) {

            dp[i] = 1;
            int count = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0 || nums[j] % nums[i] == 0) {
                    count++;
                }
            }

            dp[i] = count;

            if (dp[i] > dp[i - 1])
                maxIndex = i;
        }

        int val = dp[maxIndex];

        while (val-- > 0) {
            list.add(0, nums[maxIndex--]);
        }

        return list;
    }

    //Runtime: 19 ms, faster than 38.19% of Java
    private static List<Integer> largestDivisibleSubset_Optimal( int[] nums ) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }

        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        dp[0] = 1;

        int lastIndex = 0;
        int maxLength = 1;

        for (int i = 1; i < nums.length; i++) {

            dp[i] = 1;

            //same as LIS;
            //IF jth element % ith then increase ith subset length..
            for (int j = 0; j < i; j++) {

                dp[i] = nums[i] % nums[j] == 0 ? Math.max(dp[i], dp[j] + 1) : dp[i];

                if (dp[i] > maxLength) {
                    lastIndex = i;
                    maxLength = dp[i];
                }
            }
        }

        // then add every divisible number before last index into the list
        List<Integer> a = new ArrayList<>();
        int last = nums[lastIndex];

        a.add(last);
        maxLength--;

        for (int i = lastIndex - 1; i >= 0; i--) {

            //every subset element must be divisible by 'last'
            if (last % nums[i] == 0 && dp[i] == maxLength) {
                a.add(nums[i]);

                //decreasing length bcz next subset length dp[i] should be one less than prev.
                maxLength--;
            }
        }

        return a;
    }
}
