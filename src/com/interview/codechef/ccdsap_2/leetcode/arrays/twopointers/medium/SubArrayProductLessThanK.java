package com.interview.codechef.ccdsap_2.leetcode.arrays.twopointers.medium;

public class SubArrayProductLessThanK {

    //https://www.geeksforgeeks.org/count-subsequences-product-less-k/
    //https://leetcode.com/problems/subarray-product-less-than-k/
    public static void main( String[] args ) {
        System.out.println(numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
    }

    //this solution uses sliding window technique
    private static int numSubarrayProductLessThanK( int[] nums, int k ) {
        if (k == 0) return 0;
        int cnt = 0;
        int pro = 1;

        for (int i = 0, j = 0; j < nums.length; j++) {
            pro *= nums[j];

            while (i <= j && pro >= k) {
                pro /= nums[i++];
            }

            cnt += j - i + 1;
        }
        return cnt;
    }
}
