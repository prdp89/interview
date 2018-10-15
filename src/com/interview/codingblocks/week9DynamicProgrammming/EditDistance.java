package com.interview.codingblocks.week9DynamicProgrammming;

import java.util.Arrays;

public class EditDistance {

    static int memo[][] = new int[100][100];

    /*
    We can compute the edit distance between two strings by working from the ends.
    The three operations available to us are:

    step 1 : Add one character to the end of a string

    step 2 : Remove one character from the end of a string

    step 3 : Change the character at the end of a string.

     */
    //Video : https://online.codingblocks.com/player/3880/content/764?s=687
    //Link : https://secweb.cs.odu.edu/~zeil/cs361/web/website/Lectures/styles/pages/editdistance.html

    public static void main( String[] args ) {

        String m = "australia";
        String n = "austria";

       /* String m = "geek";
        String n = "gesek"; */ //output : 1

       /* String m = "sunday";
        String n = "saturday"; *///output : 3

        long startTime = System.nanoTime();

        System.out.println("Recursive : " + editDistanceRecursive(m, n)); //2

        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println("Time: " + totalTime);

        for (int[] row : memo)
            Arrays.fill(row, -1);

        long startTimeMemoization = System.nanoTime();

        System.out.println("Top Down :" + editDistanceTopDownDP(m, n, m.length(), n.length()));

        long endTimeMemoization = System.nanoTime();
        long totalTimeMemoization = endTimeMemoization - startTimeMemoization;
        System.out.println("Time : " + totalTimeMemoization);

        long startBottomupDP = System.nanoTime();

        System.out.println("Bottom up:" + editDistanceBottomUpDP(m, n));

        long endTimeBottomUP = System.nanoTime();
        long totalTimeBottomUp = endTimeBottomUP - startBottomupDP;
        System.out.println("Time : " + totalTimeBottomUp);
    }

    //TIme complexity  : 3 ^ N : At each step we are looking for 3 options (Add, remove, change)
    private static int editDistanceRecursive( String x, String y ) {
        if (x.equals(""))
            return y.length(); // base case

        else if (y.equals(""))
            return x.length(); // base case

        else {

            int addDistance = editDistanceRecursive(x, y.substring(0, y.length() - 1)) + 1; //add 1 char to X after decreasing Y length

            int removeDistance = editDistanceRecursive(x.substring(0, x.length() - 1), y) + 1; //Removing 1 char from X after decrementing X length.

            int changeDistance = editDistanceRecursive(x.substring(0, x.length() - 1), //operating on bith X , Y strings
                    y.substring(0, y.length() - 1))
                    + (x.charAt(x.length() - 1) == y.charAt(y.length() - 1) ? 0 : 1); //if char is same then no operating cost require; else add 1.

            return Math.min(Math.min(addDistance, removeDistance), changeDistance);
        }
    }

    //Time Complexity  : O ( M * N )
    private static int editDistanceTopDownDP( String s, String t, int m, int n ) {

        if (m == 0) return n;

        // If second string is empty, the only option is to
        // remove all characters of first string
        if (n == 0) return m;

        if (memo[m][n] != -1)
            return memo[m][n];

        int addDistance = editDistanceTopDownDP(s, t, m, n - 1) + 1;

        int removeDistance = editDistanceTopDownDP(s, t, m - 1, n) + 1;

        int changeDistance = editDistanceTopDownDP(s, t, m - 1, n - 1) +
                (s.charAt(m - 1) == t.charAt(n - 1) ? 0 : 1);

        memo[m][n] = Math.min(Math.min(addDistance, removeDistance), changeDistance);
        return memo[m][n];
    }

    //explanation in diary.
    private static int editDistanceBottomUpDP( String s, String t ) {
        int dp[][] = new int[s.length() + 1][t.length() + 1];

        for (int i = 0; i < dp.length; i++) {

            for (int j = 0; j < dp[i].length; j++) {

                if (i == 0 && j == 0)
                    dp[i][j] = 0;

                //for first row
                else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] + 1;
                }

                //for first column
                else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + 1;
                }

                //for rest greater than second row
                else {

                    if (s.charAt(i - 1) == t.charAt(j - 1))
                        dp[i][j] = dp[i - 1][j - 1];
                    else {

                        dp[i][j] = 1 + Math.min(Math.min(dp[i][j - 1], //Insert
                                dp[i - 1][j]), //remove
                                dp[i - 1][j - 1]);
                    }
                }
            }
        }
        return dp[s.length()][t.length()];
    }
}
