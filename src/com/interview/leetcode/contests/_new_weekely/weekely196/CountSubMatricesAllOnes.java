package com.interview.leetcode.contests._new_weekely.weekely196;

public class CountSubMatricesAllOnes {

    //https://leetcode.com/contest/weekly-contest-196/problems/count-submatrices-with-all-ones/
    public static void main( String[] args ) {
        int[][] mat = {
                {1, 0, 1},
                {1, 1, 0},
                {1, 1, 0}
        };

        System.out.println(numSubmat(mat));
    }

    //If we have 1D array then this problem would be really easy as:
    /*
    int res = 0, length = 0;
    for (int i = 0; i < A.length; ++i) {
        length = (A[i] == 0 ? 0 : length + 1);
        res += length;
    }
    return res;
     */
    private static int numSubmat( int[][] mat ) {
        int[][] arr = new int[mat.length][mat[0].length];

        int m = mat.length, n = mat[0].length;

        //we are computing row wise count of SubMatrices {same way as 1D array}
        for (int i = 0; i < m; i++) {

            int c = 0;
            for (int j = 0; j < n; j++) {

                if (mat[i][j] == 1) {
                    c++;
                } else {
                    c = 0;
                }

                arr[i][j] = c;
            }
        }

        int ans = 0;
        //NOw we fix a Anchor point for a Matrix element and scan it vertically too..
        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {
                // i, j is the top most left point of the rectangle which is fixed
                int x = Integer.MAX_VALUE;

                for (int k = i; k < m; k++) {
                    x = Math.min(x, arr[k][j]); //calc. MIN bcz {1,0} min is 0 so we ans += 0;
                    ans += x;
                }
            }
        }

        return ans;
    }
}
