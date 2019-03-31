package com.interview.codingblocks.week10DivideAndConquer;

import java.util.Scanner;

public class DominoFilling {

    private static int[][] board;
    private static int cnt, holeX, holeY;

    public static void main( String[] args ) {

        System.out.println("Enter board size in 2 ^ N :");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        System.out.println("Enter hole index in Matrix :");
        holeX = scanner.nextInt();
        holeY = scanner.nextInt();

        int totalBoardSize = 1;

        //calculating 2 ^ N for board size
        for (int i = 0; i < n; i++)
            totalBoardSize = 2 * totalBoardSize;

        board = createBoard(totalBoardSize, holeX, holeY);

        trominoTileRec(totalBoardSize, 0 ,0);

        //printing the board
        for (int i = 0; i < totalBoardSize; i++) {
            for (int j = 0; j < totalBoardSize; j++) {
                System.out.print(board[i][j] + "  ");
            }
            System.out.println();
        }
    }

    private static int[][] createBoard( int totalBoardSize, int holeX, int holeY ) {

        int[][] arr = new int[totalBoardSize][totalBoardSize];

        for (int i = 0; i < totalBoardSize; i++) {

            for (int j = 0; j < totalBoardSize; j++) {

                if (i == holeX && j == holeY) {
                    arr[i][j] = -1;
                } else {
                    arr[i][j] = 0;
                }
            }
        }

        return arr;
    }

    private static int trominoTileRec( int n, int x, int y ) {
        int i, j, hr =0 , hc = 0;
        if (n == 2) {
            cnt++;
            for (i = 0; i < n; i++) {
                for (j = 0; j < n; j++) {
                    if (board[x + i][y + j] == 0)
                        board[x + i][y + j] = cnt;
                }
            }
            return 0;
        }
        //Search the hole's location
        for (i = x; i < n; i++) {
            for (j = y; j < n; j++) {
                if (board[i][j] != 0) {
                    hr = i;
                    hc = j;
                }
            }
        }

        //If missing Tile is in 1st quadrant
        if (hr < x + n / 2 && hc < y + n / 2) {
            putTromino(x + n / 2, y + (n / 2) - 1, x + n / 2, y + n / 2, x + n / 2 - 1, y + n / 2);
        }
        //If missing Tile is in 2st quadrant
        else if (hr >= x + n / 2 && hc < y + n / 2) {
            putTromino(x + n / 2, y + (n / 2) - 1, x + n / 2, y + n / 2, x + n / 2 - 1, y + n / 2 - 1);
        }
        //If missing Tile is in 3st quadrant
        else if (hr < x + n / 2 && hc >= y + n / 2) {
            putTromino(x + (n / 2) - 1, y + (n / 2), x + (n / 2), y + n / 2, x + (n / 2) - 1, y + (n / 2) - 1);
        }
        //If missing Tile is in 4st quadrant
        else if (hr >= x + n / 2 && hc >= y + n / 2) {
            putTromino(x + (n / 2) - 1, y + (n / 2), x + (n / 2), y + (n / 2) - 1, x + (n / 2) - 1, y + (n / 2) - 1);
        }

        trominoTileRec(n / 2, x, y + n / 2);
        trominoTileRec(n / 2, x, y);
        trominoTileRec(n / 2, x + n / 2, y);
        trominoTileRec(n / 2, x + n / 2, y + n / 2);

        return 0;
    }

    private static void putTromino( int x1, int y1, int x2, int y2, int x3, int y3 ) {
        cnt++;
        board[x1][y1] = cnt;
        board[x2][y2] = cnt;
        board[x3][y3] = cnt;
    }
}
