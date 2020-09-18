package com.interview.codechef.ccdsapfoundation_1.binarysearch;

import java.util.Scanner;

public class SCALE {

    //qut. https://www.spoj.com/problems/SCALE/
    //ref https://sspoj.blogspot.com/2018/09/scale-funny-scales.html?_sm_au_=itV1bZ6RHMKPQqJP
    public static void main( String[] args ) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int x = scanner.nextInt(); //mass of weight in 3 ^ (i-1)

        if (x == 0 || x == 1) {
            System.out.println("1");
            return;
        }

        //to generate array of 1---N
        int arr[] = new int[n];

        //the mass of 3^0 3^1 3^2 => 1 3 9
        //This form a GP series, hence formula: (a. ( r ^ n - 1)) / (r - 1)
        // a = 1, r = 3
        long maxSum = (long) (Math.pow(3, n) - 1) / (3 - 1);

        //if given mass is greater than total possible mass
        if (x > maxSum) {
            System.out.println("-1");
            return;
        }

        //As mentioned here : https://www.quora.com/What-is-the-logic-behind-SPOJ-problem-SCALE-Funny-scales
        //Convert X into ternary number system.
        //example 5 : 2 * (3 ^ 0) + 1 * (3 ^ 1) = 12
        //arr values are = {2, 1}
        int len = convertToTernary(x, arr, 0);

        solve(arr, len, maxSum);
    }

    private static void solve( int arr[], int len, long maxSum ) {
        int lhs [] = new int[10000];
        int rhs [] = new int[10000];

        //TODO:
        //pending,,,,
    }

    private static int convertToTernary( int x, int[] arr, int index ) {
        if (x == 0)
            return index;

        int remainder = x % 3;

        arr[index] = remainder;
        x = x / 3;

        return convertToTernary(x, arr, index + 1);
    }
}