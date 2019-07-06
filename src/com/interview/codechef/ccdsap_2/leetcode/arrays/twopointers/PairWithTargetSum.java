package com.interview.codechef.ccdsap_2.leetcode.arrays.twopointers;

import java.util.Arrays;
import java.util.HashSet;

public class PairWithTargetSum {

    //https://www.geeksforgeeks.org/given-an-array-a-and-a-number-x-check-for-pair-in-a-with-sum-as-x/
    public static void main( String[] args ) {

    }

    //Time: O(N Log N)
    private static boolean hasArrayTwoCandidates( int A[],
                                                  int arr_size, int sum ) {
        int l, r;

        /* Sort the elements */
        Arrays.sort(A);

        /* Now look for the two candidates
        in the sorted array*/
        l = 0;
        r = arr_size - 1;

        while (l < r) {

            if (A[l] + A[r] == sum)
                return true;
            else if (A[l] + A[r] < sum)
                l++;
            else // A[i] + A[j] > sum
                r--;
        }
        return false;
    }

    //Time : O ( N )
    private static void printpairs( int arr[], int sum ) {

        HashSet<Integer> s = new HashSet<>();

        for (int anArr : arr) {

            int temp = sum - anArr;

            if (s.contains(temp)) {
                System.out.println("Pair with given sum " +
                        sum + " is (" + anArr +
                        ", " + temp + ")");
            }

            s.add(anArr);
        }
    }
}
