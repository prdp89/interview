package com.interview.leetcode.Arrays.sort;

import java.util.Arrays;

public class PreviousPermutation {

    //https://leetcode.com/problems/previous-permutation-with-one-swap/
    public static void main( String[] args ) {
        int[] ar = {3, 2, 1};
        System.out.println(Arrays.toString(prevPermOpt1(ar)));
    }

    //Runtime: 0 ms, faster than 100.00% of Jav
    private static int[] prevPermOpt1( int[] A ) {
        //If array is already sorted then it cannot have prev. permutation

        if (A.length == 1)
            return A;

        //Find the first one from right to left that breaks the law of decreasing, as the number to be exchanged on the left
        int left = A.length - 2;
        while (left >= 0) {
            if (A[left] > A[left + 1])
                break;
            left--;
        }

        if(left < 0)
            return A;

        //Find the first number from right to left that is less than the selected left, as the number to be exchanged on the right
        int right = A.length - 1;
        while (A[right] >= A[left])
            right--;

        //If the number on the right of the found number has the same number on the left, then the one on the left that is equivalent to it should be selected as the number to be exchanged on the right
        int rightValue = A[right]; //first time assigning the same, to start the loop
        while (A[right] == rightValue) {
            right--;
        }
        right++; //increment once to make it equals to first time equation

        //Now swap the left and right
        int temp = A[left];
        A[left] = A[right];
        A[right] = temp;

        return A;
    }
}
