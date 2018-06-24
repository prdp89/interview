package com.interview.codingblocks.week1;

import java.util.Scanner;

public class NQueenVariant {

    public static void main( String[] args ) {

        Scanner scanner = new Scanner(System.in);
        int numberOfQueens = scanner.nextInt();

        int board[][] = new int[4][4];

        nQueenBackUsingtracking(board, 0, numberOfQueens);
    }

    //source: https://www.youtube.com/watch?v=jFwREev_yvU
    private static boolean nQueenBackUsingtracking( int[][] board, int i, int numberOfQueens ) {

        //Base case : if  i == n , row number matches number of queens
        if (i == numberOfQueens) {
            //we have successfully place queens in N-rows
            //prints the config.

            for (int j = 0; j < numberOfQueens; j++) {
                for (int k = 0; k < numberOfQueens; k++) {
                    if (board[j][k] == 1)
                        System.out.print("Q ");
                    else
                        System.out.print("_ ");
                }
                System.out.print("\n");
            }

            System.out.print("\n");

            //setting it true means we are considering only one possibility to place the queen
            return true;

            //or false means: even if we place n queens, we going to look up for other possibility to place the queens
            //return false;
        }

        //Recursive Case
        //Try to place the queens in Current row : means 0th row And,
        //The call on Remaining part will be handle by recursion.
        for (int j = 0; j < numberOfQueens; j++) {

            //Now we have to check (i,j)th position is safe to place Queen or not.

            if (isSafe(board, i, j, numberOfQueens)) {

                //if its safe to place queen in current cell
                board[i][j] = 1;

                //i+1 : to move to next row position
                boolean nextQueenRakhPaRaheHain = nQueenBackUsingtracking(board, i + 1, numberOfQueens);

                //suppose the 1st queen is already place and now placing the 2nd queen return true means second queen configuration is correct.
                //so now return true means look to place other queen
                if (nextQueenRakhPaRaheHain == true)
                    return true;

                //means we are not able to place queen in (i,j)th row position, so backtrack and zero the previous row
                board[i][j] = 0;
            }
        }

        //same as Maze problem line number 154
        //we tried all position in the current row, but couldn't place a queen.
        return false;
    }

    private static boolean isSafe( int[][] board, int i, int j, int n ) {

        //check to place queen in current row's column cell
        for (int row = 0; row < i; row++) {
            if (board[row][j] == 1)
                return false;
        }

        //checking if queen can be place in Left-Diagonal
        int x = i, y = j;
        while (x >= 0 && y >= 0) {
            if (board[x][y] == 1)
                return false;
            x--;
            y--;
        }

        //checking for right diagonal
        x = i;
        y = j;

        while (x >= 0 && y < n) {
            if (board[x][y] == 1)
                return false;
            x--;
            y++;
        }

        //means we can place queen in current row
        return true;
    }
}
