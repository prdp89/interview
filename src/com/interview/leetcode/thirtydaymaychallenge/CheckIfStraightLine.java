package com.interview.leetcode.thirtydaymaychallenge;

public class CheckIfStraightLine {

    //https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3323/
    public static void main( String[] args ) {
        /*int[][] coord = {
                {1, 2},
                {2, 3},
                {3, 4},
                {4, 5},
                {5, 6},
                {6, 7}
        };*/

        int[][] coord = {
                {1, 1},
                {2, 2},
                {3, 4},
                {4, 5},
                {5, 6},
                {7, 7}
        };

        System.out.println(checkStraightLine(coord));
    }

    private static boolean checkStraightLine( int[][] coordinates ) {

        for (int i = 0; i < coordinates.length - 3; i++) {

            int[] c = coordinates[i];
            int[] c1 = coordinates[i + 1];
            int[] c2 = coordinates[i + 2];

            if (!check(c[0], c[1], c1[0], c1[1], c2[0], c2[1]))
                return false;
        }

        return true;
    }

    private static boolean check( int x1, int y1, int x2, int y2, int x3, int y3 ) {
        if ((x2 - x1) == 0)
            return false;

        int first = (y2 - y1) / (x2 - x1);
        int second = (y3 - y1) / (x3 - x1);

        return (x3 - x1) != 0 && first == second;

    }
}
