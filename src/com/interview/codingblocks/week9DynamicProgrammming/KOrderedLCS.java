package com.interview.codingblocks.week9DynamicProgrammming;

import java.util.HashMap;
import java.util.Scanner;

public class KOrderedLCS {

    static int dp[][][] = new int[2005][2005][8];

    //Input:
    /*
    5 5 1
    1 2 3 4 5
    5 3 1 4 2
     */
    //output: 3


    //https://www.hackerearth.com/problem/algorithm/mancunian-and-k-ordered-lcs-e6a4b8c6/
    public static void main( String[] args ) {

        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int charsLeft = scanner.nextInt();

        int[] a = new int[m];
        for (int i = 0; i < m; i++) {
            a[i] = scanner.nextInt();
        }

        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }

       /* long startTime = System.nanoTime();

        System.out.println(solveRecursive(a, b, 0, 0, charsLeft));

        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println("Time Recursive: " + totalTime);*/

        //------------------------------------------------------------------------------

        long startTimeMemoization = System.nanoTime();

        System.out.println(solveTopDownDp(a, b, 0, 0, charsLeft, new HashMap<>()));

        long endTimeMemoization = System.nanoTime();
        long totalTimeMemoization = endTimeMemoization - startTimeMemoization;
        System.out.println("Time Top Down DP : " + totalTimeMemoization);

        //-------------------------------------------------------------------------------

        long startTime3D = System.nanoTime();

      /*  for (int[][] row : dp)
            for (int[] col : row)
                Arrays.fill(col, -1);*/


        System.out.println(solveTopDownDp_3D(a, b, 0, 0, charsLeft));

        long endTime3D = System.nanoTime();
        long total3D = endTime3D - startTime3D;
        System.out.println("Time Top Down DP 3D: " + total3D);
        //-------------------------------------------------------------------------------
    }

    //Time complexity: 3 ^ N
    //Pass 1 test case
    private static int solveRecursive( int[] a, int[] b, int i, int j, int charLeft ) {

        if (i > a.length - 1)
            return 0;

        if (j > b.length - 1)
            return 0;

        if (charLeft == 0)
            return 0;

        if (a[i] == b[j])
            return 1 + solveRecursive(a, b, i + 1, j + 1, charLeft); //+1 to include the current character
        else {

            int x = 1 + solveRecursive(a, b, i + 1, j + 1, charLeft - 1); //replacing char of first string and increase index of both string

            //same as LCS program
            int y = solveRecursive(a, b, i + 1, j, charLeft);
            int z = solveRecursive(a, b, i, j + 1, charLeft);

            return Math.max(x, Math.max(y, z));
        }
    }

    //This solution doesn't pass all test case. So we need to include 3D DP here
    private static int solveTopDownDp( int[] a, int[] b, int i, int j, int charLeft, HashMap<String, Integer> map ) {

        if (i > a.length - 1)
            return 0;

        if (j > b.length - 1)
            return 0;

        if (charLeft == 0)
            return 0;

        String key = i + "-" + j;
        if (map.containsKey(key))
            return map.get(key);

        int res;
        if (a[i] == b[j])
            res = 1 + solveTopDownDp(a, b, i + 1, j + 1, charLeft, map); //+1 to include the current character
        else {

            int x = 0;
            if (charLeft > 0)
                x = 1 + solveTopDownDp(a, b, i + 1, j + 1, charLeft - 1, map); //replacing char of first string and increase index of both string

            int y = solveTopDownDp(a, b, i + 1, j, charLeft, map);
            int z = solveTopDownDp(a, b, i, j + 1, charLeft, map);

            res = Math.max(x, Math.max(y, z));
        }

        map.put(key, res);
        return res;
    }

    private static int solveTopDownDp_3D( int[] a, int[] b, int i, int j, int charLeft ) {

        if (i == a.length || j == b.length)
            return 0;

        if (dp[i][j][charLeft] != 0)
            return dp[i][j][charLeft];

        int res;
        if (a[i] == b[j])
            res = 1 + solveTopDownDp_3D(a, b, i + 1, j + 1, charLeft); //+1 to include the current character
        else {

            int x = 0;
            if (charLeft > 0)
                x = 1 + solveTopDownDp_3D(a, b, i + 1, j + 1, charLeft - 1); //replacing char of first string and increase index of both string

            int y = solveTopDownDp_3D(a, b, i + 1, j, charLeft);
            int z = solveTopDownDp_3D(a, b, i, j + 1, charLeft);

            res = Math.max(x, Math.max(y, z));
        }

        dp[i][j][charLeft] = res;
        return res;
    }
}
