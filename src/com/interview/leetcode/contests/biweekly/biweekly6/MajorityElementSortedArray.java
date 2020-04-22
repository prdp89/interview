package com.interview.leetcode.contests.biweekly.biweekly6;

public class MajorityElementSortedArray {

    //https://leetcode.com/contest/biweekly-contest-6/problems/check-if-a-number-is-majority-element-in-a-sorted-array/
    public static void main( String[] args ) {

        //in one go.... :)
        int[] arr = {10, 100, 101, 101};
        int target = 101;

        int length = arr.length, countTarget = 0;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == target)
                countTarget++;

            if (countTarget > (length / 2)) {
                System.out.println(true);
                return;
            }
        }

        System.out.println(countTarget > (length / 2));
    }
}
