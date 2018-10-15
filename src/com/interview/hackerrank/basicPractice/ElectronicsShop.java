package com.interview.hackerrank.basicPractice;

import java.io.*;
import java.util.*;

public class ElectronicsShop {

    /*
    * Complete the getMoneySpent function below.
    */
    private static int getMoneySpent( Integer[] keyboards, int[] drives, int b ) {
        /*
         * Write your code here.
         */
        Arrays.sort(keyboards, Collections.reverseOrder());
        Arrays.sort(drives);

        int max = -1;
        for (int i = 0, j = 0; i < keyboards.length; i++) {
            for (; j < drives.length; j++) {
                if (keyboards[i] + drives[j] > b) {
                    break;
                }
                if (keyboards[i] + drives[j] > max) {
                    max = keyboards[i] + drives[j];
                }
            }
        }
        return max;
    }

    public static void main( String[] args ) throws IOException {

        Scanner scanner = new Scanner(System.in);

        int b = scanner.nextInt();

        int n = scanner.nextInt();

        int m = scanner.nextInt();

        Integer[] keyboards = new Integer[n];

        for (int keyboardsItr = 0; keyboardsItr < n; keyboardsItr++) {
            keyboards[keyboardsItr] = scanner.nextInt();
        }

        int[] drives = new int[m];

        for (int drivesItr = 0; drivesItr < m; drivesItr++) {
            drives[drivesItr] = scanner.nextInt();
        }

        /*
         * The maximum amount of money she can spend on a keyboard and USB drive, or -1 if she can't purchase both items
         */

        int moneySpent = getMoneySpent(keyboards, drives, b);

        System.out.println(moneySpent);

        scanner.close();
    }
}
