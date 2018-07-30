package com.interview.codingblocks.week1;

import java.util.BitSet;
import java.util.Scanner;

public class NQueenVariant {

    public static void main( String[] args ) {

        Scanner scanner = new Scanner(System.in);
        int numberOfQueens = scanner.nextInt();

        int board[][] = new int[numberOfQueens][numberOfQueens];

        BitSet bitSetCol = new BitSet();
        BitSet bitSetDiagonal1 = new BitSet();
        BitSet bitSetDiagonal2 = new BitSet();

        //Method-1
        //nQueenBackUsingtracking(board, 0, numberOfQueens);

        //Method-2
        nQueenBitsetBacktracking(board, 0, numberOfQueens, bitSetCol, bitSetDiagonal1, bitSetDiagonal2);
        System.out.println(answer);
    }

    //https://www.youtube.com/watch?v=u6viVC1fJ9g
    //This method will Print number of combinations we can generate for N-queens
    //Example : IF N=4 then output = 2, we can have two variant to generate N*N matrix.

    private static int answer=0;
    private static void nQueenBitsetBacktracking( int[][] board, int i, int numberOfQueens, BitSet bitSetCol, BitSet bitSetDiagonal1, BitSet bitSetDiagonal2 ) {

        if (i == numberOfQueens) {
            answer++;
            //System.out.println("Combinations..");
            return;
        }

        for (int col = 0; col < numberOfQueens; col++) {

            //checking in current column && checking for diagonal-1 &&
            if (!bitSetCol.get(col) && !bitSetDiagonal1.get(i - col + numberOfQueens - 1) &&
                    !bitSetDiagonal2.get(i + col)) //checking for diagonal-2
            {
                board[i][col] = 1;

                //setting col, diagonal1 , diagonal2 after
                //Due to Bitsets, we don't need any isSafe method, it saves O(N) to calc. ISSafe method.

                bitSetCol.set(col, true);
                bitSetDiagonal1.set(i - col + numberOfQueens - 1, true);
                bitSetDiagonal2.set(i + col, true);

                nQueenBitsetBacktracking(board, i + 1, numberOfQueens, bitSetCol, bitSetDiagonal1, bitSetDiagonal2);

                //reset the value of bitsets, when we are backtracking
                bitSetCol.set(col, false);
                bitSetDiagonal1.set(i - col + numberOfQueens - 1, false);
                bitSetDiagonal2.set(i + col, false);

                board[i][col] = 0;
            }
        }
    }

    //source: https://www.youtube.com/watch?v=jFwREev_yvU
    //This method will Print N-queen configuration using Backtracking only.
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
