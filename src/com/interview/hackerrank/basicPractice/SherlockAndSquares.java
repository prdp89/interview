package com.interview.hackerrank.basicPractice;

public class SherlockAndSquares {

    //https://www.hackerrank.com/challenges/sherlock-and-squares/problem
    private static void solve() {
        int a = 24, b = 49;

        int count = 0;
        for (int i = a; i <= b; i++) {

            int nearestMultiplier = (int) Math.ceil(Math.sqrt(i));
            if (nearestMultiplier * nearestMultiplier == i)
                count++;
        }

        System.out.println(count);
    }

    /*
     We do the floor of larger number sqrt and ceiling of smaller number sqrt.
     Reason being we need to find number of integers between the sqrt of those numbers.
     */
    private static void solveOptimal() {

        int a = 24, b = 49;

        int count;

        count = (int) Math.floor(Math.sqrt(b)) - (int) Math.ceil(Math.sqrt(a)) + 1;

        System.out.println(count);

    }

    public static void main( String[] args ) {
      //  solve();

        solveOptimal();
    }
}
