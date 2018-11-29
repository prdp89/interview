package com.interview.codingblocks.week9DynamicProgrammming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//https://www.codechef.com/COOK81/problems/SHOPTRIP#
//https://online.codingblocks.com/player/3880/content/170?s=1905
public class BearAndShopTrip {

    static double[][] dp;

    //N cities = N shops = 36 or 50
    private static double dist[][] = new double[50][50];

    //N is number of shops and, K is total ingredients needed
    private static int N, K;

    private static List<Pair<Integer, Integer>> coordinates = new ArrayList<>(); //coordinate of each shop
    private static List<Integer> ingredients = new ArrayList<>(); //ingredient String to create Mask.

    public static void main( String[] args ) {

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        String temp;

        while (t-- > 0) {

            N = scanner.nextInt();
            K = scanner.nextInt();

            coordinates.clear();
            ingredients.clear();

            //adding a initial coordinate of kitchen
            coordinates.add(new Pair<>(0, 0));

            for (int i = 0; i < N; i++) {

                //taking input of N shops coordinates
                int x = scanner.nextInt();
                int y = scanner.nextInt();

                coordinates.add(new Pair<>(x, y));
            }

            //setting Kitchen ingredients as 0.
            ingredients.add(0);

            //This is taken to add optimization on ingredients. If all ingredients are found then Possible = 1111(all bits set)
            int possible = 0;

            //Reading N ingredients string, one for each shop
            for (int i = 0; i < N; i++) {

                StringBuilder reverseInput = new StringBuilder();

                temp = scanner.next();
                reverseInput.append(temp);

                //reversing the input for Bitwise operation; If input = "0 1 1 0 0" to create Mask for second bit = 1, string should be reverse order
                //So reverserInput = "0 0 1 1 0" now second bit = 1 from end will help in checking if ith ingredient found.
                temp = reverseInput.reverse().toString();

                //converting binary string to Integer
                int temp_mask = 0;
                for (int j = 0; j < temp.length(); j++) {

                    //1<<j : 2 ^ j (or setting the ith bit of number)
                    temp_mask |= (1 << j) * (temp.charAt(j) - '0');
                }

                //for optimization adding current set bit in Possible variable.
                possible |= temp_mask;

                ingredients.add(temp_mask);
            }

            int ALL_INGREDIENTS = ((1 << K) - 1);
            if (ALL_INGREDIENTS != possible) {
                System.out.println(-1);
                continue;
            }

            //1. calculating distance array by Euclidean distance (between all shops as travelling salesman problem)
            //i=0; means including kitchen in distance arrray
            for (int i = 0; i <= N; i++) {

                for (int j = 0; j <= N; j++) {

                    dist[i][j] = distance(coordinates.get(i), coordinates.get(j));
                }
            }

            dp = new double[1 << 13][37]; //1 << 13 : 2^13 and N = 36 as given in question
            for (double[] row : dp)
                Arrays.fill(row, -1);

            System.out.println(shopTrip(0, 0));
        }

    }

    //mask : to check the ingredients collected so far
    //index: index of current shop we are visiting
    private static double shopTrip( int mask, int index ) {

        //if all ingredients collected and we return to origin shop
        if (mask == ((1 << K) - 1) && index == 0)
            return 0;

        if (dp[mask][index] != -1)
            return dp[mask][index];

        //try to compute answer
        dp[mask][index] = Integer.MAX_VALUE;

        for (int i = 0; i <= N; i++) {

            //mask | ingredients.get(i) : if new ingredient collected is not equals to old ingredients
            //i==0 : we are at kitchen
            if ((mask | ingredients.get(i)) != mask || i == 0) {

                //This recursion is same as Travelling salesman prob.
                // dist[index][i] : distance of moving from shop A -- > B
                //mask | ingredients.get(i) : recur with Ingredient mask same as TSP

                dp[mask][index] = Math.min(dp[mask][index],
                        dist[index][i] + shopTrip(mask | ingredients.get(i), i));
            }
        }

        return dp[mask][index];
    }


    private static double distance( Pair<Integer, Integer> p1, Pair<Integer, Integer> p2 ) {
        int dx = p1.l - p2.l;
        int dy = p1.r - p2.r;

        return Math.sqrt(dx * dx + dy * dy);
    }

    private static class Pair<L, R> {
        private L l;
        private R r;

        public Pair() {
        }

        public Pair( L l, R r ) {
            this.l = l;
            this.r = r;
        }

        public L getL() {
            return l;
        }

        public void setL( L l ) {
            this.l = l;
        }

        public R getR() {
            return r;
        }

        public void setR( R r ) {
            this.r = r;
        }
    }
}
