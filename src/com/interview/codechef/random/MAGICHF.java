package com.interview.codechef.random;

import com.interview.codingblocks.week7Greedy.GRANDTEMPLE;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

//https://www.codechef.com/SEPT18B/problems/MAGICHF
public class MAGICHF {

    public static void main( String[] args ) {
        solve();
    }

    private static void solve() {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        while (t-- > 0) {

            int n, x, s;

            n = scanner.nextInt();
            x = scanner.nextInt();
            s = scanner.nextInt();

            int result = x;

            for (int i = 0; i < s; i++) {

                int src = scanner.nextInt();
                int dest = scanner.nextInt();

                if (result != src)
                    result = src;
                else
                    result = dest;
            }

            System.out.println(result);
        }
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
