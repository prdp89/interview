package com.interview.codechef.ccdsap_2.leetcode.arrays.twopointers.medium;

import java.util.Arrays;

public class ThreeSumClosest {

    //https://leetcode.com/problems/3sum-closest
    public static void main( String[] args ) {
        int[] arr = {-1, 2, 1, -4};
        int target = 1;

        System.out.println(solveTry(arr, target));
    }

    //similar to ThreeSumSmallerThanTarget
    private static int solveTry( int[] arr, int target ) {

        Arrays.sort(arr);

        int res = arr[0] + arr[1] + arr[arr.length - 1];
        for (int i = 0; i < arr.length; i++) {

            int j = i + 1;
            int k = arr.length - 1;

            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];

                if (sum > target) {
                    k--;
                } else {
                    j++;
                }

                //checking what is smaller : Sum - Target or
                    if (Math.abs(target - sum) < Math.abs(target - res)) {
                    res = sum;
                }
            }
        }

        return res;
    }
}
