package com.interview.codechef.ccdsapfoundation_1.DP.GFG;

public class MaxSumPathTriangle {

    //https://www.geeksforgeeks.org/maximum-path-sum-triangle/
    public static void main( String[] args ) {

        /*int tri[][] = {{1, 0, 0},
                {4, 8, 0},
                {1, 5, 3}};*/

        //System.out.println(recurseTriangle(tri, 0, 0)); //op 14 : {1, 8, 5}

        int tri[][] = {{3, 0, 0, 0},
                {7, 4, 0, 0},
                {2, 4, 6, 0},
                {8, 5, 9, 3}};
        System.out.println(recurseTriangle(tri, 0, 0)); //op 23 : {3, 7, 4, 9}
    }

    private static int recurseTriangle( int[][] tri, int i, int j ) {

        if (i >= tri.length || j >= tri.length)
            return 0;

        if (i == tri.length - 1 && j <= tri.length - 1)
            return tri[i][j];

        return tri[i][j] +
                Math.max(recurseTriangle(tri, i + 1, j + 1), recurseTriangle(tri, i + 1, j));

    }
}
