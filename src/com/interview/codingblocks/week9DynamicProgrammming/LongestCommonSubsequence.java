package com.interview.codingblocks.week9DynamicProgrammming;

import java.util.Arrays;

public class LongestCommonSubsequence {

    private static int memo[][] = new int[100][100];

    //Read this a variant of this problem : Shortest common subsequence : https://www.geeksforgeeks.org/shortest-common-supersequence/
    //aNOTHER VARIANT OF lcs : https://www.geeksforgeeks.org/longest-repeating-subsequence/

    //Another variant : https://www.geeksforgeeks.org/lcs-longest-common-subsequence-three-strings/

    //Another Variant: https://www.spoj.com/problems/AIBOHP/
    //solution: http://spoj-solutions.blogspot.com/2015/09/aibohp-aibohphobia.html
    //Find LCS (original, reverse) then subtract from result.

    //Another variant: com.interview.codechef.ccdsapfoundation_1.DP.GFG.DistinctSubsequence2Strings

    public static void main( String[] args ) {

        /* String s = "nematode";
        String t = "empty"; */ //output : 3

       /* String s = "AGGTAB";
        String t = "GXTXAYB";*/ //output : 4

        String s = "abc";
        String t = "acd";

        long startTime = System.nanoTime();

        System.out.println(solveRecursive(s, t, 0, 0));

        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println("Time Recursive: " + totalTime);

        for (int[] row : memo)
            Arrays.fill(row, -1);

        long startTimeMemoization = System.nanoTime();

        //for Top down Dp approach:
        System.out.println(solveTopDownDP(s, t, 0, 0));

        long endTimeMemoization = System.nanoTime();
        long totalTimeMemoization = endTimeMemoization - startTimeMemoization;

        System.out.println("Time Top Down DP : " + totalTimeMemoization);

        //for Bottom up DP
        long startBottomupDP = System.nanoTime();

        System.out.println((solveBottonUpDP(s, t)));

        long endTimeBottomUP = System.nanoTime();
        long totalTimeBottomUp = endTimeBottomUP - startBottomupDP;
        System.out.println("Time Bottom Up DP : " + totalTimeBottomUp);
    }

    //Time complexity : 2 ^ N
    private static int solveRecursive( String s, String t, int i, int j ) {

        if (i > s.length() - 1)
            return 0;

        if (j > t.length() - 1)
            return 0;

        if (s.charAt(i) == t.charAt(j))
            return 1 + solveRecursive(s, t, i + 1, j + 1); //+1 to include the current character

        //Suppose we have strings :
        // y = A G G
        // x = G X
        // step 1 : One option is to compare "A G" with "G X"
        // step 2 : other option is to compare "A G G" with "G"

        //step1:
        int iIsSameJIncremented = solveRecursive(s, t, i, j + 1);

        //step2:
        int jIsSameIIncremented = solveRecursive(s, t, i + 1, j);

        return Math.max(iIsSameJIncremented, jIsSameIIncremented);
    }

    //Time complexity : N ^ 2
    private static int solveTopDownDP( String s, String t, int i, int j ) {

        if (i > s.length() - 1)
            return 0;

        if (j > t.length() - 1)
            return 0;

        if (memo[i][j] != -1)
            return memo[i][j];

        if (s.charAt(i) == t.charAt(j))
            return 1 + solveTopDownDP(s, t, i + 1, j + 1); //+1 to include the current character

        //step1:
        int iIsSameJIncremented = solveTopDownDP(s, t, i, j + 1);

        //step2:
        int jIsSameIIncremented = solveTopDownDP(s, t, i + 1, j);

        memo[i][j] = Math.max(iIsSameJIncremented, jIsSameIIncremented);
        return memo[i][j];
    }

    //Time complexity : N ^ 2
    //https://www.youtube.com/watch?time_continue=9&v=sQppNtIxoc0
    private static int solveBottonUpDP( String s, String t ) {

        int dp[][] = new int[s.length() + 1][t.length() + 1];

        //for 2d DP base case : set first row and column to zero
        for (int i = 0; i <= s.length(); i++) {
            dp[i][0] = 0; //filling first column
        }

        for (int j = 0; j <= t.length(); j++) {
            dp[0][j] = 0; //filling first row
        }

        for (int i = 1; i <= s.length(); i++) {

            for (int j = 1; j <= t.length(); j++) {

                int q;

                if (s.charAt(i - 1) == t.charAt(j - 1)) //bcz (i,j) may reach upto length+1)
                    q = 1 + dp[i - 1][j - 1]; //+1 to include the current char
                else {

                    q = Math.max(dp[i][j - 1], //step2 of recursion : value taken from same (row,col-1)
                            dp[i - 1][j] //step1 of recursion : value taken from up-row cell
                    );
                }
                dp[i][j] = q;
            }
        }

        printLCS(dp, s, t);

        return dp[s.length()][t.length()];
    }

    private static void printLCS( int[][] dp, String s, String t ) {

        int lastIndex = dp[s.length()][t.length()];

        // Create a character array to store the lcs string
        char[] lcs = new char[lastIndex];
        //lcs[lastIndex] = ''; // Set the terminating character

        // Start from the right-most-bottom-most corner and
        // one by one store characters in lcs[]
        int i = s.length(), j = t.length();

        while (i > 0 && j > 0) {

            // If current character in X[] and Y are same, then
            // current character is part of LCS
            if (s.charAt(i - 1) == t.charAt(j - 1)) {

                // Put current character in result
                lcs[lastIndex - 1] = s.charAt(i - 1);

                // reduce values of i, j and index
                i--;
                j--;

                lastIndex--;
            }

            // If not same, then find the larger of two and
            // go in the direction of larger value
            else if (dp[i - 1][j] > dp[i][j - 1])
                i--;
            else
                j--;
        }

        System.out.println("LCS string :");
        for (char c : lcs) {
            System.out.print(c);
        }
    }
}
