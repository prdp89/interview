package com.interview.codechef.ccdsap_2.atcoder.begcontest129;

import java.util.Scanner;

public class Airplane {

    //https://atcoder.jp/contests/abc129/tasks/abc129_a
    public static void main( String[] args ) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        System.out.println(Math.min(a + b, Math.min(b + c, c + a)));
    }


}
