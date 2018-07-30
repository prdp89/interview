package com.interview.codingblocks.week2;

import java.util.Scanner;

public class MatrixExponenFibo {

    private final static long MOD = 1000000000; //taken bcz result be very large

    public static void main( String[] args ) {
        solve();
    }

    private static void solve() {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        while (t-- > 0) {
            int nthFiboNumber = scanner.nextInt();


            //step-1: Determine	the	F1	vector
           /* vector<ll> F1 (k + 1);
            for (int i = 1; i < k + 1; i++) F1[i] = b[i - 1];*/

            //in case of Fibonacci it is ist two terms of fibonacci
            long[] F1 = {0, 1};


            //step-2: create transformation matrix ; for fibonacci we already know this
            long T[][] = new long[][]{{0, 1}, {1, 1}};

            //step-3 : T ^ N - 1
            long TNMatrix[][] = pow(T, nthFiboNumber - 1);
            long result = 0;

            //Step 4 : multiply : T^N-1 * F1
            for (int i = 0; i < F1.length; i++) {
                result = (result + (TNMatrix[1][i] * F1[i]) % MOD) % MOD;
            }

            System.out.println(result);
        }
    }

    //Finding	T^n-1 using	matrix	exponentiation
    private static long[][] pow( long[][] A, long p ) {
        if (p == 1)
            return A;
        if ((p & 1) != 0)
            return multiply(A, pow(A, p - 1));

        long[][] X = pow(A, p / 2);
        return multiply(X, X);
    }


    private static long[][] multiply( final long[][] matrix1, final long[][] matrix2 ) {
        final long[][] result = new long[matrix1[0].length][matrix2.length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                for (int k = 0; k < matrix1[i].length; k++) {
                    result[i][j] = (result[i][j] + (matrix1[i][k] * matrix2[k][j]) % MOD) % MOD;
                }
            }
        }
        return result;
    }

    /*
    //Space optimized DP solution to Fibonacci by Google Employee
    def fib(n):
    #assumes indexing from zero
    if n == 0 or n == 1:
        return 1
    past, current = 1, 1
    for i in range(2, n + 1):
        past, current = current, past + current
    return current
     */
}
