package com.interview.leetcode.contests.contest164;

import java.util.HashMap;

public class CountServersCommunicate {

    //https://leetcode.com/contest/weekly-contest-164/problems/count-servers-that-communicate/
    public static void main( String[] args ) {
        int[][] arr = {{1, 0}, {1, 1}};

        System.out.println(countServers(arr));
    }

    //we are only counting the number of servers that communicate.
    private static int countServers( int[][] grid ) {

        int n = grid.length;
        if (n == 0) return 0;
        int m = grid[0].length;

        int count = 0;

        HashMap<Integer, Integer> rowCount = new HashMap<>();
        HashMap<Integer, Integer> columnCount = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    count++;

                    rowCount.put(i, rowCount.getOrDefault(i, 0) + 1);
                    columnCount.put(j, columnCount.getOrDefault(j, 0) + 1);
                }
            }
        }

        //if the column in which it lies(j) and the row in which it lies(i) contain any other server or not,
        //if they don't then subtract this 1 from the total count of servers in the original grid.

        //Count-- : we did this bcz we have counted servers multiple times for an intersection.
        //example :
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    if (rowCount.get(i) == 1 && columnCount.get(j) == 1)
                        count--;
                }
            }
        }

        return count;
    }

    public int countServersVariation( int[][] grid ) {
        int m = grid.length, n = grid[0].length;
        int[] rows = new int[m], cols = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    rows[i]++;
                    cols[j]++;
                }
            }
        }

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && (rows[i] > 1 || cols[j] > 1)) res++;
            }
        }

        return res;
    }
}
