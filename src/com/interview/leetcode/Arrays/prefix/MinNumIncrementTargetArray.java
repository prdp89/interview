package com.interview.leetcode.Arrays.prefix;

public class MinNumIncrementTargetArray {

    //https://leetcode.com/problems/minimum-number-of-increments-on-subarrays-to-form-a-target-array/
    public static void main( String[] args ) {
        int[] arr = {1, 2, 3, 2, 1};

        System.out.println(minNumberOperations(arr));
    }

    //https://leetcode.com/problems/minimum-number-of-increments-on-subarrays-to-form-a-target-array/discuss/754623/Detailed-Explanation
    private static int minNumberOperations( int[] target ) {
        int totalOperations = target[0];

        for (int i = 1; i < target.length; ++i) {
            if (target[i] > target[i - 1]) {
                totalOperations += target[i] - target[i - 1];
            }
        }

        return totalOperations;
    }
}
