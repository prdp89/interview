package com.interview.codingblocks.week6recursion;

import java.util.Scanner;

public class SudokuSolverProblem {


    public static void main( String[] args ) {

        Scanner scanner = new Scanner(System.in);

       /* int gridSize = scanner.nextInt();

        int arr[][] = new int[gridSize][gridSize];

        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }*/

        int grid[][] = {{3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}};

        boolean status = solveSudoku(grid, 0, 0, 9);

       // boolean status = solveSudoku(arr, 0, 0, gridSize);

       /* if (status)
            System.out.println("TRUE");
        else
            System.out.println("FALSE");*/
    }

    private static boolean solveSudoku( int[][] grid, int i, int j, int n ) {

        //Base case
        if (i == n) {

            //print the final sudoku matrix
            for (int i1 = 0; i1 < n; i1++) {
                for (int j1 = 0; j1 < n; j1++) {
                    System.out.print(grid[i1][j1] + " ");
                }
                System.out.print("\n");
            }

            return true;
        }

        //if column value reaches to END
        if (j == n)
            return solveSudoku(grid, i + 1, 0, n); //go to next row and set J to zero

        //skip the pre-filled rows
        if (grid[i][j] != 0)
            return solveSudoku(grid, i, j + 1, n); //go to next column

        //Recursive case : We are filling the number in First row with all  options(Row, column & Small grid)
        //And recursion will take care of rest of the rows.
        for (int number = 1; number <= n; number++) { //this loop is same as smart Keypad problem loop

            if (canPlaceNumberInCell(grid, i, j, n, number)) {
                //if we are able to place a value in current cell then set number in that Index
                grid[i][j] = number;

                boolean kyaHumNextCellMeNumberRakhPaye = solveSudoku(grid, i, j + 1, n);
                if (kyaHumNextCellMeNumberRakhPaye)
                    return true;
            }
        }

        //for current cell we cannot place a number after trying all combination. So we are setting it to zero
        grid[i][j] = 0;
        return false; //return false to previous stack frame to indicate we didn't solve current cell.
    }

    //THis function is just check row, column and smaller grid duplicate number
    private static boolean canPlaceNumberInCell( int[][] grid, int i, int j, int n, int number ) {

        for (int x = 0; x < n; x++) {
            //Check in row and column for given number
            if (grid[x][j] == number || grid[i][x] == number)
                return false;
        }

        //If larger grid is 9*9 then smaller ones are 3*3
        int smallGridSize = (int) Math.sqrt(n);

        //calculating current grid's origin index; If we are at (i,j) = 4,3 then,
        int originX = (i / smallGridSize) * smallGridSize; //originX = (4/3)*3 = 3
        int originY = (j / smallGridSize) * smallGridSize; //originY = (3/3)*3 = 3

        //so origin point is (3,3); we have to start from 3,3 and cover the smallGrid of (6,6)
        //So we are checking inside (3,3) -> (6,6) a number repeat in that Grid or not.
        for (int x = originX; x < originX + smallGridSize; x++) {

            for (int y = originY; y < originY + smallGridSize; y++) {

                if (grid[x][y] == number)
                    return false;
            }
        }

        return true;
    }
}
