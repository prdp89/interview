package com.interview.codechef.ccdsap_2.leetcode.arrays.mergeintervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    //https://leetcode.com/problems/merge-intervals/
    public static void main( String[] args ) {
        merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
    }

    public static int[][] merge( int[][] intervals ) {
        List<int[]> res = new ArrayList<>();
        if (intervals.length == 0) return res.toArray(new int[0][]);

        //Sort by ascending starting point using an anonymous Comparator
        Arrays.sort(intervals, ( a, b ) -> a[0] - b[0]);

        int start = intervals[0][0];
        int end = intervals[0][1];

        //on first iteration res.add will work
        //on second iteration: start = first element, end = second element
        //Then compare if Next start is less than previous end; in that case extend the End to overlap
        for (int[] i : intervals) {

            if (i[0] <= end) {
                end = Math.max(end, i[1]);
            } else {
                res.add(new int[]{start, end});
                start = i[0];
                end = i[1];
            }
        }

        res.add(new int[]{start, end});
        return res.toArray(new int[0][]);
    }
}
