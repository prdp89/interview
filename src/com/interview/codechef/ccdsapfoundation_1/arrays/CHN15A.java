package com.interview.codechef.ccdsapfoundation_1.arrays;

import java.util.Scanner;

public class CHN15A {

    public static void main( String[] args ) {
        try {
            Scanner scanner = new Scanner(System.in);
            int t = scanner.nextInt();

            while (t-- > 0) {

                int n = scanner.nextInt();
                int k = scanner.nextInt();
                int count = 0;

                while (n-- > 0) {
                    int minion = scanner.nextInt();
                    if ((minion + k) % 7 == 0) {
                        count++;
                    }
                }

                System.out.println(count);
            }
        } catch (Exception e) {
            return;
        }
    }
}
