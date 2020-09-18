package com.interview.codechef.ccdsapfoundation_1.DP.GFG;

public class UniquePathInGrid {

    //https://www.geeksforgeeks.org/unique-paths-in-a-grid-with-obstacles/
    public static void main( String[] args ) {
        int[][] arr = new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };

        System.out.println(recurse(arr, 0, 0));
    }

    //Similar to rat in a maze
    private static int recurse( int[][] arr, int i, int j ) {

        //i in matrix means obstacles
        if (i == arr.length - 1 && j == arr.length - 1)
            return arr[i][j] > 0 ? 0 : 1;

        if (i > arr.length || j > arr.length)
            return 0;

        if (i <= arr.length - 1 && j <= arr.length - 1) {

            if (arr[i][j] == 1)
                return 0;

            return recurse(arr, i + 1, j) + recurse(arr, i, j + 1);
        }
        return 0;
    }
}