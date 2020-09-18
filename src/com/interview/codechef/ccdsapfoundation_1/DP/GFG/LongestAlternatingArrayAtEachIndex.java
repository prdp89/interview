package com.interview.codechef.ccdsapfoundation_1.DP.GFG;

public class LongestAlternatingArrayAtEachIndex {

    //https://www.geeksforgeeks.org/longest-alternating-positive-negative-subarray-starting-every-index/
    //https://www.codechef.com/problems/ALTARAY
    public static void main( String[] args ) {
        int a[] = {-5, -1, -1, 2, -2, -3};
        longestAlternating(a, 6);
    }

    /*
    Observe that when a[i] and a[i+1] have opposite signs,
    count[i] will be 1 more than count[i+1].

    Otherwise when they have same sign count[i] will be 1.
     */
    private static void longestAlternating( int arr[], int n ) {

        int[] count = new int[n];

        // Fill count[] from end.
        count[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] * arr[i + 1] < 0)
                count[i] = count[i + 1] + 1;
            else
                count[i] = 1;
        }

        // Print result
        for (int i = 0; i < n; i++)
            System.out.print(count[i] + " ");
    }
}
