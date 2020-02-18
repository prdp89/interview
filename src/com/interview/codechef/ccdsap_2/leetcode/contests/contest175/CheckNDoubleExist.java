package com.interview.codechef.ccdsap_2.leetcode.contests.contest175;

import java.util.HashSet;

public class CheckNDoubleExist {

    //https://leetcode.com/contest/weekly-contest-175/problems/check-if-n-and-its-double-exist/
    public static void main( String[] args ) {
        int[] arr = {-2, 0, 10, -19, 4, 6, -8};
        System.out.println(solve(arr));
    }

    private static boolean solve( int[] arr ) {

        HashSet<Integer> set = new HashSet<>();

        int zeroCount = 0;
        for (int item : arr) {
            set.add(item);

            if (item == 0)
                zeroCount++;
        }

        if (zeroCount > 1)
            return true;

        for (int item : arr) {
            if (item != 0 && set.contains(item * 2))
                return true;
        }

        return false;
    }
}
