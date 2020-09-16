package com.interview.leetcode.thirtydaysseptchallenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContainDuplicateII {

    //https://leetcode.com/problems/contains-duplicate-ii/
    public static void main( String[] args ) {
        int[] arr = {1, 2, 3, 1};
        int k = 3;

        System.out.println(containsNearbyDuplicate(arr, k));

        System.out.println(containsNearbyDuplicate_optimal(arr, k));
    }

    //21 / 23 test cases passed.
    private static boolean containsNearbyDuplicate( int[] nums, int k ) {

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);

            if (map.get(nums[i]).size() > 1) {
                List<Integer> list = map.get(nums[i]);

                for (int j = 0, l = list.size() - 1; j < l; ) {
                    if (list.get(l) - list.get(j) > k)
                        l--;
                    else if (list.get(l) - list.get(j) <= k)
                        return true;
                }
            }
        }

        return false;
    }

    //Runtime: 4 ms, faster than 98.84% of Java
    private static boolean containsNearbyDuplicate_optimal( int[] nums, int k ) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            Integer oldValue = map.put(nums[i], i);

            if (oldValue != null && i - oldValue <= k) {
                return true;
            }
        }

        return false;
    }
}
