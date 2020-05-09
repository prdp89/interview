package com.interview.leetcode.contests.biweekly.biweekely20;

import java.util.*;

public class SortByNumOfBits {

    //https://leetcode.com/contest/biweekly-contest-20/problems/sort-integers-by-the-number-of-1-bits/
    public static void main( String[] args ) {
        int[] arr = {1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1};
        //System.out.println(Arrays.toString(sortByBits(arr)));

        System.out.println(Arrays.toString(sortByBitsOptimal(arr)));
    }

    private static int[] sortByBitsOptimal( int[] arr ) {
        Integer[] a = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++)
            a[i] = arr[i];

        Arrays.sort(a, ( x, y ) ->
                Integer.bitCount(x) == Integer.bitCount(y) ? x - y :
                        Integer.bitCount(x) - Integer.bitCount(y)
        );

        for (int i = 0; i < a.length; i++) {
            arr[i] = a[i];
        }

        return arr;
    }

    //54 / 77 test cases passed.
    private static int[] sortByBits( int[] arr ) {
        TreeMap<Integer, TreeSet<Integer>> treeMap = new TreeMap<>();

        for (Integer item : arr) {
            int count = 0;
            int temp = item;
            while (temp > 0) {
                temp = temp & temp - 1;
                count++;
            }

            treeMap.putIfAbsent(count, new TreeSet<>());
            treeMap.get(count).add(item);
        }

        List<Integer> list = new ArrayList<>();
        treeMap.forEach(( k, v ) -> list.addAll(v));

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            res[i] = list.get(i);

        return res;
    }
}
