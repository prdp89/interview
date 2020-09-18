package com.interview.codingblocks.week9DynamicProgrammming;

public class MaxSizeSquareSubMatrix {

    private static int result = 0;

    //https://www.geeksforgeeks.org/maximum-size-sub-matrix-with-all-1s-in-a-binary-matrix/
    //https://www.youtube.com/watch?v=FO7VXDfS8Gk

    public static void main( String[] args ) {

        int M[][] = {
                {
                        0, 1, 1, 0, 1
                },
                {
                        1, 1, 0, 1, 0
                },
                {
                        0, 1, 1, 1, 0
                },
                {
                        1, 1, 1, 1, 0
                },
                {
                        1, 1, 1, 1, 1
                },
                {
                        0, 0, 0, 0, 0
                }
        };

        maxSizeMatrixRecursive(6 - 1, 5 - 1, M);
        System.out.println("Using recursion : " + result);

        //using bottom up DP
        maxSizeMatrixBottomUpDP(M);
    }

    //https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/531/week-4/3312/
    private static void maxSizeMatrixBottomUpDP( int[][] M ) {

        int S[][] = new int[6][5];

        /* Set first column of S[][]*/
        for (int i = 0; i < 6; i++)
            S[i][0] = M[i][0];

        /* Set first row of S[][]*/
        for (int j = 0; j < 5; j++)
            S[0][j] = M[0][j];

         /* Construct other entries of S[][]*/
        for (int i = 1; i < 6; i++) {
            for (int j = 1; j < 5; j++) {
                if (M[i][j] == 1)
                    S[i][j] = Math.min(S[i][j - 1],
                            Math.min(S[i - 1][j], S[i - 1][j - 1])) + 1;
                else
                    S[i][j] = 0;
            }
        }

        int max_of_s = S[0][0];
        int max_i = 0;
        int max_j = 0;

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 5; j++) {
                if (max_of_s < S[i][j]) {
                    max_of_s = S[i][j];
                    max_i = i;
                    max_j = j;
                }
            }
        }

        System.out.println("Max size matrix is: " + max_of_s);

        System.out.println("Maximum size sub-matrix is: ");

        for (int i = max_i; i > max_i - max_of_s; i--) {

            for (int j = max_j; j > max_j - max_of_s; j--) {

                System.out.print(M[i][j] + " ");
            }

            System.out.println();
        }
    }

    private static int maxSizeMatrixRecursive( int i, int j, int[][] M ) {

        if (i < 0 || j < 0)
            return 0;

        int val;
        if (M[i][j] == 1) {

            //Min taken bcz, if right, diagonal and bottom is '1' then Min{1,1,1} = 1
            //Otherwise, if any element is zero then Min{0, 1, 1} = 0

            val = 1 + Math.min(maxSizeMatrixRecursive(i, j - 1, M),
                    Math.min(maxSizeMatrixRecursive(i - 1, j, M),
                            maxSizeMatrixRecursive(i - 1, j - 1, M)));
        } else {

            val = Math.min(maxSizeMatrixRecursive(i, j - 1, M),
                    Math.min(maxSizeMatrixRecursive(i - 1, j, M),
                            maxSizeMatrixRecursive(i - 1, j - 1, M)));
        }

        result = Math.max(result, val);
        return val;
    }


}
