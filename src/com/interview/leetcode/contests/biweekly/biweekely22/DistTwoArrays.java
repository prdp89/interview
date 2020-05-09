package com.interview.leetcode.contests.biweekly.biweekely22;

import java.util.TreeSet;

public class DistTwoArrays {

    //https://leetcode.com/contest/biweekly-contest-22/problems/find-the-distance-value-between-two-arrays/
    public static void main( String[] args ) {
        int[] arr = {2, 1, 100, 3}, arr1 = {-5, -2, 10, -3, 7};
        int d = 6;

        System.out.println(findTheDistanceValue(arr, arr1, d));
        System.out.println(findTheDistanceValueOptimal(arr, arr1, d));
    }

    //Runtime: 3 ms, faster than 76.69% of Java
    private static int findTheDistanceValue( int[] arr1, int[] arr2, int d ) {
        int count = 0;
        for (int i = 0; i < arr1.length; i++) {

            boolean isTrue = true;
            for (int j = 0; j < arr2.length; j++) {
                if (Math.abs(arr1[i] - arr2[j]) <= d) {
                    isTrue = false;
                    break;
                }
            }

            if (isTrue)
                count++;
        }

        return count;
    }

    //Runtime: 3 ms, faster than 76.69% of Java
    private static int findTheDistanceValueOptimal( int[] arr1, int[] arr2, int d ) {
        TreeSet<Integer> set = new TreeSet<>();

        // Arrays.sort(arr1);
        for (int num : arr2)
            set.add(num);

        int res = 0;
        for (int num : arr1) {

            int diff;

            Integer high = set.ceiling(num);
            Integer low = set.floor(num);

            if (high == null) {
                diff = Math.abs(low - num);
            } else if (low == null) {
                diff = Math.abs(high - num);
            } else {
                diff = Math.min(high - num, num - low);
            }

            if (diff > d)
                res++;
        }

        return res;
    }
}
