package com.interview.codingblocks.week9DynamicProgrammming;

import java.util.Arrays;

public class TravellingSalesmanWithBitmasking {

    //Generating mask part is similar as Sub-sequence of String with bit-masking

    //We have given 4 cities and distance between them.

    static int N = 4; //denotes 4 cities

    private static int MASK_VISITED_ALL = (1 << N) - 1;

    //dist[0][1] = distance of 20 from city A to B
    private static int dist[][] = {
            {0, 20, 42, 25},
            {20, 0, 30, 34},
            {42, 30, 0, 10},
            {25, 34, 10, 0}
    };

    private static int dp[][] = new int[16][4]; // 2 ^ 4 = 16 and [4] = number of cities

    public static void main( String[] args ) {
        // System.out.println(tsp(1, 0));

        for (int[] row : dp)
            Arrays.fill(row, -1);

        System.out.println(tspTopDownDP(1, 0));
    }

    //With recursion complexity : O ( 2 ^ N * N )
    //2 ^ N : to visit all combinations of cities
    // N : number of cities

    //currentCityIndexOrPosition : from City A we can go to : B, C, D
    private static int tsp( int mask, int currentCityIndexOrPosition ) {

        if (mask == MASK_VISITED_ALL)
            return dist[currentCityIndexOrPosition][0];

        int ans = Integer.MAX_VALUE;

        //Try to visit all other city
        for (int city = 0; city < N; city++) {

            //suppose we want to check if 2nd city is visited or not, so we create a Mask like:
            // 1 << 2 = 0 1 0 0
            //then we do AND (& operation ) with mask variable = 0 1 1 0
            //                                                   0 1 0 0
            //                                                   -------
            //                                                   0 1 0 0
            //if 3rd bit is non zero then city is visited


            //if current city is not visited
            if ((mask & (1 << city)) == 0) {

                //dist[currentCityIndexOrPosition][city] : distance of travelling to new city from current city

                // ( mask | (1 << city) ) : If we going from A -- > B = 0001 ----> 0011
                // OR operation set the visited city bit.
                //Example : mask = 0 0 1 0
                //1<<city :        0 0 0 1
                //                 -------
                //                 0 0 1 1

                //, city : to the city we are going
                int newAns = dist[currentCityIndexOrPosition][city] + tsp((mask | (1 << city)), city);
                ans = Math.min(ans, newAns);
            }
        }

        return ans;
    }

    //So we not create a 2D dp array which maps to recursive complexity : dp [2 ^ N] [N] = O ((N-1)!)
    private static int tspTopDownDP( int mask, int currentCityIndexOrPosition ) {

        if (mask == MASK_VISITED_ALL)
            return dist[currentCityIndexOrPosition][0];

        if (dp[mask][currentCityIndexOrPosition] != -1)
            return dp[mask][currentCityIndexOrPosition];

        int ans = Integer.MAX_VALUE;

        //Try to visit all other city
        for (int city = 0; city < N; city++) {

            //suppose we want to check if 2nd city is visited or not, so we create a Mask like:
            // 1 << 2 = 0 1 0 0
            //then we do AND (& operation ) with mask variable = 0 1 1 0
            //                                                   0 1 0 0
            //                                                   -------
            //                                                   0 1 0 0
            //if 3rd bit is non zero then city is visited


            //if current city is not visited
            if ((mask & (1 << city)) == 0) {

                //dist[currentCityIndexOrPosition][city] : distance of travelling to new city from current city

                // ( mask | (1 << city) ) : If we going from A -- > B = 0001 ----> 0011
                // OR operation set the visited city bit.
                //Example : mask = 0 0 1 0
                //1<<city :        0 0 0 1
                //                 -------
                //                 0 0 1 1

                //, city : to the city we are going
                int newAns = dist[currentCityIndexOrPosition][city] + tsp((mask | (1 << city)), city);
                ans = Math.min(ans, newAns);
            }
        }

        return dp[mask][currentCityIndexOrPosition] = ans;
    }

}
