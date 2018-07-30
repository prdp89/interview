package com.interview.hackerrank;

public class FindDigits {

    private static void solve() {
        int n = 111, count = 0;

        while (n != 0) {
            if (n % 10 != 0 && n % (n % 10) == 0)
                count++;

            n /= 10;
        }

        System.out.println(count);
    }

    public static void main( String[] args ) {
        solve();
    }
}
