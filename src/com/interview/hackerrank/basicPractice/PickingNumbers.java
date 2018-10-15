package com.interview.hackerrank.basicPractice;

import java.util.Arrays;

public class PickingNumbers {

    //https://www.hackerrank.com/challenges/picking-numbers/problem
    private static void solve() {
        //int[] a = {1, 2, 2, 3, 1, 2};
        int[] a = {4, 6, 5, 3, 3, 1};

        Arrays.sort(a);

        int maxNum = 0;

        for (int i = 0; i < a.length - 1; i++) {

            int auxNum = 1;

            for (int j = i + 1; j < a.length; j++) {

                if (Math.abs(a[i] - a[j]) <= 1) {
                    auxNum++;
                }
            }

            if (auxNum > 1 && auxNum > maxNum) {
                maxNum = auxNum;
            }
        }

        System.out.println(maxNum);
    }

    public static void main( String[] args ) {
        solve();
    }
}
