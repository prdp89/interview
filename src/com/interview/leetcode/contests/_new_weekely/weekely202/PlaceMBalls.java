package com.interview.leetcode.contests._new_weekely.weekely202;

import java.util.Arrays;

public class PlaceMBalls {

    //https://leetcode.com/problems/magnetic-force-between-two-balls/
    public static void main( String[] args ) {
        int[] pos = {1, 2, 3, 4, 7};
        int m = 3;

        System.out.println(maxDistance(pos, m));
    }

    //Runtime: 47 ms, faster than 83.33% of Java
    private static int maxDistance( int[] position, int m ) {
        Arrays.sort(position);

        int hi = 1000000000;
        int lo = 1;

        /*
        Consider, when we have lo = 1 and hi = 2.
        If I used, int mi = (lo + hi) / 2; mi = 1
        If I used, int mi = (lo + hi + 1) / 2; mi = 2

        Now since, lo = mi, we will keep falling back to lo = 1 and hi = 2(Hence TLE), if I used first version.

        General rule of thumb I use:
        If we are doing lo = mi, and hi = mi-1, use 2nd version.
        If we are doing hi = mi, lo = mi + 1, use 1st version.
         */
        while (lo < hi) {
            int mi = (lo + hi + 1) / 2; // Read comments if you wanna know why +1 was done.
            if (check(position, mi, m)) {
                lo = mi;
            } else {
                hi = mi - 1;
            }
        }

        return lo;
    }

    /*
   * Returns whether we can put m balls so that maximum distance between any two balls not exceed max
   */
    private static boolean check( int[] positions, int mid, int balls ) {
        int count = 1;
        int last = positions[0];

        for (int i = 0; i < positions.length; i++) {
            if (positions[i] - last >= mid) {
                last = positions[i];
                count++;
            }
        }

        return count >= balls;
    }
}
