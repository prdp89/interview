package com.interview.codechef.ccdsapfoundation_1.arrays;

import java.util.Scanner;

public class LECANDY {
    public static void main( String[] args ) {

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            int numberOfElephants = scanner.nextInt();
            int candies = scanner.nextInt();

            int[] arr = new int[numberOfElephants];
            int sum = 0;

            for (int i = 0; i < arr.length; i++) {
                arr[i] = scanner.nextInt();
                sum += arr[i];
            }

            if (candies >= sum) {
                System.out.println("Yes");
                return;
            }
            System.out.println("No");
        }
    }
}
