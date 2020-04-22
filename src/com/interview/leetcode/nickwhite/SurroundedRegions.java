package com.interview.leetcode.nickwhite;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {

    //https://leetcode.com/problems/surrounded-regions/
    public static void main( String[] args ) {
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };

        solve(board);

        System.out.println(Arrays.deepToString(board));
    }

    //Runtime: 2 ms, faster than 55.21% of Java
    private static void solve( char[][] board ) {
        if (board.length == 0 || board[0].length == 0) {
            return;
        }

        int width = board.length;
        int length = board[0].length;

        //preventing 1st and last row to modified
        for (int i = 0; i < length; ++i) {
            if (board[0][i] == 'O')
                bfs(board, 0, i);

            if (board[width - 1][i] == 'O')
                bfs(board, width - 1, i);
        }

        //preventing 1st and last col to modified
        for (int i = 0; i < width; ++i) {
            if (board[i][0] == 'O')
                bfs(board, i, 0);
            if (board[i][length - 1] == 'O')
                bfs(board, i, length - 1);
        }

        //iterating each row and col and do the flip operation..
        for (int i = 0; i < width; ++i) {
            for (int j = 0; j < length; ++j) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                else if (board[i][j] == '#')
                    board[i][j] = 'O';
            }
        }
    }


    //if First/Last -> Row/Col value is 'O' then we are preventing it to flip
    //including its adjacent neighbours..
    private static void bfs( char[][] board, int i1, int j1 ) {
        int m = board.length;
        int n = board[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i1, j1});

        while (!queue.isEmpty()) {
            int[] item = queue.poll();

            int i = item[0], j = item[1];
            if (item[0] >= 0 && item[0] < m && item[1] >= 0 && item[1] < n && board[item[0]][item[1]] == 'O') {

                //just to prevent corner Rows/Cols and adjacent rows/cols to be modified
                board[i][j] = '#';

                queue.offer(new int[]{i + 1, j});
                queue.offer(new int[]{i - 1, j});
                queue.offer(new int[]{i, j + 1});
                queue.offer(new int[]{i, j - 1});
            }
        }
    }
}
