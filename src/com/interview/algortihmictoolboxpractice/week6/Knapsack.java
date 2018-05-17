//package com.interview.algortihmictoolboxpractice.week6;

import java.util.*;

public class Knapsack {
    private static int optimalWeight( int W, int[] w ) {
        //write you code here
        int result = 0;
        for (int aW : w) {
            if (result + aW <= W) {
                result += aW;
            }
           /* else {
                result +=(W - result);
            }*/
        }
        return result;
    }


    private static int bottomUpDP( int wt[], int W ) {
        int K[][] = new int[wt.length + 1][W + 1];

        for (int i = 0; i <= wt.length; i++) {
            for (int j = 0; j <= W; j++) {
                if (i == 0 || j == 0) {
                    K[i][j] = 0;
                    continue;
                }

                if (wt[i - 1] == j)
                    K[i][j] = wt[i - 1];
                else if (j > wt[i - 1]) {

                   /* if (wt[i - 1] + K[i - 1][j] > j)
                        K[i][j] = Math.max(K[i - 1][j - wt[i - 1]] + wt[i - 1], j - wt[i - 1] + wt[i - 1]);
                    else
                        K[i][j] = wt[i - 1] + K[i - 1][j];*/

                   K[i][j] = Math.max(wt[i-1] + K[i-1][j-wt[i-1]], K[i-1][j]);
                } else
                    K[i][j] = K[i - 1][j];
            }
        }
        return K[wt.length][W];
    }

    public static void main( String[] args ) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];

        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }

       /* Arrays.sort(w);

        for (int i = 0; i < n; i++) {
            w[i] *= -1;
        }*/

        System.out.println(bottomUpDP(w, W));

        // System.out.println(optimalWeight(W, w));
    }
}

