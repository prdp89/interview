package com.interview.leetcode.dp;

import java.util.Arrays;

public class StoneGame {

    //https://leetcode.com/problems/stone-game/
    public static void main( String[] args ) {
        int[] arr = {5, 3, 4, 5};
        int l = 0, r = arr.length - 1;

        int[][] memo = new int[arr.length][arr.length];

        for (int[] mem : memo)
            Arrays.fill(mem, Integer.MIN_VALUE);

        System.out.println(gameOnIntTD(arr, l, r, true, memo) >= 0);
    }

    //Also read : OptimalGameStrategy : com.interview.codingblocks.week9DynamicProgrammming

    /*
    Talking about the Recursive Solution -> Consider a boolean variable that will decide if the turn is of Alex or Lee.

    If it is Alex's Turn then we will find the max number of stones we can get by either
    consuming the first pile from the piles or by consuming the last pile.

    If it is Lee's turn then we will find the min number of stones we can get by decreasing the amount of the Alex's score.
     */
    //https://leetcode.com/problems/stone-game/discuss/261718/Step-by-Step-Recursive-TopDown-BottomUp-and-BottomUp-using-O(n)-space-in-Java

    //Runtime: 11 ms, faster than 27.29% of Java
    private static int gameOnIntTD( int[] piles, int si, int ei, boolean turn, int[][] strg ) {
        if (si > ei) {
            return 0;
        }

        // If the Recursion has Calculated the Answer
        if (strg[si][ei] > 0) {
            return strg[si][ei]; // return that Stored Answer
        }

        if (turn) { // If it is Alex's Turn
            int rr1 = gameOnIntTD(piles, si + 1, ei, false, strg) + piles[si]; // Same as Above
            int rr2 = gameOnIntTD(piles, si, ei - 1, false, strg) + piles[ei]; // Same as Above
            strg[si][ei] = Math.max(rr1, rr2); // Storing the max ans at particular indices
            return strg[si][ei];
        }

        // If it is Lee's Turn
        int rr1 = gameOnIntTD(piles, si + 1, ei, true, strg) - piles[si]; //Same logic as above
        int rr2 = gameOnIntTD(piles, si, ei - 1, true, strg) - piles[ei];//Same logic as above
        strg[si][ei] = Math.min(rr1, rr2); //Storing the answer at particular indices

        return strg[si][ei];
    }
}
