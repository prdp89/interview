package com.interview.codingblocks.week6recursion;

public class RatInAMaze {

    //newline may be System independent.
    private static String newLine = System.lineSeparator();

    //Problem Description:
    //https://www.geeksforgeeks.org/backttracking-set-2-rat-in-a-maze/
    //https://codingblocks.com/resources/IEEE-workshop/
    public static void main( String[] args ) {
        String[] arr = {
                "0000",
                "00X0",
                "000X",
                "0X00"
        };

        int m = 4; //4 rows
        int n = 4; //4 columns

        int soln[][] = new int[10][10];

        boolean isPathFound = solveMaze(arr, soln, m - 1, n - 1, 0, 0); //m-1 : bcz index starts with 0

        if (isPathFound)
            System.out.println("True");
        else
            System.out.println("False");
    }

    private static boolean solveMaze( String[] maze, int[][] soln, int m, int n, int i, int j ) {

        //we reached the last row/column cell.
        if (i == m && j == n) {
            soln[m][n] = 1;

            //Printing the path
            for (int i1 = 0; i1 <= m; i1++) {
                for (int j1 = 0; j1 <= n; j1++) {
                    System.out.print(soln[i1][j1] + " ");
                }
                System.out.print(newLine);
            }

            System.out.print(newLine + newLine);
            return true; //true to indicate success; otherwise final answer on MAIN can be FALSE
        }

        //Rat should be inside the grid
        if (i > m || j > n)
            return false;

        if (i <= maze.length && j <= maze[i].length()) {
            if (maze[i].charAt(j) == 'X')
                return false;

            soln[i][j] = 1;

            //recursive call to move on right and down path in a maze
            boolean rightSuccess = solveMaze(maze, soln, m, n, i, j + 1);
            boolean downSuccess = solveMaze(maze, soln, m, n, i + 1, j);

            //Set previous stack frame path to 0; bcz we may want to generate a different path out of it.
            //This doesn't matter if we got success or failure; we want to reach multiple path, so set previous path to zero
            //This is also called backtracking
            soln[i][j] = 0;

            //If we got success path; Notify previous stack frame that we got success; No blocker ahead
            if (rightSuccess || downSuccess)
                return true;

            return false;
        }

        return false;
    }
}
