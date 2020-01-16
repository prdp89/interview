package com.interview.codechef.ccdsap_2.leetcode.binarysearch.medium;

public class MissingElementInSortedArray {

    //https://stackoverflow.com/questions/11385896/find-the-first-missing-number-in-a-sorted-list

    //one good solution in  : pramp.com video 2nd half

    public static void main( String[] args ) {
        int[] arr = {0, 2, 3, 4}; //op = 1

        //System.out.println(missingNumber(arr, arr.length));

        System.out.println(missingNumberPramp(arr));
    }

    //Time : O(N)
    private static int missingNumberPramp( int[] arr ) {

        int n = arr.length;
        int temp;

        for (int i = 0; i < n; i++) {

            temp = arr[i];
            while (temp < n && arr[temp] != temp) {
                int swap = arr[temp];
                arr[temp] = temp;
                temp = swap;
            }
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] != i)
                return i;
        }

        return n;
    }

    //Complexity O ( Log N )
    private static int missingNumber( int a[], int size ) {
        int lo = 0;
        int hi = size - 1;

        // TODO: Use this if we need to ensure we start at 0!
        //if(a[0] != 0) { return 0; }

        // All elements present? If so, return next largest number.
        if ((hi - lo) == (a[hi] - a[lo])) {
            return a[hi] + 1;
        }

        // While 2 or more elements to left to consider...
        while ((hi - lo) >= 2) {

            int mid = (lo + hi) / 2;

            if ((mid - lo) != (a[mid] - a[lo])) {  // Explore left-hand side
                hi = mid;
            } else {  // Explore right hand side
                lo = mid + 1;
            }
        }

        // Return missing value from the two candidates remaining...
        return (lo == (a[lo] - a[0])) ? hi + a[0] : lo + a[0];
    }
}
