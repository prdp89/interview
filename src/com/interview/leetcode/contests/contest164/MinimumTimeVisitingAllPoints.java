package com.interview.leetcode.contests.contest164;

public class MinimumTimeVisitingAllPoints {

    //https://leetcode.com/contest/weekly-contest-164/problems/minimum-time-visiting-all-points/
    public static void main( String[] args ) {

       /* int[][] arr = {
                {1, 1},
                {3, 4},
                {-1, 0}
        };*/

        int[][] arr = {
                {3, 2},
                {-2, 2}
        };

        System.out.println(minTimeToVisitAllPoints(arr));
    }

    //almost think of it, but got a ref here: https://leetcode.com/problems/minimum-time-visiting-all-points/discuss/436250/JavaPython-3-6-liner-and-1-liner-w-brief-explanation-ans-analysis.
    private static int minTimeToVisitAllPoints( int[][] points ) {
        int ans = 0;
        for (int i = 1; i < points.length; ++i) {
            int[] cur = points[i], prev = points[i - 1];
            ans += Math.max(Math.abs(cur[0] - prev[0]), Math.abs(cur[1] - prev[1]));
        }
        return ans;
    }
}
