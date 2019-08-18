package com.interview.codechef.ccdsap_2.atcoder.begcontest136;

import java.util.Scanner;

public class BuidStairs {

    //https://atcoder.jp/contests/abc136/tasks/abc136_c

    //11/13 test passed :)
    //correct one : https://atcoder.jp/contests/abc136/submissions/6716613
    public static void main( String[] args ) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        if (n == 1) {
            System.out.println("Yes");
            return;
        }

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1])
                arr[i - 1]--;
        }

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                System.out.println("No");
                return;
            }
        }

        System.out.println("Yes");
    }
}
