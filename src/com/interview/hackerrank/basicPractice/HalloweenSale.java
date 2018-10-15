package com.interview.hackerrank.basicPractice;

public class HalloweenSale {

    private static void solve() {
        int p, d, m, s, sum = 0, count = 0;

        p = 20;
        d = 3;
        m = 6;
        s = 80;

        while (sum + p <= s) {

            count++;

            sum += p;

           /* if (p - d > m)
                p -= d;
            else
                p = m;*/
            //or-----------------

            p = Math.max(p - d, m);
        }

        System.out.println(count);
    }


    //https://www.hackerrank.com/challenges/halloween-sale/
    public static void main( String[] args ) {
        solve();
    }
}
