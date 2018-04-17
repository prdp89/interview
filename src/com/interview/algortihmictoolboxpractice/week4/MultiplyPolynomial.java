package com.interview.algortihmictoolboxpractice.week4;

import java.util.Arrays;

public class MultiplyPolynomial {

    private static void polyMultON2( int[] a, int b[], int m, int n ) {
        int prod[] = new int[m + n - 1];

        for (int i = 0; i < m + n - 1; i++)
            prod[i] = 0;

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                prod[i + j] = prod[i + j] + a[i] * b[j];

        System.out.println(Arrays.toString(prod));
    }

    private static int[] polyMultON( int[] a, int[] b, int[] r, int n, int ai, int bi ) {

        if (n == 1) {
            r[0] = a[ai] * b[bi];
            return r;
        }

        return r;
    }

    public static void main( String[] args ) {
        //polyMultON2(new int[]{3, 2, 5}, new int[]{5, 1, 2}, 3, 3);

        polyMultON(new int[]{3, 2, 5}, new int[]{5, 1, 2}, new int[5], 5, 0, 0);
    }
}
