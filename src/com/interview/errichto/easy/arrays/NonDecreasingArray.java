package com.interview.errichto.easy.arrays;

public class NonDecreasingArray {

    //https://leetcode.com/problems/non-decreasing-array/
    public static void main( String[] args ) {
        System.out.println(checkPossibilityOptimal(new int[]{4, 2, 3}));
    }

    private static boolean checkPossibilityOptimal( int[] a ) {
        int modified = 0;
        for (int i = 1, prev = a[0]; i < a.length; i++) {

            //if number in incorrect order
            if (a[i] < prev) {

                //if more than one is incorrect
                if (modified++ > 0)
                    return false;

                //if i-2 is greater than current
                if (i - 2 >= 0 && a[i - 2] > a[i])
                    continue;
            }

            prev = a[i];
        }
        return true;
    }

    //285/350 test passed
    public boolean checkPossibility( int[] nums ) {

        if (nums.length == 1)
            return true;


        if (nums.length == 2)
            return nums[0] > nums[1];

        int count = 0, prev = nums[0];

        for (int i = 1; i < nums.length; i++) {

            if (count > 1)
                return false;

            if (nums[i] < prev) {
                count++;
                prev = nums[i] + 1;
            } else
                prev = nums[i];
        }

        return count == 1;
    }
}
