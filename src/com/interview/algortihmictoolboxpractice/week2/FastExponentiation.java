package com.interview.algortihmictoolboxpractice.week2;

public class FastExponentiation {

    public static void main(String[] args) {
        final FastExponentiation exponentiation = new FastExponentiation();
        System.out.println(exponentiation.power(5, 6));
        System.out.println(exponentiation.power(5, 6, 3));
    }

    private int power(final int a, final int N) {
        if (N == 0) {
            return 1;
        } else {
            final int R = power(a, N / 2);
            if (N % 2 == 0) {
                return R * R;
            } else {
                return R * R * a;
            }
        }
    }

    private long power(final int a, final int N, int M) {
        if (N == 0) {
            return 1;
        } else {
            final long R = power(a, N / 2, M);
            if (N % 2 == 0) {
                return (R * R) % M;
            } else {
                return (R * R * a) % M;
            }
        }
    }
}
