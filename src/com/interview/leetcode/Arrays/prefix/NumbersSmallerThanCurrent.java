package com.interview.leetcode.Arrays.prefix;

import java.util.Arrays;

public class NumbersSmallerThanCurrent {

    //https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/
    public static void main( String[] args ) {
        int[] arr = {8, 1, 2, 2, 3};
        System.out.println(Arrays.toString(smallerNumbersThanCurrent(arr)));
    }

    //Runtime: 1 ms, faster than 99.52% of Java
    //https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/discuss/524996/JAVA-beats-100-O(n)
    private static int[] smallerNumbersThanCurrent( int[] nums ) {
        int[] prefixArr = new int[101];
        int[] res = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            prefixArr[nums[i]]++;
        }

        for (int i = 1; i <= 100; i++) {
            prefixArr[i] += prefixArr[i - 1]; //storing the nums smaller than current
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                res[i] = 0;
            else
                res[i] = prefixArr[nums[i] - 1];
        }

        return res;
    }
}
