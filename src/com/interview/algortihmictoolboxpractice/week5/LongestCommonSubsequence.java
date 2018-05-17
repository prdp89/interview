package com.interview.algortihmictoolboxpractice.week5;

import java.util.Scanner;

public class LongestCommonSubsequence {

    public static void main( String[] args ) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }

        int o = scanner.nextInt();
        int[] c = new int[o];
        for (int i = 0; i < o; i++) {
            c[i] = scanner.nextInt();
        }

        //  System.out.println(lcs2(a, b));

        System.out.println(lcsOf3(a, b, c, n, m, o));

    }

    private static int lcs2( int[] str1, int[] str2 ) {
        int temp[][] = new int[str1.length + 1][str2.length + 1];
        int max = 0;
        for (int i = 1; i < temp.length; i++) {
            for (int j = 1; j < temp[i].length; j++) {
                if (str1[i - 1] == str2[j - 1]) {
                    temp[i][j] = temp[i - 1][j - 1] + 1;
                } else {
                    temp[i][j] = Math.max(temp[i][j - 1], temp[i - 1][j]);
                }
                if (temp[i][j] > max) {
                    max = temp[i][j];
                }
            }
        }
        return max;
    }

    /* Returns length of LCS for X[0..m-1], Y[0..n-1]
      and Z[0..o-1] */
    static int lcsOf3( int[] X, int[] Y, int[] Z, int m,
                       int n, int o ) {
        int[][][] L = new int[m + 1][n + 1][o + 1];

        /* Following steps build L[m+1][n+1][o+1] in
           bottom up fashion. Note that L[i][j][k]
           contains length of LCS of X[0..i-1] and
           Y[0..j-1]  and Z[0.....k-1]*/

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= o; k++) {

                  /*  if (i == 0 || j == 0 || k == 0)
                        L[i][j][k] = 0;*/

                    if (X[i - 1] == Y[j - 1]
                            && X[i - 1] == Z[k - 1])
                        L[i][j][k] = L[i - 1][j - 1][k - 1] + 1;

                    else
                        L[i][j][k] = Math.max(Math.max(L[i - 1][j][k],
                                L[i][j - 1][k]),
                                L[i][j][k - 1]);
                }
            }
        }

        /* L[m][n][o] contains length of LCS for
          X[0..n-1] and Y[0..m-1] and Z[0..o-1]*/
        return L[m][n][o];
    }
}
