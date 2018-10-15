package com.interview.hackerrank.InterviewPreprationKit;

import java.util.HashMap;

public class DavisStaircase {

    static HashMap<Integer, Integer> hashMap = new HashMap<>();

    //https://www.hackerrank.com/challenges/ctci-recursive-staircase/problem
    public static void main( String[] args ) {
        //  System.out.println(solve(7));
        solveBottomUp(3);
    }

    //Recursion with Top Down DP
    private static int solve( int stairs ) {

        if (stairs < 0)
            return 0;
        if (stairs == 0)
            return 1;

        if (hashMap.containsKey(stairs)) {
            return hashMap.get(stairs);
        } else {
            int ways = solve(stairs - 1) + solve(stairs - 2) + solve(stairs - 3);
            hashMap.put(stairs, ways);
        }
        return hashMap.get(stairs);
    }

    private static void solveBottomUp( int stairs ) {

        int[] arr = new int[stairs + 1];

        if (stairs == 1) {
            System.out.println(1);
            return;
        }

        if (stairs == 2) {
            System.out.println(2);
            return;
        }

        if (stairs == 3) {
            System.out.println(4);
            return;
        }

        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 4;

        for (int i = 3; i <= stairs; i++) {
            arr[i] = arr[i - 1] + arr[i - 2] + arr[i - 3];
        }

        System.out.println(arr[stairs - 1]);
    }
}
