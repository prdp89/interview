package com.interview.leetcode.dp.partiotining;

import java.util.Arrays;

public class AllocateMailBoxes {

    //https://leetcode.com/problems/allocate-mailboxes/
    public static void main( String[] args ) {
        int[] houses = {1, 4, 8, 10, 20};
        int k = 3;

        System.out.println(minDistance(houses, k));
    }

    //https://leetcode.com/problems/allocate-mailboxes/discuss/685321/Java-or-Heavily-Commented-or-Simple-solution

    //Runtime: 29 ms, faster than 100.00% of Java
    //This question follows pattern : PalindromicPartitioning : com.interview.leetcode.dp.grokkingdp.palindromepattern
    private static int minDistance( int[] houses, int mailboxes ) {
        Arrays.sort(houses);

        int[][] dp = new int[houses.length][mailboxes];
        for (int i = 0; i < houses.length; i++)
            Arrays.fill(dp[i], -1);

        return dfs(houses, dp, mailboxes, 0, 0);
    }

    private static int dfs( int[] houses, int[][] dp, int mailboxes, int index, int mailBox ) {

        if (index >= houses.length) {

            if (mailBox == mailboxes)
                return 0; //bcz we are calculating minimum

            return 10000000; //Integer.MAX_VALUE;
        }

        if (mailBox == mailboxes)
            return 10000000; //Integer.MAX_VALUE;

        if (dp[index][mailBox] != -1)
            return dp[index][mailBox];

        int res = 10000000;//Integer.MAX_VALUE;
        for (int i = index; i < houses.length; i++) {

            // Best way to place a mailbox between [i, pos] houses is to place at the median house
            int median = houses[(i + index) / 2];

            //calculate cost
            int cost = 0;
            for (int j = index; j <= i; j++) {
                cost += Math.abs(median - houses[j]);
            }

            //recurse
            res = Math.min(res, dfs(houses, dp, mailboxes, i + 1, mailBox + 1) + cost);

        }

        dp[index][mailBox] = res;

        return res;
    }
}
