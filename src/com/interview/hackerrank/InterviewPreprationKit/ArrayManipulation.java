package com.interview.hackerrank.InterviewPreprationKit;

import java.util.Scanner;

//https://www.hackerrank.com/challenges/crush/problem
public class ArrayManipulation {

    private static void solve() {
        long arr[] = new long[5];
        int[][] queries = {{1, 2, 100},
                {2, 5, 100},
                {3, 4, 100}};


        long max = 0;
        for (int[] query : queries) {

            int x = query[0];
            int y = query[1];

            for (int j = x - 1; j < y; j++) {
                arr[j] = arr[j] + query[2];

                max = Math.max(max, arr[j]);
            }
        }

        System.out.println(max);
    }

    //This problem is an application of "Prefix sum" problem (https://www.geeksforgeeks.org/prefix-sum-array-implementation-applications-competitive-programming/).
    //Video link : https://www.youtube.com/watch?v=6kn8QJJKhS4
    private static void solveOptimal() {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();

        //This will be the "difference array". The entry upto arr[i]=k indicates that upto arr[i] is exactly
        // k units and it is larger than arr[i-1]
        long[] arr = new long[n];

        int lower;
        int upper;
        long sum;

        for (int i = 0; i < m; i++) {
            lower = scan.nextInt();
            upper = scan.nextInt();

            sum = scan.nextInt();

            //we are only adding K(sum) value to the Lower index. This means, We are now maintaining the same value upto arr[upper - 1].
            arr[lower - 1] += sum;

            //We are indicating Upper Index that, after it K(sum) will be -ve. So that on adding arr[upper - 1] + arr[upper]..
            //we should get correct arr[upper] value.
            if (upper < n)
                arr[upper] -= sum;
        }

        long max = 0;
        long temp = 0;

        //calculating Max value by adding Range of Arr[i..N] where value is Max.
        for (int i = 0; i < n; i++) {
            temp += arr[i];
            if (temp > max) max = temp;
        }

        System.out.println(max);
    }

    public static void main( String[] args ) {
        solve();
    }
}
