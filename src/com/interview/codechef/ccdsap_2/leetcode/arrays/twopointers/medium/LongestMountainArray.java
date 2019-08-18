package com.interview.codechef.ccdsap_2.leetcode.arrays.twopointers.medium;

import java.util.Arrays;

public class LongestMountainArray {

    //https://leetcode.com/problems/longest-mountain-in-array/
    //This problem is variation of 2-pass Shortest Distance to a Character -> ShortestDistanceCharacter
    public static void main( String[] args ) {
        // int[] arr = {2, 1, 4, 7, 3, 2, 5};

        //int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        int[] arr = {0, 2, 2};

        //int[] arr = {0, 1, 2, 3, 4, 5, 4, 3, 2, 1, 0};

        //findPeakArrayTry(arr);

        System.out.println(longestMountain(arr));
    }

    //able to pass max 47/72 test cases :(
    private static void findPeakArrayTry( int[] arr ) {
        int peakIndex = peakIndexInMountainArray_3(arr);
        int left = peakIndex - 1;
        int right = peakIndex + 1;

        if (arr.length < 3 || peakIndex <= 0 || peakIndex == arr.length - 1) {
            System.out.println(0);
            return;
        }
        int peaks = 1;

        int temp = peakIndex;
        int leftPeak = 0;
        while (right < arr.length && arr[right] < arr[temp]) {
            leftPeak++;
            right++;
            temp++;
        }

        temp = peakIndex;
        int rightPeak = 0;

        while (left >= 0 && arr[left] < arr[temp]) {
            rightPeak++;
            left--;
            temp--;
        }

        System.out.println(leftPeak != rightPeak ? 0 : leftPeak + rightPeak + 1);
    }

    private static int peakIndexInMountainArray_3( int[] A ) {
        int l = 0, r = A.length - 1, m;

        while (l < r) {

            m = (l + r) / 2;

            //low is at-least our answer
            if (A[m] < A[m + 1])
                l = m + 1;
            else
                r = m;
        }

        return l;
    }

    private static int longestMountain( int[] A ) {

        if (A.length < 3) return 0;

        int[] increase = new int[A.length];
        int[] decrease = new int[A.length];

        Arrays.fill(increase, 1);
        Arrays.fill(decrease, 1);

        //if next is greater than previous, increase the current hill by previous + 1
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) increase[i] = increase[i - 1] + 1;
        }

        for (int i = A.length - 2; i >= 0; i--) {
            if (A[i] > A[i + 1]) decrease[i] = decrease[i + 1] + 1;
        }

        int res = Integer.MIN_VALUE;
        for (int i = 1; i < A.length - 1; i++) {

            //if we got a hill that is greater than previous and next so total = prev + next + 1(for current hill)
            if (A[i] > A[i - 1] && A[i] > A[i + 1]) {
                res = Math.max(res, increase[i - 1] + decrease[i + 1] + 1);
            }
        }
        return res == Integer.MIN_VALUE ? 0 : res;
    }
}
