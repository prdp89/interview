package com.interview.basics.hackerearth;

import com.interview.basics.FastReader;

//https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/roy-and-trains-2/

public class RoyAndTrains {

    public void solve() {
        FastReader in = new FastReader();

        int T = in.nextInt();

        while (T-- > 0) {

            int t0 = in.nextInt();
            int t1 = in.nextInt();
            int t2 = in.nextInt();
            int v1 = in.nextInt();
            int v2 = in.nextInt();
            int d = in.nextInt();

            if (t0 > t1 && t0 > t2)
                System.out.println(-1);
            else {

                long time = Long.MAX_VALUE, time2 = Long.MAX_VALUE;

                if (t0 <= t1) {
                    time = t1;
                    double q = (double) d / (double) v1;
                    q = q * 60;
                    time = time + (long) Math.ceil(q);
                }

                if (t0 <= t2) {
                    time2 = t2;
                    double q = (double) d / (double) v2;
                    q = q * 60;
                    time2 = time2 + (long) Math.ceil(q);
                }

                System.out.println((time < time2) ? time : time2);
            }
        }
    }

    public static void main( String[] args ) {
        RoyAndTrains royAndTrains = new RoyAndTrains();
        royAndTrains.solve();
    }
}
