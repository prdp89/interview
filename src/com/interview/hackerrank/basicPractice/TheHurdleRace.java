package com.interview.hackerrank.basicPractice;

public class TheHurdleRace {

    //https://www.hackerrank.com/challenges/the-hurdle-race/problem?h_r=next-challenge&h_v=zen
    private static void solve() {
       /* int k = 4;

        int heightONOde[] = {1, 6, 3, 5, 2};*/

        int k = 7;

        int height[] = {2, 5, 4, 5, 2};

        int maxHeight = height[0];
        for (int i = 1; i < height.length; i++) {

            if (height[i] > maxHeight)
                maxHeight = height[i];
        }

        if (maxHeight > k)
            System.out.println(maxHeight - k);
        else
            System.out.println(0);
    }

    public static void main( String[] args ) {
        solve();
    }
}
