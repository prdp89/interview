package com.interview.leetcode.contests.contest155;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinAbsDiff {

    //https://leetcode.com/contest/weekly-contest-155/problems/minimum-absolute-difference/
    public static void main( String[] args ) {
        int[] arr = {40, 11, 26, 27, -20};
        minimumAbsDifference(arr).forEach(System.out::println);
    }

    //AC in one go .. :)
    private static List<List<Integer>> minimumAbsDifference( int[] arr ) {

        Arrays.sort(arr);

        int minDiff = Integer.MAX_VALUE;
        int minEndingIndex = -1;
        for (int i = 1; i < arr.length; i++) {

            if (arr[i] - arr[i - 1] < minDiff) {
                minDiff = arr[i] - arr[i - 1];
                minEndingIndex = i;
            }
        }

        List<List<Integer>> listList = new ArrayList<>();

        List<Integer> list = new ArrayList<>();
        list.add(arr[minEndingIndex - 1]);
        list.add(arr[minEndingIndex]);

        listList.add(list);

        for (int i = minEndingIndex + 1; i < arr.length; i++) {

            if (arr[i] - arr[i - 1] == minDiff) {
                list = new ArrayList<>();
                list.add(arr[i - 1]);
                list.add(arr[i]);

                listList.add(list);
            }
        }

        return listList;
    }
}
