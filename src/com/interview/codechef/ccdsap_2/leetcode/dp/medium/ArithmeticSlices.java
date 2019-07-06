package com.interview.codechef.ccdsap_2.leetcode.dp.medium;

//https://leetcode.com/problems/arithmetic-slices
public class ArithmeticSlices {

    private static int ways = 0;

    public static void main( String[] args ) {
        int[] arr = {1, 2, 3, 8, 9, 10};

        /*recurse(arr, 0, arr.length - 1);

        System.out.println(ways);*/

        System.out.println(totalSlices(0, arr));
    }

    //failing few test cases. almost solved it.
    private static int recurse( int[] arr, int i, int length ) {

        if (i == length - 1)
            return 0;

        int d = arr[i + 1] - arr[i];

        int j = i + 1, index = 1;

        while (j <= length - 1) {
            if (arr[j + 1] - arr[j] == d && index > 2) {
                ways++;
            } else {
                index = 0;
            }

            index++;
            j++;
        }

        return recurse(arr, i + 1, length);
    }

    private static int totalSlices( int i, int[] a ) {

        if (a.length < 3)
            return 0;

        if (a.length - i < 3)
            return 0;

        int j = i + 2;
        int count = 0;

        //a[i] - a[i + 1] : 'd' part of my logic above
        while ((i < a.length - 2 && j < a.length) && (a[i] - a[i + 1]) == (a[j - 1] - a[j])) {
            count++;
            j++;
        }

        //recurse on next i to generate next subsets eg. {1...N} then {2...N}
        return count + totalSlices(i + 1, a);
    }
}