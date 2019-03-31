package com.interview.codingblocks.week6recursion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

//https://codeforces.com/problemset/problem/812/B
//https://online.codingblocks.com/player/3880/content/993?s=1918
public class SagheerDHausmeister {

    /*
    Input:
    3 4
    001000
    000010
    000010
    output:
    12
     */

    /*
    First Lit bulb Left distance array: [4, 4, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
    First Lit bulb Right distance array: [1, 1, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
     */

    private static BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
    private static int M_MAX;
    private static int N, M;
    private static int MATRIX[][] = new int[16][150];
    private static int ILL[] = new int[16]; // has index of last bulb while entering from left.
    private static int ILR[] = new int[16]; // has index of last bulb while entering from right.
    private static int FINAL_FLOOR_WHERE_BULB_IS_PRESENT = 0;

    private static void readInput() {
        try {
            String[] NM = buf.readLine().split("\\s");

            N = Integer.parseInt(NM[0]); // total floors in building.
            M = Integer.parseInt(NM[1]); // cols in building.

            M_MAX = M + 2;// M_MAX is the total cols of building including stairs on either sides.

            for (int i = 0; i < N; i++) {
                String AR[] = buf.readLine().split("");

                for (int j = 0; j < M_MAX; j++) {

                    MATRIX[i][j] = Integer.parseInt(AR[j]);

                    if (MATRIX[i][j] == 1) {
                        //storing distance in reverse order
                        ILL[N - i - 1] = j;
                        ILR[N - i - 1] = Math.max(M_MAX - j - 1, ILR[N - i - 1]);

                        FINAL_FLOOR_WHERE_BULB_IS_PRESENT = Math.max(FINAL_FLOOR_WHERE_BULB_IS_PRESENT, N - i - 1);
                    }
                }
            }

            System.out.println("First Lit bulb Left distance array: " + Arrays.toString(ILL));
            System.out.println("First Lit bulb Right distance array: " + Arrays.toString(ILR));

        } catch (Exception e) {
            System.out.println("Exception while input " + e);
        }
    }

    private static int minTraverseTime( boolean isLeft, int floor, int totalDist ) {
        // base case
        if (floor == FINAL_FLOOR_WHERE_BULB_IS_PRESENT) {
            if (isLeft) {
                totalDist += ILL[floor];
            } else {
                totalDist += ILR[floor];
            }
            return totalDist;
        } else {

            // totalDistToLeft is moving from current position to next floor from left most stairs

            // totalDistToRight is moving from current position to next floor from right most stairs

            // return min distance after going to next floor through left and right

            if (isLeft) {
                totalDist += ILL[floor];

                int totalDistToLeft = totalDist + ILL[floor] + 1;
                int totalDistToRight = totalDist + (M_MAX - ILL[floor] - 1) + 1;

                return Math.min(
                        minTraverseTime(true, floor + 1, totalDistToLeft),
                        minTraverseTime(false, floor + 1, totalDistToRight));

            } else {
                totalDist += ILR[floor];

                int totalDistToLeft = totalDist + (M_MAX - ILR[floor] - 1) + 1;
                int totalDistToRight = totalDist + ILR[floor] + 1;

                return Math.min(
                        minTraverseTime(true, floor + 1, totalDistToLeft),
                        minTraverseTime(false, floor + 1, totalDistToRight));
            }
        }
    }

    public static void main( String[] args ) {
        readInput();
    }


}
