package com.interview.leetcode.contests.contest178;

import java.util.*;

public class NumbersSmallerThanCurrent {

    //https://leetcode.com/contest/weekly-contest-178/problems/how-many-numbers-are-smaller-than-the-current-number/
    public static void main( String[] args ) {

        int[] nums = {8, 1, 2, 2, 3};
        // System.out.println(Arrays.toString(smallerNumbersThanCurrent(nums)));

        //System.out.println(Arrays.toString(smallerNumbersThanCurrentBSTry(nums))); //not working

        System.out.println(Arrays.toString(smallerNumbersThanCurrentOptimal(nums)));
    }

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

    private static int[] smallerNumbersThanCurrentBSTry( int[] nums ) {
        int[] dp = new int[nums.length];

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++)
            list.add(nums[i]);

        Collections.sort(list);

        HashSet<Integer> dp_1 = new HashSet<>(list);

        list = new ArrayList<>(dp_1);

        TreeMap<Integer, Integer> set = new TreeMap<>();
        for (int i = 0; i < list.size(); i++) {
            set.put(list.get(i), i);
        }

        for (int i = 0; i < nums.length; i++) {
            dp[i] = set.ceilingEntry(nums[i]).getValue();
        }

        return dp;
    }

    //similar to PeakIndexMountainArray
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
