package com.interview.hackerrank.recursion;

//https://codingbat.com/prob/p135988
public class Array11 {

    //https://codingbat.com/prob/p135988
    public static void main( String[] args ) {
        System.out.println(array11(new int[]{1, 2, 0, 0}, 0));
    }

    private static int array11( int[] nums, int index ) {

        if(index == nums.length )
            return 0;

        int sum = (nums[index] == 11 ? 1 : 0) + array11(nums, index +1);
        return sum;
    }
}
