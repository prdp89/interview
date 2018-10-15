package com.interview.hackerearth.augustcircuit2k18;

import java.util.Scanner;

public class CuttingTheArray {

    //https://www.hackerearth.com/challenge/competitive/august-circuits-18/approximate/cutting-the-array-e3e5c075/
    public static void main( String[] args ) {

    }

    private static void solve() {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {

            a[i] = scanner.nextInt();
        }

        int cuts = scanner.nextInt();



       // partition(a, cuts, 0);
    }

   /* private static void partition( int[] a, int cuts, int i ) {

        if(i == cuts)
            return;


    }*/
}
