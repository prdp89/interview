package com.interview.codechef.ccdsap_2.leetcode.binarysearch.medium;

import java.util.ArrayList;
import java.util.List;

public class KClosestElements {

    //https://leetcode.com/problems/find-k-closest-elements/
    //similar : https://www.geeksforgeeks.org/find-k-closest-elements-given-value/
    public static void main( String[] args ) {

        int[] arr = {12, 16, 22, 30, 35, 39, 42,
                45, 48, 50, 53, 55, 56};

        findClosestElements_ON(arr, 4, 35).forEach(System.out::println);
    }

    private static List<Integer> findClosestElements_ON( int[] arr, int k, int x ) {
        int lo = 0;
        int hi = arr.length - 1;

        while (hi - lo >= k) {

            //checking difference from Start or End with X;
            //Our Aim is to find Min. difference from X
            //We are moving low if difference is greater; otherwise move high if difference from high is greater.
            if (Math.abs(arr[lo] - x) > Math.abs(arr[hi] - x)) { //can work without ABS bcz array is sorted
                lo++;
            } else {
                hi--;
            }
        }

        List<Integer> result = new ArrayList<>(k);

        //finally low..high is set Min. difference from X
        for (int i = lo; i <= hi; i++) {
            result.add(arr[i]);
        }

        return result;
    }

    //good example of binary search
    private static List<Integer> findClosestElements_ON_LOGN( List<Integer> arr, int k, int x ) {
        int lo = 0, hi = arr.size() - k;

        while (lo < hi) {

            int mid = (lo + hi) / 2;

            if (x - arr.get(mid) > arr.get(mid + k) - x)
                lo = mid + 1;
            else
                hi = mid; //keeping high as mid bcz we may need MID same as SmallestLetterGreaterTarget
        }

        //finally LOW is set to Min element closest to K. Range will be {lo ------- lo + k}
        return arr.subList(lo, lo + k);
    }
}
