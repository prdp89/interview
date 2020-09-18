package com.interview.codechef.ccdsapfoundation_1.slidingwindow;

public class LongestTurbulentArray {

    //https://leetcode.com/problems/longest-turbulent-subarray/

    public int maxTurbulenceSize( int[] A ) {
        int i = 0, max = 0, len = 0;

        while (i + 1 < A.length) {
            if ((i % 2 == 0) && A[i] < A[i + 1]) {
                len++;
            } else if ((i % 2 == 1) && A[i] > A[i + 1]) {
                len++;
            } else {
                len = 0;
            }
            i++;
            max = Math.max(max, len);
        }

        // or
        int i1 = 0, max1 = 0, len1 = 0;

        while (i1 + 1 < A.length) {
            if ((i1 % 2 == 0) && A[i1] > A[i1 + 1]) {
                len1++;
            } else if ((i1 % 2 == 1) && A[i1] < A[i1 + 1]) {
                len1++;
            } else {
                len1 = 0;
            }
            i1++;
            max1 = Math.max(max1, len1);
        }

        return Math.max(max, max1) + 1; //+1 for starting element zero index
    }
}
