package com.interview.codechef.ccdsap_2.atcoder.begcontest133;

import java.util.Scanner;

public class TOrT {

    //https://atcoder.jp/contests/abc133/tasks/abc133_a
    public static void main( String[] args ) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.println(Math.min(a * n, b));
    }
}
