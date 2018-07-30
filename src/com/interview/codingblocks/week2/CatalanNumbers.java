package com.interview.codingblocks.week2;


import java.util.Scanner;

public class CatalanNumbers {

    private static int dp[] = new int[50];

    //This solution helps to print number to ways to print BST or
    // Number of ways to place paranthesis.
    private static int catalanNumbers( int n ) {
        if (n == 0)
            return 1;

        int ans = 0;
        //for picking each i from 1... N
        for (int i = 1; i <= n; i++) {

            ans += catalanNumbers(i - 1) * catalanNumbers(n - i);

        }

        return ans;
    }

    private static int catalanNumbersDPMethod( int n ) {
        if (n == 0)
            return 1;

        //if already calculated
        if (dp[n] != 0)
            return dp[n];

        int ans = 0;
        //for picking each i from 1... N
        for (int i = 1; i <= n; i++) {

            ans += catalanNumbers(i - 1) * catalanNumbers(n - i);

        }

        //if computing for the first time then init DP array
        dp[n] = ans;

        return ans;
    }

    private static long catalanNumbers2NCNFormula( int n, int k ) {

        // Calculate value of 2nCn
        long c = binomialCoeff(2 * n, k);

        // return 2nCn/(n+1)
        return c / (n + 1);
    }

    // Returns value of Binomial Coefficient C(n, k)
    //source : https://www.geeksforgeeks.org/space-and-time-efficient-binomial-coefficient/
    private static long binomialCoeff( int n, int k ) {
        long res = 1;

        // Since C(n, k) = C(n, n-k)
        //check pascal triangle for Proof of : n C K = n C n - k
        if (k > n - k)
            k = n - k;

        // Calculate value of [n * (n-1) *---* (n-k+1)] / [k * (k-1) *----* 1]
        for (int i = 0; i < k; ++i) {
            res *= (n - i);
            res /= (i + 1);
        }

        return res;
    }

    public static void main( String[] args ) {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        //NTh catalan number
        System.out.println(catalanNumbers2NCNFormula(N , 7));

        //printing first N catalan numbers
       /* for (int i = 0; i <= N; i++) {
            //System.out.println(catalanNumbers(i));

            //System.out.println(catalanNumbersDPMethod(i));

            System.out.println(catalanNumbers2NCNFormula(i));
        }*/
    }
}
