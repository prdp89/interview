package com.interview.codechef.ccdsap_2.leetcode.dp.medium;

    //https://leetcode.com/problems/out-of-boundary-paths/
public class OutOfBoundaryPaths {

    //This problem helps in finding ways for out of Array object placement.

    //dir array shows football can be pushed to 4 directions {Left, Top, Right, Bottom}
    private static int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    private static int mod = 1000000000 + 7;

    public static void main( String[] args ) {
        int m = 2, n = 2, N = 2, i = 0, j = 0;
        System.out.println(findPaths(m, n, N, i, j));
    }

    private static int findPaths( int m, int n, int N, int i, int j ) {

        // m * n grid
        long[][][] memo = new long[m][n][N + 1];

        for (int ii = 0; ii < m; ii++) {

            for (int jj = 0; jj < n; jj++) {

                for (int kk = 0; kk < N + 1; kk++) {
                    memo[ii][jj][kk] = -1;
                }
            }
        }

        return (int) (dfs(m, n, N, i, j, memo) % mod);
    }

    private static long dfs( int m, int n, int N, int i, int j, long[][][] memo ) {
        //check if out of boundary, if out could not move back
        //If out of boundary then 1 ways to move football
        //(M, N) : indicates M*N size of matrix
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return 1;
        }

        if (N == 0)
            return 0;

        if (memo[i][j][N] != -1)
            return memo[i][j][N];

        memo[i][j][N] = 0;

        //Get first outside direction from dir[] array
        //Incrementing 'i' & 'j' to check if football can be kicked outside the array
        for (int dir[] : dirs) {

            //eg; initially (i,j) : (0,0)
            //First item of dir[] = {-1, 0} and adding i=0,j=0 push football out of the array (ways = 1)
            int x = dir[0] + i;
            int y = dir[1] + j;

            memo[i][j][N] = (memo[i][j][N] + dfs(m, n, N - 1, x, y, memo) % mod) % mod;
        }

        return memo[i][j][N];
    }
}
