package com.interview.codingblocks.week3;

import java.util.Scanner;

public class MinJumpToEnd {

    private static void solveRecursive() {
        //length : 10
        //input : 1 4 3 7 1 2 6 7 6 10
        //output : 3 {1 -> 4 -> 7 -> end}

        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println(minJumpsRecursive(arr, 0, arr.length - 1));
    }

    //source: https://www.youtube.com/watch?v=iT7EmidHV4o
    // jumps to reach arr[h] from arr[l]
    private static int minJumpsRecursive( int arr[], int l, int h ) {
        // Base case: when source
        // and destination are same
        if (h == l)
            return 0;

        // When nothing is reachable
        // from the given source
        if (arr[l] == 0)
            return Integer.MAX_VALUE;

        // Traverse through all the points
        // reachable from arr[l]. Recursively
        // get the minimum number of jumps
        // needed to reach arr[h] from these
        // reachable points.
        int min = Integer.MAX_VALUE;
        for (int i = l + 1; i <= h && i <= l + arr[l]; i++) {
            int jumps = minJumpsRecursive(arr, i, h);

            if (jumps != Integer.MAX_VALUE &&
                    jumps + 1 < min)
                min = jumps + 1;

        }
        return min;
    }


    public static void main( String[] args ) {
        solveRecursive();
    }
}
