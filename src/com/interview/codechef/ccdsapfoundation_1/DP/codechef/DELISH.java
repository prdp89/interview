package com.interview.codechef.ccdsapfoundation_1.DP.codechef;

import java.util.Scanner;

public class DELISH {

    //https://www.codechef.com/problems/DELISH
    public static void main( String[] args ) {

        try {
            Scanner scanner = new Scanner(System.in);

            int t = scanner.nextInt();

            while (t-- > 0) {
                int n = scanner.nextInt();

                int[] arr = new int[n];
                for (int i = 0; i < n; i++)
                    arr[i] = scanner.nextInt();

                //Arrays.sort(arr);
                //solve(arr);

                solveOptimal(arr, arr.length);
            }
        } catch (Exception e) {
            return;
        }
    }

    private static void solveOptimal( int[] arr, int n ) {
        long[] leftMin = new long[n];
        long[] leftMax = new long[n];

        leftMin[0] = arr[0];
        leftMax[0] = arr[0];

        for (int j = 1; j < n; j++) {
            leftMin[j] = Math.min(arr[j], leftMin[j - 1] + arr[j]);
            leftMax[j] = Math.max(arr[j], leftMax[j - 1] + arr[j]);
        }

        long[] rightMin = new long[n];
        long[] rightMax = new long[n];

        rightMin[n - 1] = arr[n - 1];
        rightMax[n - 1] = arr[n - 1];

        for (int j = n - 2; j >= 0; j--) {
            rightMin[j] = Math.min(arr[j], rightMin[j + 1] + arr[j]);
            rightMax[j] = Math.max(arr[j], rightMax[j + 1] + arr[j]);
        }

        long ans = Integer.MIN_VALUE;

        for (int j = 0; j < n - 1; j++) {
            ans = Math.max(ans, Math.abs(leftMin[j] - rightMax[j + 1]));
            ans = Math.max(ans, Math.abs(rightMin[j + 1] - leftMax[j]));
        }

        System.out.println(ans);
    }

    //This only pass sample test case
    private static void solve( int[] arr ) {

        int max = 0;
        int prevI = arr[0];
        for (int i = 1; i < arr.length; i++) {

            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
            }

            max = Math.max(max, Math.abs(sum - prevI));

            prevI += arr[i];
        }

        System.out.println(max);
    }
}
