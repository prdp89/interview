package com.interview.codechef.ccdsap_2.leetcode.dp.medium;

public class MaximumProductSubarray {

    //https://leetcode.com/problems/maximum-product-subarray/
    public static void main( String[] args ) {
        //maxProductSubArray(new int[]{2, 3, 2});

        System.out.println(maxProduct(new int[]{3, -1, 4}));
    }

    //faliing some test cases
    private static int maxProduct( int[] nums ) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int max = nums[0], sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (sum <= 0) {
                if (nums[i] < 0) {
                    sum *= nums[i];
                } else
                    sum = nums[i];
            } else {
                sum *= nums[i];
            }
            max = Math.max(max, sum);
        }
        return max;
    }

    public int maxProductOptimal( int[] A ) {
        if (A.length == 0) {
            return 0;
        }

        int maxherepre = A[0];
        int minherepre = A[0];
        int maxsofar = A[0];
        int maxhere, minhere;

        /*
        Due to negative number and property of multiply, we need max and min ends at i-1 in case negative number
        at i causes them swap. Therefore, we maintain two local optimal variables, update them in each iteration
        and the global maximum as well.
         */
        // {-2, 3, -4}
        //If we are index 1 of array, we choose either : -2 * 3  or 3 itself
        //Maxhere / Minhere : helping in handling negative use cases as well.
        for (int i = 1; i < A.length; i++) {

            maxhere = Math.max(Math.max(maxherepre * A[i], minherepre * A[i]), A[i]);

            minhere = Math.min(Math.min(maxherepre * A[i], minherepre * A[i]), A[i]);

            //global max. variable
            maxsofar = Math.max(maxhere, maxsofar);

            maxherepre = maxhere;
            minherepre = minhere;
        }
        return maxsofar;
    }
}
