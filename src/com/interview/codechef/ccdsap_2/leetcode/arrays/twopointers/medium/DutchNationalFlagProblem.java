package com.interview.codechef.ccdsap_2.leetcode.arrays.twopointers.medium;

import java.util.Arrays;

public class DutchNationalFlagProblem {

    //https://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/
    public static void main( String[] args ) {
        int[] arr = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        sort012(arr, arr.length);

        System.out.println(Arrays.toString(arr));
    }

    private static void sort012( int a[], int arr_size ) {

        int lo = 0;

        int hi = arr_size - 1;
        int mid = 0, temp;

        while (mid <= hi) {

            //There are three possibilities: a[Mid] is (0) red, (1) white or (2) blue.
            switch (a[mid]) {

                //a[Mid] is red, swap a[Lo] and a[Mid]; Lo++; Mid++
                case 0: {
                    temp = a[lo];
                    a[lo] = a[mid];
                    a[mid] = temp;
                    lo++;
                    mid++;
                    break;
                }

                //Case (1) a[Mid] is white, Mid++
                case 1:
                    mid++;
                    break;

                //Case (2) a[Mid] is blue, swap a[Mid] and a[Hi]; Hi--
                case 2: {
                    temp = a[mid];
                    a[mid] = a[hi];
                    a[hi] = temp;
                    hi--; ///why not mid++ bcz that element could be zero as well..
                    break;
                }
            }
        }
    }

    //More optimized solution...
    /*
    void sortArr(int arr[], int n)
{
    int i, cnt0 = 0, cnt1 = 0, cnt2 = 0;

    // Count the number of 0s, 1s and 2s in the array
    for (i = 0; i < n; i++) {
        switch (arr[i]) {
        case 0:
            cnt0++;
            break;
        case 1:
            cnt1++;
            break;
        case 2:
            cnt2++;
            break;
        }
    }

    // Update the array
    i = 0;

    // Store all the 0s in the beginning
    while (cnt0 > 0) {
        arr[i++] = 0;
        cnt0--;
    }

    // Then all the 1s
    while (cnt1 > 0) {
        arr[i++] = 1;
        cnt1--;
    }

    // Finally all the 2s
    while (cnt2 > 0) {
        arr[i++] = 2;
        cnt2--;
    }

    // Print the sorted array
    printArr(arr, n);
}
     */
}
