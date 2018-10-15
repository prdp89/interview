package com.interview.hackerrank.basicPractice;

import java.util.Scanner;

public class FairRations {

    //https://www.hackerrank.com/challenges/fair-rations/problem
    public static void main( String[] args ) {
        solve();

    }

    private static void solve() {
        int b[] = {4, 5, 6, 7};

        for (int i = 0; i < b.length; i++) {

            int k = i;
            for (int j = i + 1; j < b.length; j++) {

                if (b[k] % 2 != 0 && b[j] % 2 == 0)
                    break;

                k++;
            }

            b[i] = b[i] + 1;

            if (k < b.length)
                b[k] = b[k] + 1;
        }

        int count = 0;
        boolean notPossible = true;
        for (int i = 0; i < b.length; i++) {
            if (b[i] % 2 == 0)
                count++;
            else {
                notPossible = false;
                break;
            }
        }

        if (!notPossible)
            System.out.println("NO");
        else if (count == b.length)
            System.out.println(count);
        else
            System.out.println(count);
    }

    //Just sum the value to check if its odd; If it is odd then Loaves will be distributed
    //If sum is even then Count is result else not possible.
    private static void solveOptimal() {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int sum = 0;
        int count = 0;

        for (int i = 0; i < N; i++) {
            sum += in.nextInt();

            if (sum % 2 == 1) {
                count += 2;
            }
        }

        System.out.println(sum % 2 == 0 ? count : "NO");
    }
}
