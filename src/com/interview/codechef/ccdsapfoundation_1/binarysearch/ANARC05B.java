package com.interview.codechef.ccdsapfoundation_1.binarysearch;

import java.util.Scanner;

public class ANARC05B {

    //https://www.spoj.com/problems/ANARC05B/
    //easy program
    public static void main( String[] args ) {
        try {
            Scanner scanner = new Scanner(System.in);

            for (; ; ) {
                int m = scanner.nextInt();

                if (m == 0)
                    break;

                int[] arr1 = new int[m];

                for (int i = 0; i < m; i++)
                    arr1[i] = scanner.nextInt();

                int n = scanner.nextInt();
                int[] arr2 = new int[n];

                for (int i = 0; i < n; i++)
                    arr2[i] = scanner.nextInt();

                solve(arr1, arr2);
            }
        } catch (Exception e) {
            return;
        }
    }

    private static void solve( int[] arr1, int[] arr2 ) {
        int i = 0;
        int j = 0;
        int tot = 0, sum1 = 0, sum2 = 0;

        while (i < arr1.length && j < arr2.length) {

            if (arr1[i] == arr2[j]) {
                tot += Math.max(sum1, sum2) + arr1[i]; //+arr[i] for adding instersecting element

                sum1 = 0;
                sum2 = 0;

                i++;
                j++;
            } else if (arr1[i] > arr2[j]) { //logic of merging two sorted arrays
                sum2 += arr2[j++];
            } else {
                sum1 += arr1[i++];
            }
        }

        for (; i < arr1.length; ) {
            sum1 += arr1[i++];
        }
        for (; j < arr2.length; ) {
            sum2 += arr2[j++];
        }

        tot += Math.max(sum1, sum2);
        System.out.println(tot);
    }

    private static int getIntersectionSum( Integer end, int[] arr, int start, int sum ) {

        if (start >= end)
            return sum;

        return getIntersectionSum(end, arr, start + 1, sum + arr[start]);
    }

    //recursion returns wrong result
    private static int findMax( int[] arr1, int[] arr2, int i, int j, int arr1Sum, int arr2Sum ) {

       /* if (i >= arr1.length && j >= arr2.length)
            return Math.max(arr1Sum, arr2Sum);*/

        if (i >= arr1.length)
            return arr1Sum;

        if (j >= arr2.length)
            return arr2Sum;

        if (arr1[i] == arr2[j])
            return Math.max(arr1Sum, arr2Sum);

        int a = findMax(arr1, arr2, i + 1, j, arr1Sum + arr1[i], arr2Sum);
        int b = findMax(arr1, arr2, i, j + 1, arr1Sum, arr2Sum + arr2[j]);

        return Math.max(a, b);
    }
}
