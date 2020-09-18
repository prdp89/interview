package com.interview.codechef.ccdsapfoundation_1.DP.GFG;

public class GolombSeuence {

    //https://www.geeksforgeeks.org/golomb-sequence/
    public static void main( String[] args ) {
        printGolomb(3);
    }

    private static int findGolomb( int n ) {

        // base case
        if (n == 1)
            return 1;

        // Recursive Step
        return 1 + findGolomb(n -
                findGolomb(findGolomb(n - 1)));
    }


    // Print the first n term of
    // Golomb Sequence
    private static void printGolomb( int n ) {

        // Finding first n terms of
        // Golomb Sequence.
        for (int i = 1; i <= n; i++)
            System.out.print(findGolomb(i) +
                    " ");
    }
}
