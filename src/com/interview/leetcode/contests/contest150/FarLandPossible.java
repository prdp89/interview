package com.interview.leetcode.contests.contest150;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FarLandPossible {

    //https://leetcode.com/contest/weekly-contest-150/problems/as-far-from-land-as-possible/
    //THis question is related to BFS graph
    public static void main( String[] args ) {
        int[][] grid = {{1, 0, 1},
                {0, 0, 0},
                {1, 0, 1}};

        System.out.println(maxDistanceBruteForce(grid));

        bfsSolution(grid);
    }

    /*
    1. Push all land cells into the queue.
    2. BFS from the land cells, the traverse level is exactly the manhattan distance.
     */
    //ref : https://leetcode.com/problems/as-far-from-land-as-possible/discuss/396770/C%2B%2B-BFS-Solution-O(m*n)-Time-O(1)-Space.
    private static void bfsSolution( int[][] grid ) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<Point> lands = new LinkedList<Point>();

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (grid[i][j] == 1) {
                    grid[i][j] = -1;
                    lands.offer(new Point(i, j));
                }

        int dist = 1;
        int level_len = lands.size();

        while (!lands.isEmpty()) {

            Point node = lands.poll();
            level_len--;

            int i = node.x;
            int j = node.y;

            //checking in Top, Bottom, Left, Right Direction
            if (i + 1 < m && grid[i + 1][j] == 0) {
                lands.offer(new Point(i + 1, j));
                grid[i + 1][j] = dist;
            }

            if (i - 1 >= 0 && grid[i - 1][j] == 0) {
                lands.offer(new Point(i - 1, j));
                grid[i - 1][j] = dist;
            }

            if (j + 1 < n && grid[i][j + 1] == 0) {
                lands.offer(new Point(i, j + 1));
                grid[i][j + 1] = dist;
            }

            if (j - 1 >= 0 && grid[i][j - 1] == 0) {
                lands.offer(new Point(i, j - 1));
                grid[i][j - 1] = dist;
            }

            //if land array is empty; fill it with default size..
            if (level_len == 0) {
                level_len = lands.size();
                dist++;
            }
        }

        int max_dist = 0;

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (grid[i][j] != -1) //bcz -1 denotes to Land and we are finding a water cell whose distance is Maximized
                    max_dist = Math.max(max_dist, grid[i][j]);

        if (max_dist == 0)
            max_dist = -1;

        System.out.println(max_dist);
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
