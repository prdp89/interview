package com.interview.leetcode.contests._new_weekely.weekely200;

public class CountGoodTriplets {

    //https://leetcode.com/contest/weekly-contest-200/problems/count-good-triplets/
    public static void main( String[] args ) {
        int[] arr = {3, 0, 1, 1, 9, 7};
        int a = 7, b = 2, c = 3;

        System.out.println(countGoodTriplets(arr, a, b, c));
    }

    private static int countGoodTriplets( int[] arr, int a, int b, int c ) {
        int count = 0, n = arr.length;

        for (int i = 0; i < n - 2; i++) {

            for (int j = i + 1; j < n - 1; j++) {

                if (Math.abs(arr[i] - arr[j]) <= a) { // check if satisfy then loop for k
                    for (int k = j + 1; k < n; k++) {

                        if (Math.abs(arr[i] - arr[j]) <= a &&
                                Math.abs(arr[j] - arr[k]) <= b &&
                                Math.abs(arr[k] - arr[i]) <= c) {
                            count++;
                        }
                    }
                }
            }
        }

        return count;
    }
}
