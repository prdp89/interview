package com.interview.leetcode.contests.biweekly.biweekely18;

import java.util.Arrays;
import java.util.HashMap;

public class RankTransformArray {

    //https://leetcode.com/contest/biweekly-contest-18/problems/rank-transform-of-an-array/
    public static void main( String[] args ) {
        int[] arr = {37, 12, 28, 9, 100, 56, 80, 5, 12};

        System.out.println(Arrays.toString(arrayRankTransform(arr)));
    }

    private static int[] arrayRankTransform( int[] arr ) {
        int[] temp = arr.clone();

        Arrays.sort(temp);
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < temp.length; i++) {
            map.putIfAbsent(temp[i], map.size() + 1);
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = map.get(arr[i]);
        }

        return arr;
    }
}
