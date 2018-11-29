package com.interview.hackerrank.recursion.advance;

public class Split5And3 {

    //https://codingbat.com/prob/p168295
    public static void main( String[] args ) {
        System.out.println(split53(new int[]{1, 1}));
    }

    private static boolean split53( int[] nums ) {
        return split53Helper(0, nums, 0, 0);
    }

    private static boolean split53Helper( int start, int[] nums, int mult5, int mult3 ) {

        //sum of both group must be same
        if (start >= nums.length)
            return mult5 == mult3;

        //each number should be multiple of 5
        if (nums[start] % 5 == 0)
            return split53Helper(start + 1, nums, mult5 + nums[start], mult3);

        //each number should be multiple of 3
        if (nums[start] % 3 == 0)
            return split53Helper(start + 1, nums, mult5, mult3 + nums[start]);

        //divide into groups of multiple of 5
        if (split53Helper(start + 1, nums, mult5 + nums[start], mult3))
            return true;

        //divide into groups of multiple of 3
        if (split53Helper(start + 1, nums, mult5, mult3 + nums[start]))
            return true;

        return false;
    }
}
