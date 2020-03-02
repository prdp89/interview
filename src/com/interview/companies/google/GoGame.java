package com.interview.companies.google;

import java.util.ArrayDeque;
import java.util.Queue;

public class GoGame {

    //https://leetcode.com/discuss/interview-question/391195/

    /*
    You play a game of Go. You are given a board with some stones placed on it (w is white stone, b is black stone, e is empty spot.), and you are given a new black stone to be placed on an empty spot. You have to return the number of enemy stones that this move will capture.

    Example 1:

    Input: board = [[e, e, e, e, b, b, b], row = 2, col = 5
                    [e, e, e, e, b, w, b],
                    [e, e, e, e, b, e, b],
                    [e, e, e, e, e, e, e]]

    Output: 1
    Explanation: If you place a black stone on (2, 5) then you capture 1 white stone from the enemy.

    Example 3:

    Input: board = [[e, e, e, e, b, b, b], row = 2, col = 5
                    [e, e, e, e, w, w, b],
                    [e, e, e, e, b, e, b],
                    [e, e, e, e, e, e, e]]

    Output: 0
    Explanation: Because the enclosure is not complete, white can escape from the left side.

    Example 4:

    Input: board = [[e, e, b, b, b, b, b], row = 2, col = 5
                    [e, e, b, w, e, w, b],
                    [e, e, b, b, b, e, b],
                    [e, e, e, e, e, e, e]]

    Output: 0
    Explanation: This one does not qualify as an enclosure, it is an 'eventual enclosure', meaning that the white regions still have scope for expansion.
     */

    //based on NumberOfIslands
    static int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main( String[] args ) {

        char[][] board = {{'e', 'e', 'e', 'e', 'b', 'b', 'b'},
                {'e', 'e', 'e', 'e', 'b', 'w', 'b'},
                {'e', 'e', 'e', 'e', 'b', 'e', 'b'},
                {'e', 'e', 'e', 'e', 'e', 'e', 'e'}};

        System.out.println(maxCapture(board, 2, 5));
    }

    private static int maxCapture( char[][] board, int r, int c ) {
        if (board == null || board.length == 0 || isOutOfBounds(board, r, c) || board[r][c] != 'e')
            return 0;

        int m = board.length, n = board[0].length;

        boolean[][] visited = new boolean[m][n];
        visited[r][c] = true;

        int count = 0;
        for (int[] dir : directions) {
            count += bfs(board, visited, r + dir[0], c + dir[1]);
        }

        return count;
    }

    private static int bfs( char[][] board, boolean visited[][], int r, int c ) {
        int count = 0;
        boolean valid = true;

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{r, c});

        while (!queue.isEmpty()) {
            int[] loc = queue.poll();
            int x = loc[0], y = loc[1];

            //we are playing on black side only
            if (isOutOfBounds(board, x, y) || visited[x][y] || board[x][y] == 'b')
                continue;

            //if empty cell, then no need to traverse..
            if (board[x][y] == 'e') {
                valid = false;
            } else {

                visited[x][y] = true;

                for (int[] dir : directions) {
                    queue.offer(new int[]{x + dir[0], y + dir[1]});
                }

                count++;
            }
        }

        return valid ? count : 0;
    }

    private static boolean isOutOfBounds( char[][] board, int x, int y ) {
        return x < 0 || y < 0 || x > board.length - 1 || y > board[0].length - 1;
    }
}
