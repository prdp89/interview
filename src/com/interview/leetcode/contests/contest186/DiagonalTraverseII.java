package com.interview.leetcode.contests.contest186;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DiagonalTraverseII {

    //https://leetcode.com/contest/weekly-contest-186/problems/diagonal-traverse-ii/
    public static void main( String[] args ) {
        List<List<Integer>> listList = new ArrayList<>();

        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        listList.add(list);

        List<Integer> list1 = new ArrayList<>(Arrays.asList(6, 7));
        listList.add(list1);

        List<Integer> list2 = new ArrayList<>(Arrays.asList(8));
        listList.add(list2);

        List<Integer> list3 = new ArrayList<>(Arrays.asList(9, 10, 11));
        listList.add(list3);

        List<Integer> list4 = new ArrayList<>(Arrays.asList(12, 13, 14, 15, 16));
        listList.add(list4);

        findDiagonalOrder(listList);
    }

    private static int[] findDiagonalOrder( List<List<Integer>> nums ) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {

            for (int j = i; j >= 0; j--) {
                int item = nums.get(i).size();
                if (item >= j)
                    list.add(nums.get(i).get(j));
            }
        }

        return new int[]{};
    }
}
