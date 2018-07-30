package com.interview.codingblocks.week1;

import java.util.Scanner;

public class CountSetBits {

    public static void main( String[] args ) {
        solve();
    }

    //This is second method to count bits, another way is : N & (N-1)
    private static void solve() {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int ans = 0;

        while (n > 0) {

            int p = n & (-n);

            n = n - p;

            ans++;
        }

        System.out.println(ans);
    }
}
