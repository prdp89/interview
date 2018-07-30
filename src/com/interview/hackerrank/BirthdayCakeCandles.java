package com.interview.hackerrank;

//https://www.hackerrank.com/challenges/birthday-cake-candles/problem
public class BirthdayCakeCandles {

    private static void solve() {

        int arr[] = {3, 2, 1, 3};

        int max = arr[0], maxCount = 1;
        for (int i = 1; i < arr.length; i++) {

            if (arr[i] > max) {
                maxCount = 1;
                max = arr[i];
            } else if (arr[i] == max)
                maxCount++;
        }

        System.out.println(maxCount);
    }

    public static void main( String[] args ) {
        solve();
    }
}
