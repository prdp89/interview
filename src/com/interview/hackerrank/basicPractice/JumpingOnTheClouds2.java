package com.interview.hackerrank.basicPractice;

//https://www.hackerrank.com/challenges/jumping-on-the-clouds
public class JumpingOnTheClouds2 {

    private static int solve( int a[], int n, int i, int sum ) {

        if (i >= n - 1)
            return 1;

        if (a[i] == 1)
            return 0;

        return sum + Math.min(solve(a, n, i + 1, sum), solve(a, n, i + 2, sum));
    }

    private static int solveOptimal( int[] array, int n, int i, int count ) {
        if (i + 1 == n || i + 2 == n) //if index + 1 or + 2 reaches to end then return the latest sum.
            return ++count;

        if (array[i + 2] == 0) //if we can jump on index + 2 take that jump.
            i += 2;
        else i++;

        return solveOptimal(array, n, i, ++count);
    }

    private static void solveIterative() {

       // int a[] = {0, 0, 0, 0, 1, 0};
        int a[] = {0, 0, 1, 0, 0, 1, 0};

        int count = 0;

        for (int i = 0; i < a.length; ) {

            if (i + 1 == a.length - 1 || i + 2 == a.length - 1) {
                ++count;
                break;
            }

            if (a[i + 2] == 0)
                i += 2;
            else
                i++;

            ++count;
        }

        System.out.println(count);
    }

    public static void main( String[] args ) {
        //  int a[] = {0, 0, 1, 0, 0, 1, 0};

        //int a[] = {0, 0, 0, 0, 1, 0};
        // System.out.println(solve(a, a.length, 0, 1));

       // System.out.println(solveOptimal(a, a.length - 1, 0, 0));

        solveIterative();
    }
}
