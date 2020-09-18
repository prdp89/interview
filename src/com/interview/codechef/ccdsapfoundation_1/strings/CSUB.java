package com.interview.codechef.ccdsapfoundation_1.strings;

import java.util.Scanner;

public class CSUB {

    //https://www.codechef.com/problems/CSUB

    public static void main( String[] args ) {
        try {
            Scanner scanner = new Scanner(System.in);
            int t = scanner.nextInt();

            while (t-- > 0) {
                int n = scanner.nextInt();
                char[] str = scanner.next().toCharArray();
                int totalOne = 0;

                for (char c : str) {
                    if (c == '1')
                        totalOne++;
                }

                System.out.println((totalOne * (totalOne + 1) / 2));
            }
        } catch (Exception e) {
            return;
        }
    }
}
