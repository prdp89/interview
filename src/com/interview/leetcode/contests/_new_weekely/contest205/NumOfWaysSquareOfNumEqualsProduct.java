package com.interview.leetcode.contests._new_weekely.contest205;

import java.util.HashMap;
import java.util.Map;

public class NumOfWaysSquareOfNumEqualsProduct {

    //https://leetcode.com/problems/number-of-ways-where-square-of-number-is-equal-to-product-of-two-numbers/
    public static void main( String[] args ) {
        int[] nums1 = {7, 4};
        int[] nums2 = {5, 2, 8, 9};

        System.out.println(numTriplets(nums1, nums2));
    }

    //Similar to Two sum problem..
    //Runtime: 261 ms, faster than 20.22% of Java
    private static int numTriplets( int[] nums1, int[] nums2 ) {
        long res = 0;

        for (int item : nums1) {
            res += product((long) item * (long) item, nums2);
        }

        for (int item : nums2) {
            res += product((long) item * (long) item, nums1);
        }

        return (int) res;
    }

    private static long product( long i, int[] nums ) {
        Map<Long, Long> map = new HashMap<>();

        long count = 0;

        //we have find i == nums[j] * nums[k]
        //which is equals to i / nums[j] == nums[k]

        //eg 16 == 2 * 8 => 16 / 2 == 8
        //First we have 2, we store into map[2] = 1
        //then we found 8, 16 / 8 = 2 where map[2] = 1 so count +=1
        for (long item : nums) {

            //we found a match; retrieve value from Map
            if (i % item == 0) {
                count += map.getOrDefault(i / item, 0L);
            }

            map.put(item, map.getOrDefault(item, 0L) + 1);
        }

        return count;
    }
}
