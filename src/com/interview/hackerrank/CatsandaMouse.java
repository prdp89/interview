package com.interview.hackerrank;

public class CatsandaMouse {

    private static void solve() {
        int x = 1, y = 3, z = 2;

        int catADiff = Math.abs(z - x);
        int catBDiff = Math.abs(z - y);

        if (catADiff == catBDiff)
            System.out.println("Mouse C");
        else if (catADiff < catBDiff)
            System.out.println("Cat A");
        else
            System.out.println("Cat B");
    }

    public static void main( String[] args ) {
        solve();
    }
}
