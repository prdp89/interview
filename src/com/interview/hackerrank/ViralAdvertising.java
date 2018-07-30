package com.interview.hackerrank;

public class ViralAdvertising {

    private static void solve() {
        int n = 3, shared = 5, output = 0;

        for (int i = 0; i < n; i++) {
            int liked = (int)Math.floor(shared / 2);
            output = output + liked;
            shared = liked * 3;
        }

        System.out.println(output);
    }

    public static void main( String[] args ) {
        solve();
    }
}
