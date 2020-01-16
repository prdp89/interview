package com.interview.codechef.ccdsap_2.leetcode.arrays.twopointers.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SquareOfSortedArray {

    //https://leetcode.com/problems/squares-of-a-sorted-array/
    public static void main( String[] args ) {
        int[] arr = {-4, -1, 0, 3, 10};

        //System.out.println(Arrays.toString(solveBruteForce(arr)));

        System.out.println(Arrays.toString(sortedSquares(arr)));
    }

    //TIme : O ( N LOG N )
    private static int[] solveBruteForce( int[] arr ) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a));

        for (int anArr : arr) {
            pq.offer(anArr * anArr);
        }

        int i = 0;
        while (!pq.isEmpty()) {
            arr[i++] = pq.poll();
            //System.out.print(item + " ");
        }

        return arr;
    }

    //Using Two pointers : O ( N )
    private static int[] sortedSquares( int[] A ) {
        int n = A.length;
        int[] result = new int[n];

        int i = 0, j = n - 1;

        //Since array is already sorted in increasing order
        for (int p = n - 1; p >= 0; p--) {

            //start storing largest element at the last
            //Adjust pointers accordingly
            if (Math.abs(A[i]) > Math.abs(A[j])) {
                result[p] = A[i] * A[i];
                i++;
            } else {
                result[p] = A[j] * A[j];
                j--;
            }
        }
        return result;
    }
}
