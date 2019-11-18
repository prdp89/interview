package com.interview.codechef.contest.sept2019longchallenge;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class FIBEASY {

    private final static long MOD = 1000000000; //taken bcz result be very large

    //https://www.codechef.com/SEPT19B/problems/FIBEASY
    public static void main( String[] args ) {

        Scanner scanner = new Scanner(System.in);
        //int t = scanner.nextInt();


        //while (t-- > 0) {
        //System.out.println(getFibEasy(scanner.nextLong()));
        //}

        System.out.println(getFibEasy(scanner.nextLong()));
    }

    private static long getFibEasy( long num ) {

        Long[] arr = new Long[(int) num];

        arr[0] = (long) 0;
        arr[1] = (long) 1;
        arr[2] = (long) 1;
        arr[3] = (long) 2;
        arr[4] = (long) 3;
        arr[5] = (long) 5;
        arr[6] = (long) 8;

        long num1 = nthFiboNacci(num);
        long num2 = nthFiboNacci(num - 1);

        arr[(int) num - 1] = num1;
        arr[(int) num - 2] = num2;

        for (int i = (int) num - 3; i > 6; i--) {
            arr[i] = arr[i + 2] - arr[i + 1];

            //arr[i + 2] %= 10;
        }

        List<Long> list = new LinkedList<>(Arrays.asList(arr));

        while (list.size() != 1) {

            int i = 0;

            while (i < list.size()) {
                list.remove(i++);
            }
        }

        return list.get(0) % 10;
    }

    private static long nthFiboNacci( long num ) {
        long[] F1 = {0, 1};

        //step-2: create transformation matrix ; for fibonacci we already know this
        long T[][] = new long[][]{{0, 1}, {1, 1}};

        //step-3 : T ^ N - 1
        long TNMatrix[][] = pow(T, num - 2);
        long result = 0;

        //Step 4 : multiply : T^N-1 * F1
        for (int i = 0; i < F1.length; i++) {
            result = (result + (TNMatrix[1][i] * F1[i]) % MOD) % MOD;
        }

        return result;
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

}
