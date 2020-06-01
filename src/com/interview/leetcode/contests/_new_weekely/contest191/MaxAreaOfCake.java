package com.interview.leetcode.contests._new_weekely.contest191;

import java.util.Arrays;

public class MaxAreaOfCake {

    //https://leetcode.com/contest/weekly-contest-191/problems/maximum-area-of-a-piece-of-cake-after-horizontal-and-vertical-cuts/
    public static void main( String[] args ) {
        System.out.println(maxArea(5, 4, new int[]{1, 2, 4}, new int[]{1, 3}));
    }

    private static int maxArea( int h, int w, int[] horizontalCuts, int[] verticalCuts ) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);

        int maxDiffH = horizontalCuts[0];
        int maxDiffV = verticalCuts[0];

        for (int i = 1; i < horizontalCuts.length; i++) {
            maxDiffH = Math.max(maxDiffH, horizontalCuts[i] - horizontalCuts[i - 1]);
        }

        maxDiffH = Math.max(maxDiffH, h - horizontalCuts[horizontalCuts.length - 1]);

        for (int i = 1; i < verticalCuts.length; i++) {
            maxDiffV = Math.max(maxDiffV, verticalCuts[i] - verticalCuts[i - 1]);
        }

        maxDiffV = Math.max(maxDiffV, w - verticalCuts[verticalCuts.length - 1]);


        return (int) ((long) maxDiffH * maxDiffV % 1000000007);
    }
}
