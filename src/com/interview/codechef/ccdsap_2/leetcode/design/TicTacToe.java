package com.interview.codechef.ccdsap_2.leetcode.design;

public class TicTacToe {

    private int[] rows;
    private int[] cols;
    private int dc1;
    private int dc2;
    private int n;

    /**
     * Initialize your data structure here.
     */
    public TicTacToe( int n ) {
        this.n = n;
        this.rows = new int[n];
        this.cols = new int[n];
    }

    //https://www.programcreek.com/2014/05/leetcode-tic-tac-toe-java/
    public static void main( String[] args ) {

    }

    public int move( int row, int col, int player ) {
        int val = (player == 1 ? 1 : -1);

        //example: if First PLayer keep on adding on First row {0} then that element would reach 3.
        rows[row] += val;

        cols[col] += val;

        if (row == col) {
            dc1 += val;
        }

        if (col == n - row - 1) {
            dc2 += val;
        }

        //if Player 1 wins : then either row or col == 3
        //if Player 2 wins : then either row or col == -3
        if (Math.abs(rows[row]) == n
                || Math.abs(cols[col]) == n
                || Math.abs(dc1) == n
                || Math.abs(dc2) == n) {
            return player;
        }

        return 0;
    }
}
