package com.interview.codechef.ccdsap_2.leetcode.arrays.twopointers.medium;

public class RemoveDuplicateSortedListII {

    //https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
    public static void main( String[] args ) {
        //int[] arr = {1, 1, 1, 2, 2, 3};
        int[] arr = {0, 0, 1, 1, 1, 1, 2, 3, 3};

        solveTry(arr);
    }

    //solved in one attempt
    private static int solveTry( int[] arr ) {

        int count = 1, numCount = 0;
        for (int i = 1; i < arr.length; i++) {

            if (arr[i - 1] == arr[i]) {
                numCount += 2;
                if (numCount <= 2)
                    arr[count++] = arr[i];
            } else {
                numCount = 0;
                arr[count++] = arr[i];
            }
        }

        return count;
    }
}