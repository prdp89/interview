package com.interview.algortihmictoolboxpractice.week5;

/*

You are given a primitive calculator that can perform the following three operations with
 the current number x: multiply x by 2, multiply x by 3, or add 1 to x.
 Your goal is given a positive integer n, find the minimum number of operations needed to
  obtain the number n starting from the number 1.

Solution Link: http://edusagar.com/questions/dynamic-programming/dynamic-programming-minimum-steps-to-1
 */


/*

GreedyCalculator(n):

 numOperations ← 0

 while n > 1:
 numOperations ← numOperations + 1

 if n mod 3 = 0:
 n ← n/3
 else if n mod 2 = 0:
 n ← n/2
 else:
 n ← n−1

 return numOperations

 */
public class PrimitiveCalculator {

    private static void solve( int n ) {

        int res[] = new int[n + 1];
        int out[] = new int[n + 1];

        res[0] = 0;
        out[0] = 0;

        for (int i = 1; i < n; i++) {
            out[i] = out[i-1] + 1 ;
            res[i] = 1;

            if (i % 2 == 0) {
                if ((out[i / 2] + 1) < out[i]) {
                    res[i] = 2;
                }
                out[i] = Math.min(1 + out[i / 2], out[i]);
            }
            if (i % 3 == 0) {
                if ((out[i / 3] + 1) < out[i]) {
                    res[i] = 3;
                }
                out[i] = Math.min(1 + out[i / 3], out[i]);
            }
        }

        System.out.println(out[n-1]);

        // Print the sequence, we already know the number of steps to print
       /* for (int i = out[n]; i > 0; i--) {
            System.out.println(res[n]);

            if (res[n] == 1) {
                n = n - 1;
            } else if (res[n] == 2) {
                n = n / 2;
            } else {
                n = n / 3;
            }
        }*/

    }

    public static void main( String[] args ) {
        solve(96234);
    }
}
