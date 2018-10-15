package com.interview.hackerrank.basicPractice;

import java.util.Arrays;

public class CutTheSticks {

    //https://www.hackerrank.com/challenges/cut-the-sticks/
    private static void solve() {
        //int[] arr = {5, 4, 4, 2, 2, 8};

        int[] arr = {1, 2, 3, 4, 3, 3, 2, 1};

        int sticksCount = 0;

        Arrays.sort(arr);

        int smallest = arr[0];
        int k =0;

        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < arr.length; j++) {

                if (arr[j] != 0) {
                    arr[j] = arr[j] - smallest;
                    sticksCount++;
                }
            }

            for (; k < arr.length; k++) {
                if (arr[k] != 0) {
                    smallest = arr[k];
                    break;
                }
            }

            if (sticksCount != 0)
                System.out.print(sticksCount + " ");
            else
                break;

            sticksCount = 0;
        }
    }

    public static void main( String[] args ) {
        solve();
    }
}
