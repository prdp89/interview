package com.interview.leetcode.graph;

import java.util.ArrayList;
import java.util.List;

public class SortIntegerByPower {

    //https://leetcode.com/problems/sort-integers-by-the-power-value/
    public static void main( String[] args ) {

        int lo = 12, hi = 15, k = 2;
        System.out.println(getKth(lo, hi, k));
    }

    //Runtime: 54 ms, faster than 62.84% of Java
    private static int getKth( int lo, int hi, int k ) {

        List<Pair> list = new ArrayList<>();
        for (int i = lo; i <= hi; i++) {

            list.add(new Pair(dfs(i), i));
        }

        //if Power value is same then sort by ASC of Low.. High
        //else sort by ASC of Power value
        list.sort(( a, b ) -> a.key == b.key ? a.val - b.val : a.key - b.key);

        //now return the Kth element of zero based array index
        return list.get(k - 1).val;
    }

    private static int dfs( int num ) {
        int cnt = 0;
        while (num != 1) {
            if (num % 2 == 0)
                num /= 2;
            else
                num = 3 * num + 1;
            cnt++;
        }

        return cnt;
    }

    private static class Pair {
        int key;
        int val;

        Pair( int key, int val ) {
            this.key = key;
            this.val = val;
        }

    }
}
