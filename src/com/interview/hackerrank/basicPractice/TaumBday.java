package com.interview.hackerrank.basicPractice;

public class TaumBday {

    private static void solve( int b, int w, int bc, int wc, int z ) {

       /* if (z > bc && z > wc) {
            System.out.println(b * bc + w * wc);
        }*/
        if (z >= Math.abs(bc - wc)) {
            System.out.println(b * bc + w * wc);
        } else if (wc < bc && (wc + z) < bc) {
            System.out.println(wc * w + (b * (wc + z)));
        } else if (bc < wc && (bc + z) < wc)
            System.out.println(bc * b + (w * (bc + z)));
       /* else {
            System.out.println(b * bc + w * wc);
        }*/
    }

    /* A slight improved version : X = bc , Y = wc
    if (Z >= abs(X-Y)) {
    printf("%ld\n", B*X + W*Y);
    } else if (X <= Y) {
    printf("%ld\n", (B+W)*X + W*Z);
    } else {
    printf("%ld\n", (B+W)*Y + B*Z);
    }
     */

    public static void main( String[] args ) {

        int[][] arr = {
                {10, 10, 1, 1, 1},
                {5, 9, 2, 3, 4},
                {3, 6, 9, 1, 1},
                {7, 7, 4, 2, 1},
                {3, 3, 1, 9, 2}
        };

        for (int[] anArr : arr) {
            solve(anArr[0], anArr[1], anArr[2], anArr[3], anArr[4]);
        }
    }
}
