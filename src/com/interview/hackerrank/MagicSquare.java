package com.interview.hackerrank;

import java.util.Arrays;

public class MagicSquare {

    private static void solve() {
        int s[][] = {{4, 8, 2}, {4, 5, 7}, {6, 1, 6}};  //input invalid valid
        int cost[] = {0, 0, 0, 0, 0, 0, 0, 0}; //temp cost matrix

        //this is all possible combinations of Magic Matrix..
        int t[][] =
                {
                        {4, 9, 2, 3, 5, 7, 8, 1, 6}, //first Magic matrix
                        {4, 3, 8, 9, 5, 1, 2, 7, 6}, //second magic matrix and so on..
                        {2, 9, 4, 7, 5, 3, 6, 1, 8},
                        {2, 7, 6, 9, 5, 1, 4, 3, 8},
                        {8, 1, 6, 3, 5, 7, 4, 9, 2},
                        {8, 3, 4, 1, 5, 9, 6, 7, 2},
                        {6, 7, 2, 1, 5, 9, 8, 3, 4},
                        {6, 1, 8, 7, 5, 3, 2, 9, 4},
                };

        for (int i = 0; i < 8; i++) {

            //calculating : subtracting input cost with Magic matrix cost.
            cost[i] = Math.abs(t[i][0] - s[0][0]) + Math.abs(t[i][1] - s[0][1]) + Math.abs(t[i][2] - s[0][2]);

            cost[i] = cost[i] + Math.abs(t[i][3] - s[1][0]) + Math.abs(t[i][4] - s[1][1]) + Math.abs(t[i][5] - s[1][2]);

            cost[i] = cost[i] + Math.abs(t[i][6] - s[2][0]) + Math.abs(t[i][7] - s[2][1]) + Math.abs(t[i][8] - s[2][2]);
        }

        //finding smallest cost at cost[0]
        Arrays.sort(cost);

        System.out.println(cost[0]);
    }

    public static void main( String[] args ) {
        solve();
    }
}