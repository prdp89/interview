package com.interview.hackerrank.recursion.advance;

public class ConstructTheArray {

    //https://www.hackerrank.com/challenges/construct-the-array/problem
    public static void main( String[] args ) {

        System.out.println(countArray(4, 3, 2, 1, 1, 0));
    }

    // Complete the countArray function below.
    private static long countArray( int n, int k, int x, int start, int currElement, int ways ) {
        // Return the number of ways to fill in the array.

        //it means start reach to the end and last element is X
        if (start >= n && currElement == x)
            return ways;

        if (start >= n)
            return 0;

        if (currElement >= 1 && currElement <= k) {

            for (int i = 1; i <= k; i++) {

                if (i != currElement)
                    return countArray(n, k, x, start + 1, i, ways + 1);
            }
        }

        return 0;
    }
}
