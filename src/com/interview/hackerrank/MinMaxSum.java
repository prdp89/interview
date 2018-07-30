package com.interview.hackerrank;

import java.util.Arrays;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/mini-max-sum/problem
public class MinMaxSum {

    public static void main( String[] args ) {
        solve();
    }

    private static void solve() {
        int arr[] = {1, 2, 3, 4, 5};

        Arrays.sort(arr);

        int minSum = 0, maxSum = 0;
        for (int i = 0; i < 4; i++) {
            maxSum += arr[arr.length - (i + 1)];
            minSum += arr[i];
        }

        System.out.println(minSum + " " + maxSum);
    }

    //this is the best solution in website
   /* public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long sum = 0;
        long min = 1000000000;
        long max = 0;
        while(scan.hasNext()) {
            long n = scan.nextLong();
            sum = sum + n;
            if (min > n) {
                min = n;
            }
            if (max < n) {
                max = n;
            }
        }
        scan.close();

        System.out.println((sum - max) + " " + (sum - min));
    }*/
}
