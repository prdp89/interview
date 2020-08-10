package com.interview.leetcode.contests.biweekly.biweekely29;

import java.util.TreeSet;

public class KthFactorOfN {

    //https://leetcode.com/contest/biweekly-contest-29/problems/the-kth-factor-of-n/
    public static void main( String[] args ) {
        System.out.println(kthFactor(100, 3));

        System.out.println(kthFactor_optimal(100, 3));
    }

    /*
    Runtime: 5 ms
    Memory Usage: 38.2 MB
     */
    private static int kthFactor( int n, int k ) {
        TreeSet<Integer> list = new TreeSet<>();
        list.add(1);

        for (int i = 2; i < n; i++)
            if (n % i == 0)
                list.add(n / i);

        list.add(n);

        if (list.size() < k)
            return -1;

        for (Integer item : list) {
            if (k == 1)
                return item;

            k--;
        }

        return -1;
    }

    private static int kthFactor_optimal( int n, int k ) {
        for (int d = 1; d <= n / 2; ++d)
            if (n % d == 0 && --k == 0)
                return d;

        return k == 1 ? n : -1;
    }
}
