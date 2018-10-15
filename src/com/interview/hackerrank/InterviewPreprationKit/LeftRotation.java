package com.interview.hackerrank.InterviewPreprationKit;

public class LeftRotation {

    private static void solve() {
        int[] arr = {1, 2, 3, 4, 5};
        int d = 4;
        int rotation = d % arr.length;

        for (int i = 0; i < arr.length; i++) {
                System.out.println(arr[rotation % arr.length]);
                rotation++;
        }
    }

    //https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem
    public static void main( String[] args ) {
        solve();
    }
}
