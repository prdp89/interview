package com.interview.codechef.ccdsapfoundation_1.Maths;

import java.util.*;

public class DivisorInc {

    //https://community.topcoder.com/stat?c=problem_statement&pm=6186&rd=9823
    public static void main( String[] args ) {
        //System.out.println(numberOfDivisors(235, 98234));
        System.out.println(numberOfDivisors(4, 24));
    }

    //N= 4 m = 24
    // 4 ---> +(2,4) ----> 6 +(2,3) -----> 8 +(2,4)------>12 +(2,3,4,6) ----> 18 +(2,6,9) ------> 26
    //at each step we are choosing value such that in Min steps we reach to M; Eg from 4 to choose to add 4 --->6
    private static int numberOfDivisors( int n, int m ) {

        int[] dp = new int[m + 1];

        Arrays.fill(dp, -1);

        dp[n] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);

        while (!queue.isEmpty()) {

            int val = queue.poll();

            if (val == m)
                break;

            for (int divisor : getDivisors(val)) {

                int pathValue = divisor + val;

                if (pathValue <= m && dp[pathValue] == -1) {

                    queue.add(pathValue);

                    dp[pathValue] = dp[val] + 1;
                }
            }
        }

        return dp[m];
    }

    private static List<Integer> getDivisors( int n ) {

        List<Integer> divisors = new ArrayList<>();
        for (int d = 2; d <= Math.sqrt(n); d++) {
            if (n % d == 0) {
                divisors.add(d);
                divisors.add(n / d);
            }
        }

        return divisors;
    }
}
