package com.interview.codingblocks.week9DynamicProgrammming;

import java.util.Arrays;
import java.util.Scanner;

public class RobotAndPath {

    static int[][] dp = new int[1001][1001];
    private static int count = 0;
    private static int MOD = 1000000007;

    //https://www.codechef.com/problems/CD1IT4
    public static void main( String[] args ) {
      //  solveRecursive();

        solveBottomUp();
    }

    //Time complexity : 2 ^ N
    private static void solveRecursive() {
        String[] arr = {
                "000",
                "000",
                "X0X",
                "000"
        };

        int m = 4; //4 rows
        int n = 3; //3 columns

        boolean isPathFound = solveMaze(arr, m - 1, n - 1, 0, 0); //m-1 : bcz index starts with 0

        if (isPathFound)
            System.out.println("True");
        else
            System.out.println("False");

        System.out.println("count " + count);
    }

    //This is same as rat in a maze
    private static boolean solveMaze( String[] maze, int m, int n, int i, int j ) {

        //we reached the last row/column cell.
        if (i == m && j == n) {

            count++;
            return true; //true to indicate success; otherwise final answer on MAIN can be FALSE
        }

        //Rat should be inside the grid
        if (i > m || j > n)
            return false;

        if (i <= maze.length && j <= maze[i].length()) {
            if (maze[i].charAt(j) == 'X')
                return false;

            // soln[i][j] = 1;

            //recursive call to move on right and down path in a maze
            boolean rightSuccess = solveMaze(maze, m, n, i, j + 1);
            boolean downSuccess = solveMaze(maze, m, n, i + 1, j);

            //Set previous stack frame path to 0; bcz we may want to generate a different path out of it.
            //This doesn't matter if we got success or failure; we want to reach multiple path, so set previous path to zero
            //This is also called backtracking
            // soln[i][j] = 0;

            //If we got success path; Notify previous stack frame that we got success; No blocker ahead
            //return rightSuccess || downSuccess;
        }

        return true;
    }

    //reference : http://www.crazyforcode.com/robot-mxn-grid/
    //give input through codechef page
    private static void solveBottomUp() {

        Scanner scanner = new Scanner(System.in);

        int M = scanner.nextInt();
        int N = scanner.nextInt();
        int P = scanner.nextInt();

        // Fill each row with -1
       /* for (int[] row : dp)
            Arrays.fill(row, -1);*/

        for (int i = 0; i < P; i++) {

            int x = scanner.nextInt();
            int y = scanner.nextInt();

            dp[x - 1][y - 1] = -1;
        }

        System.out.println(solveBottonUpDP(M, N));
    }

    private static int solveBottonUpDP( int m, int n ) {

        //If first cell is blocked
        if (dp[0][0] == -1)
            return 0;

        //Fill the first row to '1' if it isn't blocked
        for (int i = 0; i < n; i++) {
            if (dp[0][i] == -1)
                break;

            dp[0][i] = 1;
        }

        //Fill the first row to '1' if it isn't blocked
        for (int j = 0; j < m; j++) {
            if (dp[j][0] == -1)
                break;

            dp[j][0] = 1;
        }

        //Start from 1st Row and 1st col to check each cell distance for Right and Down upto end.
        for (int i = 1; i < m; i++) {

            for (int j = 1; j < n; j++) {

                //if current cell is blocked, leave and continue to next.
                if (dp[i][j] == -1)
                    continue;

                //if previous left cell is not blocked then PATH to reach current cell is equal to previous left.(bcz we going straight)
                if (dp[i][j - 1] != -1)
                    dp[i][j] = dp[i][j - 1] % MOD;

                //if previous upper cell is not blocked then PATH to reach current is sum of current + upper
                //bcz :
                // -----------------------
                // 1   1
                // 1   ?
                //Path to reach cell (1,1) is sum of upper cell and left cell : two ways to reach (1,1) :
                // 1. (0,0) -> (0,1) -> (1,1)
                // 2. (0,0) -> (1,0) -> (1,1)  : total : 2

                if (dp[i - 1][j] != -1)
                    dp[i][j] = (dp[i][j] + dp[i - 1][j]) % MOD;
            }
        }

        if (dp[m - 1][n - 1] == -1)
            return 0;

        return dp[m - 1][n - 1];
    }
}
