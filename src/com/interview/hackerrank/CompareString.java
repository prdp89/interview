package com.interview.hackerrank;

import java.util.Arrays;
import java.util.Scanner;

public class CompareString {

    private static void solve() {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            String s1 = scanner.next();
            String s2 = scanner.next();


            char[] c1 = s1.toCharArray();
            char[] c2 = s2.toCharArray();

            Arrays.sort(c1);
            Arrays.sort(c2);
            String s3 = new String(c1);
            String s4 = new String(c2);


            if (s3.equals(s4)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    public static void main( String[] args ) {
        solve();
    }
}
