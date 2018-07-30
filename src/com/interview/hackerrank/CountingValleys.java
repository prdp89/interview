package com.interview.hackerrank;

public class CountingValleys {

    private static void solve() {
        char[] s = "UDDDUDUU".toCharArray();

        int seaLevelReached = 0, valleyCount = 0;

        for (char ch : s) {

            if (ch == 'U' || ch == 'u') {
                seaLevelReached++;
            } else if (ch == 'D' || ch == 'd') {
                seaLevelReached--;
            }

            if (seaLevelReached == 0 && ch == 'U')
                valleyCount++;
        }

        System.out.println(valleyCount);
    }

    public static void main( String[] args ){
        solve();
    }
}
