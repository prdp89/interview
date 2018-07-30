package com.interview.hackerrank;

import java.util.Scanner;

public class SequenceEquation {

    //https://www.hackerrank.com/challenges/permutation-equation/
    //This runs in nLogN
    private static void solve() {
        int p[] = {2, 3, 1};

        for (int i = 0; i < p.length; i++) {

            System.out.println(permute(permute(i + 1, p, 0), p, 0));
        }
    }

    private static int permute( int item, int[] p, int index ) {

        if (item == p[index])
            return index + 1;

        return permute(item, p, index + 1);

    }

    /* Our input provides us n values of x and p(x)

     p(x) is a one-to-one function, so it has an inverse. We create the function representing the inverse of p(x),
      and represent it as an array: int [] p_inverse

     We need to find a y where p(p(y)) = x. This equation can be rewritten as
     y = p_inverse(p_inverse(x)), which is the version of the equation we use to calculate and print y.

    */

    private static void solveOptimal(){
        /* Create function: p_inverse */
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int [] p_inverse = new int[n + 1];

        for (int x = 1; x <= n; x++) {

            int px = scan.nextInt();

            //calculating p_inverse(x) by mapping value as an Index
            p_inverse[px] = x;

        }
        scan.close();

        /* Calculate and print each y */
        for (int x = 1; x <= n; x++) {

            //finally doing p_inverse(p_inverse(x))
            int y = p_inverse[p_inverse[x]];

            System.out.println(y);
        }
    }

    public static void main( String[] args ) {
        solve();
    }
}
