package com.interview.codechef.ccdsapfoundation_1.recursion;

import java.util.Scanner;

public class FICE {

    //ANother example of Matrix Exponentiation
    //https://www.codechef.com/viewsolution/23762919
    public static void main( String[] args ) {
        try {
            Scanner scanner = new Scanner(System.in);

            int t = scanner.nextInt();
            while (t-- > 0) {
                int n = scanner.nextInt();
                int m = scanner.nextInt();

                System.out.println(((n * (n - 1)) / 2) % m);
            }
        } catch (Exception e) {
            return;
        }
    }
}
