package com.interview.leetcode.dp.lis;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class LongestConsecutiveSequence {

    //https://leetcode.com/problems/longest-consecutive-sequence/
    public static void main( String[] args ) {
        int[] arr = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(arr));

        System.out.println(longestConsecutive_another_way(arr));
    }

    //Runtime: 5 ms, faster than 65.17% of Java
    private static int longestConsecutive( int[] nums ) {

        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        int longestStreak = 0;
        for (int num : set) {

            //if set doesn't have num-1 element that means Set probably have element greater than current num
            if (!set.contains(num - 1)) {
                int currNum = num;
                int currStreak = 1; //bcz every element is longest in itself

                while (set.contains(currNum + 1)) {
                    currStreak += 1;
                    currNum += 1; //continuously check for next element in Set
                }

                longestStreak = Math.max(longestStreak, currStreak);
            }
        }

        return longestStreak;
    }

    private static int longestConsecutive_another_way( int[] nums ) {
        if (nums == null || nums.length == 0)
            return 0;

        Set<Integer> set = new HashSet<>();

        for (int i : nums) set.add(i);
        int ans = 0;

        for (int num : nums) {
            int left = num - 1;
            int right = num + 1;

            while (set.remove(left)) left--;
            while (set.remove(right)) right++;

            ans = Math.max(ans, right - left - 1);

            if (set.isEmpty())
                return ans;//save time if there are items in nums, but no item in hashset.
        }

        return ans;
    }
}
