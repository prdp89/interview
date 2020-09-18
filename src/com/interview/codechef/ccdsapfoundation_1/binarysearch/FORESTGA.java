package com.interview.codechef.ccdsapfoundation_1.binarysearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FORESTGA {

    //https://www.codechef.com/MAY16/problems/FORESTGA
    public static void main( String[] args ) {
        bruteForce();
    }

    private static void bruteForce() {
        try {
            Scanner scanner = new Scanner(System.in);
            long n = scanner.nextLong();
            long w = scanner.nextLong();
            long l = scanner.nextLong();

            List<Pair> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(new Pair(scanner.nextLong(), scanner.nextLong()));
            }

            long high = 1000000000000000000L;
            long low = 0L;

            while (high > low) {
                long mid = (high + low) / 2;

                //this comparison is same as PIE problem
                if (isSatisfyOrder(mid, list, l, w) == 1) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }

            System.out.println(high);
        } catch (Exception e) {
            return;
        }
    }

    private static int isSatisfyOrder( long currentYear, List<Pair> list, long minTreeSize, long requiredOrder ) {

        long sum = 0;

        for (Pair pair : list) {
            //if (h[i] + r[i] * t >= l)

            if (pair.getValue() * currentYear + pair.getKey() >= minTreeSize) {

                sum = sum + pair.getKey() + pair.getValue() * currentYear;

                if (sum >= requiredOrder) {
                    return 1;
                }
            }
        }

        if (sum >= requiredOrder) {
            return 1;
        } else {
            return 0;
        }
    }

    static class Pair {
        long key;
        long value;

        Pair( long key, long value ) {
            this.key = key;
            this.value = value;
        }

        public long getKey() {
            return key;
        }

        public long getValue() {
            return value;
        }
    }
}
