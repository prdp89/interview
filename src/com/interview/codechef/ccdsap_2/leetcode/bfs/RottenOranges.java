package com.interview.codechef.ccdsap_2.leetcode.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

    //https://leetcode.com/problems/rotting-oranges/
    public static void main( String[] args ) {
       /* int[][] grid = {{2, 1, 1},
                {0, 1, 1},
                {1, 0, 1}};*/ //op -1

        int[][] grid = {{0, 2}};

        System.out.println(bfsSolution(grid));
    }

    //solved in  3 ms, faster than 32.07% of Java online
    //almost same as FarLandPossible in com.interview.codechef.ccdsap_2.leetcode.contests.contest150

    private static int bfsSolution( int[][] grid ) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<Point> rotten = new LinkedList<Point>();

        int freshOrange = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    grid[i][j] = -1;
                    rotten.offer(new Point(i, j));
                } else if (grid[i][j] == 1)
                    freshOrange++;
            }
        }

        if (freshOrange == 0)
            return 0;

        int dist = -1;
        int level_len = rotten.size();
        int count = -1;

        while (!rotten.isEmpty()) {

            Point node = rotten.poll();
            level_len--;

            int i = node.x;
            int j = node.y;

            //checking in Top, Bottom, Left, Right Direction
            if (i + 1 < m && grid[i + 1][j] == 1) {
                rotten.offer(new Point(i + 1, j));
                grid[i + 1][j] = dist;
            }

            if (i - 1 >= 0 && grid[i - 1][j] == 1) {
                rotten.offer(new Point(i - 1, j));
                grid[i - 1][j] = dist;
            }

            if (j + 1 < n && grid[i][j + 1] == 1) {
                rotten.offer(new Point(i, j + 1));
                grid[i][j + 1] = dist;
            }

            if (j - 1 >= 0 && grid[i][j - 1] == 1) {
                rotten.offer(new Point(i, j - 1));
                grid[i][j - 1] = dist;
            }

            //if land array is empty; fill it with default size..
            if (level_len == 0) {
                level_len = rotten.size();
                count++;
            }
        }

        for (int[] x : grid) {
            for (int y : x) {
                if (y == 1)
                    return -1;
            }
        }

        return count;
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
