package com.interview.codechef.ccdsap_2.leetcode.contests.contest141;

public class DuplicateZeros {

    //https://leetcode.com/contest/weekly-contest-141/problems/duplicate-zeros/

    //This problem asks to duplicate zero whenerver a zero occurs in an array.
    //After duplicating that zero move arrray index to duplicate next unique zero.
    public static void main( String[] args ) {
        int[] arr = {1, 0, 2, 3, 0, 4, 5, 0};

        methodON2(arr);
    }

    private static void methodON2( int[] arr ) {

        int i = 0;
        while (i < arr.length) {

            if (arr[i] == 0 && i < arr.length - 1) {

                //move elements to the right by replacing Nth with N - 1 element
                for (int j = arr.length - 1; j > i; j--) {
                    arr[j] = arr[j - 1];
                }

                //set next of zeroth element to zero
                arr[i + 1] = 0;

                //update the index
                i++;
            }
            i++;
        }
    }
}
