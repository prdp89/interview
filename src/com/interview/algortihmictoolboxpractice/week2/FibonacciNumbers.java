//package com.interview.algortihmictoolboxpractice.week2;

import java.util.Scanner;

public class FibonacciNumbers {
    public static void main(String[] args) {
        final FibonacciFinder fibonacciFinder = new FibonacciFinder();
        for (int i = 0; i < 15; i++) {
            System.out.println(fibonacciFinder.fib(i));
        }

      /*  Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        System.out.println(fibNumber(a));*/

       /* Scanner s = new Scanner(System.in);
        System.out.println(getFibonacciLastDigit(s.nextLong()));*/
    }

    //this gets only last digit of large Fabonacii number
    private static int getFibonacciLastDigit(long n) {
        int first = 0;
        int second = 1;

        int res = 0;

        for (int i = 2; i <= n; i++) {
            res = (first + second) % 10;
            first = second;
            second = res;
        }

        return res;
    }

    private static int fibNumber(int n)
    {
        int arr[] = new int[n+2];
        arr[0] = 0;
        arr[1] = 1;

        int i=2;
        for(; i <= n; i++)
        {
            arr[i] = arr[i-1] + arr[i-2];
        }
        return arr[n];
    }
}

class FibonacciFinder {
    private final long[][][] exponents;

    public FibonacciFinder() {
        exponents = new long[64][2][2];
        exponents[0] = new long[][]{{1, 1}, {1, 0}};
        for (int i = 1; i < exponents.length; i++) {
            exponents[i] = square(exponents[i - 1]);
        }
    }

    private long[][] square(final long[][] matrix) {
        return multiply(matrix, matrix);
    }

    private long[][] multiply(final long[][] matrix1, final long[][] matrix2) {
        final long[][] result = new long[matrix1[0].length][matrix2.length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                for (int k = 0; k < matrix1[i].length; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return result;
    }

    /* The multiplication can be improved as :

    void multiply(int F[2][2], int M[2][2])
{
  int x =  F[0][0]*M[0][0] + F[0][1]*M[1][0];
  int y =  F[0][0]*M[0][1] + F[0][1]*M[1][1];
  int z =  F[1][0]*M[0][0] + F[1][1]*M[1][0];
  int w =  F[1][0]*M[0][1] + F[1][1]*M[1][1];

  F[0][0] = x;
  F[0][1] = y;
  F[1][0] = z;
  F[1][1] = w;
}

     */

    public long fib(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        } else if (n == 0 || n == 1) {
            return 1;
        } else {
            final long[][] matrix = binaryExponentiation(n - 1);
            return matrix[0][0] + matrix[0][1];
        }
    }

    private long[][] binaryExponentiation(final int n) {
        long[][] result = new long[][]{{1, 0}, {0, 1}};
        for (int i = 31; i >= 0; i--) {
            if ((n & (1 << i)) != 0) {  //checking if ith bit of number is set
                result = multiply(result, exponents[i]);
            }
        }
        return result;
    }
}
