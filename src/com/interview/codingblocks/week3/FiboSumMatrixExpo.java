package com.interview.codingblocks.week3;

import java.util.Scanner;

public class FiboSumMatrixExpo {

    private final static long MOD = 1000000007; //taken bcz result be very large

    //this method just getting sum of fibonacci numbers from 0 - N
    private static void solve() {
        Scanner scanner = new Scanner(System.in);

        //int testCases = scanner.nextInt();
        long n, m;

        //  while (testCases-- > 0) {

        n = scanner.nextLong();

        long[] F1 = {0, 1, 1};
        long T[][] = new long[][]{{0, 1, 0}, {1, 1, 0}, {1, 1, 1}};

        long TMatrixN[][] = pow(T, n + 1);

        long resultN, resultM;
        resultM = resultN = 0;

        for (int i = 0; i < F1.length; i++) {
            resultN = (resultN + (TMatrixN[1][i] * F1[i]) % MOD) % MOD;
        }

        System.out.println((resultM - 1));
    }

    private static void solveFiboSum() {

        //source : https://www.quora.com/How-do-I-solve-the-FIBOSUM-Problem-on-SPOJ
        // fibonacci    : 0  1  1  2  3  5    8  13  21
        // Sum of Fibo : 0  1  2  4  7  12  20  33  54

        //sum(x) = fib(x+2)-1
        //Means if we want to calculate Sum of 0 - 5 fibonacci numbers then:
        // sum(5) = fib(5 + 2) - 1 => fib(7) - 1 => check 7th element in fibonacci series
        //        = 13 - 1 => 12
        //so sum(5) = 12

        //similarly, if we wnat to calculate Range of Fibonacci :
        //Range(m , n ) where m > n then formula = Fib(m + 2) - Fib(n + 1)

        //general formula to calculate range of Fibonacci numbers are : fib( m + 2 ) - fib(n + 1)


        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();
        long n, m;

        while (testCases-- > 0) {

            n = scanner.nextLong();
            m = scanner.nextLong();

            long[] F1 = {0, 1};
            long T[][] = new long[][]{{0, 1}, {1, 1}};

            if (n <= 0)
                n = 1;

            //normally we do T ^ n - 1 to calculate nth fibonacci
            //but for N : we have to do fib(n + 1); so n + 1 - 1 => n => T ^ n
            long TMatrixN[][] = pow(T, n);

            if (m <= 0)
                m = 1;

            //normally we do T ^ n - 1 to calculate nth fibonacci
            //but for M : we have to do fib(m + 2); so m + 2 - 1 => m  + 1 => T ^ m + 1
            long TMatrixM[][] = pow(T, m + 1);

            long resultN, resultM;
            resultM = resultN = 0;

            for (int i = 0; i < F1.length; i++) {
                resultN = (resultN + (TMatrixN[1][i] * F1[i]) % MOD) % MOD;
                resultM = (resultM + (TMatrixM[1][i] * F1[i]) % MOD) % MOD;
            }

            /*

            Lets say you have x = 2 and y = 5 with constraints 0 <= x <= y <= 1000
            ( similar to those constraints ), now you need to print result = f(y) - f(x)
            where f() is a monotonically increasing function. Now, f(y) is always greater than
             or equal to f(x), but you decide to put a modulus in the return value of the function.

              Lets say mod = 13. Now, say f(2) returns 11 and f(5) returns 16.
               But since you’re returning the value %13, the variable result which stores f(5) - f(2) now,
                gets a value of 16%13 - 11%13 = -8. So in this case you need to do result += 13 i.e.
                 result will have 5 which was supposed to be the correct answer(16-11).

             */
            System.out.println(((resultM - resultN) + MOD) % MOD);
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

    public static void main( String[] args ) {
        solveFiboSum();
    }
}
