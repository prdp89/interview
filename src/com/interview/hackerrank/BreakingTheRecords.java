package com.interview.hackerrank;

//https://www.hackerrank.com/challenges/breaking-best-and-worst-records/problem
public class BreakingTheRecords {

    private static void solve() {
        int arr[] = {10, 5, 20, 20, 4, 5, 2, 25, 1};
        //int arr[] = {3, 4, 21, 36, 10, 28, 35, 5, 24, 42};

       // int arr[] = {12, 24, 10, 24};

        int maxCount = 0, minCount = 0;

        int max = arr[0], min = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                maxCount++;
                max = arr[i];
            }

            if (arr[i] < min) {
                minCount++;
                min = arr[i];
            }
        }

        System.out.println(maxCount + " " + minCount);
    }

    public static void main( String[] args ) {
        solve();
    }
}
