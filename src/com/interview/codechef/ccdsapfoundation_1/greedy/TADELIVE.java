package com.interview.codechef.ccdsapfoundation_1.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class TADELIVE {

    //https://www.codechef.com/problems/TADELIVE
    public static void main( String[] args ) {
        try {
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            int a[] = new int[n];
            int b[] = new int[n];

            for (int i = 0; i < n; i++)
                a[i] = scanner.nextInt();

            for (int i = 0; i < n; i++)
                b[i] = scanner.nextInt();

            TipDifference[] diffs = new TipDifference[n];
            for (int i = 0; i < n; i++) {
                diffs[i] = new TipDifference(i, Math.abs(a[i] - b[i]));
            }

            //sorting acc to max difference in two orders profit
            Arrays.sort(diffs);

            int sum = 0;

            for (int i = 0; i < n; i++) {

                int index = diffs[i].index;
                if (x > 0 && a[index] > b[index]) {
                    sum += a[index];
                    x--;
                } else if (y > 0) {
                    sum += b[index];
                    y--;
                }
            }

            System.out.println(sum);

        } catch (Exception e) {
            return;
        }
    }

    static class TipDifference implements Comparable<TipDifference> {
        int index;
        int diff;

        public TipDifference( int index, int diff ) {
            this.index = index;
            this.diff = diff;
        }

        @Override
        public int compareTo( TipDifference other ) {
            return other.diff - this.diff;
        }
    }
}
