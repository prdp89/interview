package com.interview.codechef.ccdsap_2.leetcode.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {

    //almost same as FarLandPossible
    //https://leetcode.com/problems/number-of-islands/
    public static void main( String[] args ) {
       /* char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };*/ //op : 1

        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        bfsSolution(grid);
    }

    //solved with little help : https://leetcode.com/problems/number-of-islands/discuss/56589/C%2B%2B-BFSDFS
    //Runtime: 5 ms, faster than 14.88% of Java
    private static void bfsSolution( char[][] grid ) {
        int m = grid.length;

        if (grid.length == 0)
            System.out.println('0');

        int n = grid[0].length;

        Queue<Point> lands = new LinkedList<Point>();

        char water = '0';
        int isLandCount = 0;
        int level_len = lands.size();

        for (int k = 0; k < m; k++) {

            for (int l = 0; l < n; l++) {

                //-------------this code portion is same as FarLandPossible
                if (grid[k][l] == '1') {

                    isLandCount++;

                    //convert that Land and other connecting Land to water
                    grid[k][l] = '0';

                    lands.offer(new Point(k, l));

                    while (!lands.isEmpty()) {

                        Point node = lands.poll();
                        level_len--;

                        int i = node.x;
                        int j = node.y;

                        //checking in Top, Bottom, Left, Right Direction
                        if (i + 1 < m && grid[i + 1][j] == '1') {
                            lands.offer(new Point(i + 1, j));
                            grid[i + 1][j] = water;
                        }

                        if (i - 1 >= 0 && grid[i - 1][j] == '1') {
                            lands.offer(new Point(i - 1, j));
                            grid[i - 1][j] = water;
                        }

                        if (j + 1 < n && grid[i][j + 1] == '1') {
                            lands.offer(new Point(i, j + 1));
                            grid[i][j + 1] = water;
                        }

                        if (j - 1 >= 0 && grid[i][j - 1] == '1') {
                            lands.offer(new Point(i, j - 1));
                            grid[i][j - 1] = water;
                        }

                        //if land array is empty; fill it with default size..
                        if (level_len == 0) {
                            level_len = lands.size();
                        }
                    }
                }
                //------------------------------------------------
            }
        }

        System.out.println(isLandCount);
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
