package com.interview.leetcode.contests.contest146;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class EquivalentDominoPairs {

    //https://leetcode.com/contest/weekly-contest-146/problems/number-of-equivalent-domino-pairs/
    public static void main( String[] args ) {
        int[][] dominoes = {{1, 2}, {2, 1}, {3, 4}, {5, 6}};
        //System.out.println(numEquivDominoPairs(dominoes));
        System.out.println(numEquivDominoPairsOptimal(dominoes));
    }

    private static int numEquivDominoPairsOptimal( int[][] dominoes ) {

        Map<Integer, Integer> count = new HashMap<>();
        int res = 0;

        for (int[] d : dominoes) {
            int k = Math.min(d[0], d[1]) * 10 + Math.max(d[0], d[1]);
            count.put(k, count.getOrDefault(k, 0) + 1);
        }

        for (int v : count.values()) {
            res += v * (v - 1) / 2;
        }

        return res;
    }

    private static int numEquivDominoPairs( int[][] dominoes ) {

        int[] count = new int[20];

        for (int[] dominoe : dominoes) {

            int sum = 0;
            for (int aDominoe : dominoe) {
                sum += aDominoe;
            }

            count[sum]++;
        }

        //to get combination of n elements
        int total = 0;
        for (int aCount : count) {
            total += (aCount * (aCount - 1) / 2);
        }

        System.out.println(Arrays.toString(count));

        return total;
    }
}
