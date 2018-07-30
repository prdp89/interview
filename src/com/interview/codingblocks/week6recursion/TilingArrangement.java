package com.interview.codingblocks.week6recursion;

import java.util.Scanner;

//Given a brick wall of 4 * N, tiles of size 4 * 1, we have to find total number of ways to arrange tiles on a wall.
public class TilingArrangement {

    public static void main( String[] args ) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        System.out.println(arrangeBricks(N));
    }

    private static int arrangeBricks( int n ) {
        if (n == 0)
            return 1;

        if(n < 0)
            return 0;

        int totalNumberOfWays = arrangeBricks(n - 1) + arrangeBricks(n - 4);
        return totalNumberOfWays;
    }
}
