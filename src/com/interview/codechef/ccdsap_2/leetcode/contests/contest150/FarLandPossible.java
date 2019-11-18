package com.interview.codechef.ccdsap_2.leetcode.contests.contest150;

import java.util.ArrayList;
import java.util.List;

public class FarLandPossible {

    //https://leetcode.com/contest/weekly-contest-150/problems/as-far-from-land-as-possible/
    //THis question is related to BFS graph
    public static void main( String[] args ) {
        int[][] grid = {{1, 0, 1},
                {0, 0, 0},
                {1, 0, 1}};

        System.out.println(maxDistanceBruteForce(grid));

        //optimal solution here:
        //https://leetcode.com/problems/as-far-from-land-as-possible/discuss/360996/A-very-typical-O(v)-BFS-JAVA-17-ms-faster-than-100.00
    }

    /*
    1 find all lands
    2 for each water point, check the nearest land
     */
    private static int maxDistanceBruteForce( int[][] grid ) {

        List<Point> lands = new ArrayList<>();
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 1) {
                    lands.add(new Point(i, j));
                }
            }
        }

        //if no land found or grid contains only land no water
        if (lands.size() == 0 || lands.size() == grid.length * grid[0].length) {
            return -1;
        }

        int maxMinDist = Integer.MIN_VALUE;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {

                //for each WATER spot check all the LANDS nearest to it
                if (grid[i][j] == 0) {
                    //answer will Max of all min distances.
                    maxMinDist = Math.max(maxMinDist, checkMinDist(lands, i, j));
                }
            }
        }

        return maxMinDist;
    }

    //finding the MIN land distance that is nearest to current Water spot
    private static int checkMinDist( List<Point> lands, int x, int y ) {
        int dist = Integer.MAX_VALUE;
        for (Point land : lands) {
            dist = Math.min(dist, Math.abs(land.x - x) + Math.abs(land.y - y));
        }

        return dist;
    }


    static class Point {
        public int x;
        public int y;

        public Point( int x, int y ) {
            this.x = x;
            this.y = y;
        }
    }
}
