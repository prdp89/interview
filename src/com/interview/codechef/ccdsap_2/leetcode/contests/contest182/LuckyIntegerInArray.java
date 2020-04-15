package com.interview.codechef.ccdsap_2.leetcode.contests.contest182;

import java.util.Arrays;

public class LuckyIntegerInArray {

    //https://leetcode.com/contest/weekly-contest-182/problems/find-lucky-integer-in-an-array/
    public static void main( String[] args ) {
        int[] arr = {5};

        System.out.println(findLucky(arr));
    }

    private static int findLucky( int[] arr ) {
        int res[] = new int[501];

        Arrays.fill(res, -1);

        for (int i = 0; i < arr.length; i++) {
            res[arr[i]]++;
        }

        for (int i = res.length - 1; i >= 0; i--) {

            if (res[i] != -1 && i == res[i] + 1)
                return i;
        }

        return -1;
    }
}
