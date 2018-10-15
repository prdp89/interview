package com.interview.hackerrank.InterviewPreprationKit;

public class TwoDArrayDS {

    private static void solve() {
        int[][] arr = {{1, 1, 1, 0, 0, 0},
                {0, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0},
                {0, 0, 2, 4, 4, 0},
                {0, 0, 0, 2, 0, 0},
                {0, 0, 1, 2, 4, 0}};

        for (int i = 0; i < arr.length - 3; i++) {

            for (int j = 0; j < arr.length; j++) {

                //if (j < arr.length - 2 && i < arr.length - 2) {

                int sum = 0, count = 0;
                for (int k = i; k < 3; k++) {

                    int innerCount = 0;
                    for (int l = j; l < 3; l++) {

                        if (count == 0 || count == 2) {
                            sum += arr[k][l];
                        } else if (count == 1 && innerCount == 1) {
                            sum += arr[k][l];
                        }
                        innerCount++;
                    }

                    count++;
                }

                System.out.print(sum + " ");
            }

            //}
        }
    }

    public static void newSolve() {
        /*int[][] arr = {{1, 1, 1, 0, 0, 0},
                {0, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0},
                {0, 0, 2, 4, 4, 0},
                {0, 0, 0, 2, 0, 0},
                {0, 0, 1, 2, 4, 0}};*/

        int[][] arr = {{-1, -1, 0, -9, -2, -2},
                {-2, -1, -6, -8, -2, -5},
                {-1, -1, -1, -2, -3, -4},
                {-1, -9, -2, -4, -4, -5},
                {-7, -3, -3, -2, -9, -9},
                {-1, -3, -1, -2, -4, -5}};

        int sum = Integer.MIN_VALUE;
        for (int i = 0; i < 4; i++) {
            int j = 0;
            int temp;
            while (j < 4) {
                temp = arr[i][j] + arr[i][j + 1] + arr[i][j + 2] +
                        +arr[i + 1][j + 1] +
                        arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2];

                sum = Math.max(temp, sum);
                j++;

            }
        }
        System.out.println(sum);
    }

    public static void main( String[] args ) {
        // solve();
        newSolve();
    }
}
