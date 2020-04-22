package com.interview.companies.fb;

import java.util.Arrays;

public class WallsAndGates {

    //Almost similar to WordSearch

    //https://leetcode.com/problems/walls-and-gates/

    /*
    You are given a m x n 2D grid initialized with these three possible values.
    -1 - A wall or an obstacle.
    0 - A gate.
    INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than2147483647.

    Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.
    For example, given the 2D grid:

    INF  -1  0  INF
    INF INF INF  -1
    INF  -1 INF  -1
     0  -1  INF  INF

    After running your function, the 2D output grid should be:

      3  -1   0   1
      2   2   1  -1
      1  -1   2  -1
      0  -1   3   4

    Understand the problem:
    It is very classic backtracking problem like: WordSearch.

    We can start from each gate (0 point), and searching for its neighbors. We can either use DFS or BFS solution.

     */
    public static void main( String[] args ) {
        int[][] arr = {
                {Integer.MAX_VALUE, -1, 0, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, -1},
                {Integer.MAX_VALUE, -1, Integer.MAX_VALUE, -1},
                {0, -1, Integer.MAX_VALUE, Integer.MAX_VALUE}};

        wallsAndGates(arr);

        System.out.println(Arrays.deepToString(arr));
    }

    private static void wallsAndGates( int[][] rooms ) {

        if (rooms == null || rooms.length == 0) {
            return;
        }

        int m = rooms.length;
        int n = rooms[0].length;

        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                //search distance for every empty room
                if (rooms[i][j] == 0) {
                    wallsAndGates(rooms, i, j, visited, 0);
                }
            }
        }
    }

    private static void wallsAndGates( int[][] rooms, int row, int col, boolean[][] visited, int distance ) {

        if (!checkBound(row, col, rooms)) {
            return;
        }

        if (visited[row][col])
            return;

        //if we hit the wall
        if (rooms[row][col] == -1)
            return;

        //if we get worst distance, do not consider
        if (distance > rooms[row][col])
            return;

        visited[row][col] = true;

        rooms[row][col] = Math.min(rooms[row][col], distance);

        //search in all directions as WordSearch
        wallsAndGates(rooms, row + 1, col, visited, distance + 1);
        wallsAndGates(rooms, row, col + 1, visited, distance + 1);
        wallsAndGates(rooms, row - 1, col, visited, distance + 1);
        wallsAndGates(rooms, row, col - 1, visited, distance + 1);

        //backtrack
        visited[row][col] = false;
    }

    private static boolean checkBound( int row, int col, int[][] board ) {
        return row >= 0 && row < board.length && col >= 0 && col < board[0].length;
    }
}
