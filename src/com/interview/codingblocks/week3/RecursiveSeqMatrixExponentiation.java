package com.interview.codingblocks.week3;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//question SPOJ : https://www.spoj.com/problems/SEQ/
//question CB : https://hack.codingblocks.com/contests/c/473/757
public class RecursiveSeqMatrixExponentiation {

    private final static long MOD = 1000000000; //taken bcz result be very large
    static long testCases, n, k;
    private static List<Long> b, c;

    private static void solve() {

        Scanner scanner = new Scanner(System.in);
        testCases = scanner.nextLong();

        while (testCases-- > 0) {

            //number of elements of c[] & b[]
            k = scanner.nextLong();

            //b is a F(1) vector
            b = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                b.add(scanner.nextLong());
            }

            //c is a coefficients vector
            c = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                c.add(scanner.nextLong());
            }

            //n for nth natural number
            n = scanner.nextLong();

            System.out.println(compute(n));

            b.clear();
            c.clear();
        }
    }

    private static long compute( long n ) {
        if (n == 0)
            return 0;
        else if (n <= k) //if Nth element is less than Kth element {means we already have that number in b[] array}
        {
            return b.get((int) n - 1);
        }
        //otherwise use Matrix exponentiation

        //Step 1 : Now we have to generate F1 vector from b[] array
        long[] F1 = new long[(int) k + 1];

        long bthElement;
        for (int i = 1; i <= k; i++) {
            bthElement = b.get(i - 1);
            F1[i] = bthElement;
        }

        //Step2 : Create a Transformation Matrix, This matrix should be of Size K+1
        long transformationMatrix[][] = new long[(int) k + 1][(int) k + 1];

        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= k; j++) {

                if (i < k) { //means we are not in last row

                    if (j == i + 1) { //checking a diagonal row
                        transformationMatrix[i][j] = 1;
                    } else
                        transformationMatrix[i][j] = 0;

                    continue;
                }
                //At Last row - store the coefficients in reverse order.
                //K-J done to get last element of 'C' list
                transformationMatrix[i][j] = c.get((int) k - j);
            }
        }

        //step 3 : Compute T ^ N - 1
        transformationMatrix = power(transformationMatrix, n - 1);

        //step 4 : (T ^ N - 1) * F1
        //our final result will be in zero th row of result.
        long res = 0;

        for (int i = 1; i <= k; i++) {

            //multiplying Transformation Matrix first Row with F1
            res = (res + (transformationMatrix[1][i] * F1[i]) % MOD) % MOD;
        }

        return res;
    }

    private static long[][] power( long[][] transformationMatrix, long raiseToThePower ) {
        if (raiseToThePower == 1) { //if matrix power is 1
            return transformationMatrix;
        }

        //Recursion to calculate power
        // X ^ a = ( X ^ a/2 ) ^ 2 : if a is even
        // X ^ a = X. ( X ^ a/2 ) ^ 2 : if a is odd

        if ((raiseToThePower & 1) != 0) { //if last digit is set; odd case
            return multiply(transformationMatrix,
                    power(transformationMatrix, raiseToThePower - 1));
        } else {
            long[][] result = power(transformationMatrix, raiseToThePower / 2);
            return multiply(result, result);
        }
    }

    private static long[][] multiply( long[][] A, long[][] B ) {

        long[][] resultMatrix = new long[(int) k + 1][(int) k + 1];

        //loop starts from 1 bcz transformationMatrix is filled from 1.
        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= k; j++) {
                for (int x = 1; x <= k; x++) {
                    resultMatrix[i][j] = (resultMatrix[i][j] + (A[i][x] * B[x][j]) % MOD) % MOD;
                }
            }
        }

        return resultMatrix;
    }

    public static void main( String[] args ) {
        solve();
    }
}
