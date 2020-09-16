package com.interview.leetcode.thirtydaysseptchallenge;

import java.util.TreeSet;

public class ContainsDuplicateIII {

    //https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/554/week-1-september-1st-september-7th/3446/
    public static void main( String[] args ) {
        int[] nums = {1, 0, 1, 1};
        int k = 1, t = 2;

        System.out.println(containsNearbyAlmostDuplicate(nums, k, t));

        System.out.println(containsNearbyAlmostDuplicate_optimal(nums, k, t));
    }

    //25 / 53 test cases passed.
    private static boolean containsNearbyAlmostDuplicate( int[] nums, int k, int t ) {

        int i = 0, j = nums.length - 1;

        for (; i < j; ) {
            if (j - i != k) {

                if (Math.abs(nums[i] - nums[j]) > t && nums[i] < nums[j]) {
                    i++;
                } else {
                    j--;
                }
            } else if (j - i == k) {
                return Math.abs(nums[i] - nums[j]) == t;
            }
        }

        return false;
    }

    //Runtime: 29 ms, faster than 34.59% of Java
    private static boolean containsNearbyAlmostDuplicate_optimal( int[] nums, int k, int t ) {
        TreeSet<Long> set = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            long num = (long) nums[i];

            Long floor = set.floor(num);
            Long ceiling = set.ceiling(num);

            //At most means: nums[j] - nums[i] <= t
            if ((floor != null && num - floor <= t) ||
                    (ceiling != null && ceiling - num <= t)) {
                return true;
            }

            set.add(num);

            //difference between i and j is at most k
            //so we exclude the nums greater than in K range
            //This is similar to SlidingWindow
            if (i >= k)
                set.remove((long) nums[i - k]);
        }

        return false;
    }
}
