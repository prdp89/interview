package com.interview.hackerrank.InterviewPreprationKit;

import java.util.Arrays;
import java.util.Scanner;

public class ActivityNotifications {

    //https://www.hackerrank.com/challenges/fraudulent-activity-notifications/problem
    public static void main( String[] args ) {
        solve();
    }

    //Not solved yet...
    private static void solve() {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int d = scanner.nextInt();

        int[] expenditure = new int[n];

        for (int i = 0; i < n; i++) {
            expenditure[i] = scanner.nextInt();
        }

        if (d >= expenditure.length) {
            System.out.println(0);
            return;
        }

        int start = 0;
        double median = median(start, d, expenditure, d);

        int notification = 0;
        for (int i = d; i < n; i++) {

            if (expenditure[i] >= median * 2) {
                notification++;
            }

            median = median(++start, i + 1, expenditure, d);
        }

        System.out.println(notification);
    }

    private static double median( int start, int end, int[] arr, int d ) {

        if (end < arr.length) {
            /*int sum = 0;
            for (int i = start; i < end; i++) {
                sum += arr[i];
            }

            return (double) sum / d;*/

            int[] temp = new int[end];
            for (int i = 0; i < temp.length; i++) {

                if (start + 1 < arr.length)
                    temp[i] = arr[start++];
            }

            Arrays.sort(temp);

            // check for even case
            if (temp.length % 2 != 0)
                return (double) temp[temp.length / 2];

            return (double) (temp[(temp.length - 1) / 2] + temp[temp.length / 2]) / 2.0;
        }
        return 0;
    }
}
