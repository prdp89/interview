package com.interview.leetcode.thirtydaysjunechallenge;

import java.util.Arrays;

public class TwoCityScheduling {

    //https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/539/week-1-june-1st-june-7th/3349/
    public static void main( String[] args ) {
        int[][] cost = {
                {10, 20},
                {30, 200},
                {400, 50},
                {30, 20}
        };

        System.out.println(twoCitySchedCost(cost));
    }

    //cost : [10,20],[30,200],[400,50],[30,20]
    //  CityA     CityB
    //0  10         20      {cost of sending person0 to cityA = 10 and to CityB = 20}
    //1  30         200
    //2  400        50
    //3  30         20

    //We have to send 4 persons = {0,1,2,3} to either CityA or CityB such that N/2 = 2
    // persons arrive in each city with Min. cost
    private static int twoCitySchedCost( int[][] costs ) {

        //we are sorting acc. to MAx profit of Difference of each pair of array.
        //eg : {20 - 10} = 10 we are sorting by this output num in descending order..

        Arrays.sort(costs, ( a, b ) -> {
            return (b[1] - b[0]) - (a[1] - a[0]);
        });

        //After sorting acc. to each element difference
        //Cost = { {30, 200}, {10, 20}, {30, 20}, {400, 50} }

        //Now we will pick first element from 0--N/2 element and,
        //second element from N/2--N elements..

        int totalCosts = 0;
        for (int i = 0; i < costs.length / 2; i++) {
            totalCosts += costs[i][0] + costs[costs.length - i - 1][1];
        }

        return totalCosts;
    }
}
