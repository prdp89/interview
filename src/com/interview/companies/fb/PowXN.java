package com.interview.companies.fb;

public class PowXN {

    public static void main( String[] args ) {
        System.out.println(myPow(2.100, 3));
    }

    private static double myPow( double x, int n ) {
        if (n == 0)
            return 1;

        if (n < 0) {
            n = -n;
            x = 1 / x;
        }

        return n % 2 == 0 ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }

    private double myPowOPtimal( double n, int m ) {

        if (m == 0) {
            return 1;
        }

        double pow = myPowOPtimal(n, m / 2);

        if (m % 2 == 0) {
            return pow * pow;
        } else if (m < 0) {
            return pow * pow * (1 / n);
        } else {
            return n * pow * pow;
        }
    }
}
