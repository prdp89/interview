package com.interview.codechef.ccdsapfoundation.arrays;

import java.util.Scanner;

public class COPS {
    //https://www.codechef.com/problems/COPS

    public static void main( String[] args ) {
        try {
            Scanner scanner = new Scanner(System.in);
            int t = scanner.nextInt();

            while (t-- > 0) {
                int m = scanner.nextInt();
                int x = scanner.nextInt();
                int y = scanner.nextInt();

                int totalDistance = x * y;

                int[] arr = new int[101];

                while (m-- > 0) {
                    int houseNumber = scanner.nextInt();
                    int prev = houseNumber - totalDistance;
                    int next = houseNumber + totalDistance;

                    if (prev < 1) //if cops can cover till origin house no. 1
                        prev = 1;

                    if (next > 100) //if cop can cover max. = 100
                        next = 100;

                    for (int j = prev; j <= next; j++) {
                        arr[j] = 1;
                    }
                }

                int count = 0;
                for (int k = 1; k <= 100; k++) {
                    if (arr[k] != 1) //where cop can hide
                        count++;
                }
                System.out.println(count);
            }
        } catch (Exception e) {
            return;
        }
    }
}
