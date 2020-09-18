package com.interview.codechef.ccdsapfoundation_1.DP.GFG;

public class EndlessPointsMatrix {

    //https://www.geeksforgeeks.org/find-number-endless-points/
    //https://www.codechef.com/problems/GRID
    public static void main( String[] args ) {

        boolean input[][] = {
                {true, false, true, true},
                {false, true, true, true},
                {true, true, true, true},
                {false, true, true, false}};

        //System.out.println(recurse(input, 0, 0));

        System.out.println(countEndless(input, input.length));
    }

    private static int countEndless( boolean[][] input, int n ) {

        boolean row[][] = new boolean[n][n];
        boolean col[][] = new boolean[n][n];

        // Fills column matrix. For every column,
        // start from every last row and fill every
        // entry as blockage after a 0 is found.
        for (int j = 0; j < n; j++) {

            // flag which will be zero once we get
            // a '0' and it will be 1 otherwise
            boolean isEndless = true;
            for (int i = n - 1; i >= 0; i--) {

                // encountered a '0', set the
                // isEndless variable to false
                if (input[i][j] == false)
                    isEndless = false;

                col[i][j] = isEndless;
            }
        }

        // Similarly, fill row matrix
        for (int i = 0; i < n; i++) {

            boolean isEndless = true;
            for (int j = n - 1; j >= 0; j--) {

                if (input[i][j] == false)
                    isEndless = false;

                row[i][j] = isEndless;
            }
        }

        // Calculate total count of endless points
        int ans = 0;
        for (int i = 0; i < n; i++)
            for (int j = 1; j < n; j++)

                // If there is NO blockage in row or column after this point,
                // increment result.
                if (row[i][j] && col[i][j])
                    ans++;

        return ans;
    }

    //unable to solve using recursion
    private static int recurse( boolean[][] input, int i, int j ) {

        if (i >= input.length || j >= input.length)
            return 0;

        if (i == input.length - 1)
            return input[i][j] ? 1 : 0;

        if (j == input.length - 1)
            return input[i][j] ? 1 : 0;

        int traverseLeft = recurse(input, i + 1, j);
        int traverseRight = recurse(input, i, j + 1);

        return 1 + Math.max(traverseLeft, traverseRight);
    }
}
