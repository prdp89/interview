package com.interview.hackerrank.recursion.advance;

public class SplitArray {

    //https://codingbat.com/prob/p185204
    public static void main( String[] args ) {
        System.out.println(splitArray(new int[]{2, 2}));
    }

    private static boolean splitArray( int[] nums ) {
        return splitHelper(0, nums, 0, 0);
    }

    private static boolean splitHelper( int start, int[] nums, int groupSum1, int groupSum2 ) {

        if (start >= nums.length) {
            return groupSum1 == groupSum2;
        }

        if (splitHelper(start + 1, nums, groupSum1 + nums[start], groupSum2))
            return true;

        if (splitHelper(start + 1, nums, groupSum1, groupSum2 + nums[start]))
            return true;

        return false;
    }
}
