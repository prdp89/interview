package com.interview.hackerrank.recursion;

public class ThePowerSum {

    private static void solve() {
        int X = 13, N = 2;

        System.out.println(recurse(X, N, 1));
    }

    /*
    This is one of the best solutions.

    For a better understanding we can visualize it for X = 10 and N = 2.

                     (10,2,1)                   ->1^2
                    /        \
                   /          \
             (10,2,2)        (9,2,2)            ->2^2
             /     \         /     \
            /       \       /       \
        (10,2,3) (6,2,3)  (9,2,3) (5,2,3)       ->3^2
        /     \      |       |       |
       /       \     0       1       0
    (10,2,4) (1,2,4)                            ->4^2
        |       |
        0       0

    This is a binary tree. The answer is the count of the leaves which equals 1.

    While going from the root to a leaf which is 1, sum of powers at passing every right edge
    and the leaf gives the X.

    (10,2,1)--(9,2,2) -> right edge       -> 1^2
    (9,2,2)---(9,2,3) -> left edge        -> 0
    (9,2,3)           -> leaf which is 1  -> 3^2

    So, 10 = 1^2 + 3^2.

     */

    private static int recurse( int x, int n, int i ) {

        int i_pow = (int) Math.pow(i, n);

        if (i_pow > x)
            return 0;
        else if (i_pow == x)
            return 1;
        else
            // subproblem
            return recurse(x, n, i + 1) + recurse(x - i_pow, n, i + 1);
    }

    //https://www.hackerrank.com/challenges/the-power-sum/problem
    public static void main( String[] args ) {
        solve();
    }
}
