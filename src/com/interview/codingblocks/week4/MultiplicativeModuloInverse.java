package com.interview.codingblocks.week4;

import java.util.Scanner;

public class MultiplicativeModuloInverse {

    static int finalX, finalY, GCD;

    private static void extendedEuclidGCD( int a, int b ) {

        if (b == 0) {
            //This we already proved while simplifying equation in Notebook
            finalX = 1;
            finalY = 0;
            GCD = a;
            return;
        }

        //this call is similiar to Normal GCD
        extendedEuclidGCD(b, a % b);

        //Now as bottom up approach, after getting X and Y, we replace these values with previous X and Y
        int cX = finalY;
        int cY = finalX - (a / b) * finalY;

        //step by step values
        //System.out.println(cX + " " + cY);

        finalX = cX;
        finalY = cY;

    }

    //https://hack.codingblocks.com/contests/c/473/695
    private static void solve(){
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int mod = 1000000007;

        //step 1 : if basic GCD(N, MOD) == 1 then only extendedEuclidGCD() result X exist. See notes..

        //step 2 : calculate value of X from extended euclid method, and value of X will be our answer.
        extendedEuclidGCD(N, mod);

        // bcz result of finalX can be negative
        System.out.println((finalX + mod) % mod);
    }

    public static void main( String[] args ) {
        solve();
    }
}
