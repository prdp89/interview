package com.interview.codechef.ccdsap_2.atcoder.begcontest132;

import java.util.Arrays;

public class DivideTheProblemsArray {

    //https://atcoder.jp/contests/abc132/tasks/abc132_c
    public static void main( String[] args ) {
        int[] arr = {9, 1, 4, 4, 6, 7}; //sort : {1, 4, 4, 6, 7, 9}
        solve(arr);
    }

    //didn't understand properlyer
    private static void solve( int[] arr ) {
        Arrays.sort(arr);
        System.out.println(arr[arr.length / 2] - arr[arr.length / 2 - 1]);
    }
}
