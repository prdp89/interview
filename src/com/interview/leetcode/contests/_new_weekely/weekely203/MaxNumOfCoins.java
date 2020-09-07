package com.interview.leetcode.contests._new_weekely.weekely203;

import java.util.Arrays;

public class MaxNumOfCoins {

    //https://leetcode.com/problems/maximum-number-of-coins-you-can-get/
    public static void main( String[] args ) {
        int[] arr = {2, 4, 1, 2, 7, 8};
        System.out.println(maxCoins(arr));
    }

    private static int maxCoins( int[] piles ) {
        Arrays.sort(piles);

        //Three player are playing a game : Alice, You and Bob
        int res = 0;

        //j helps in picking 2nd coin out of 3 choosen.
        for (int i = 0, j = piles.length - 2; i < piles.length / 3; i++, j -= 2) {
            res += piles[j];
        }

        return res;
    }
}
