package com.interview.leetcode.contests.contest186;

import java.util.*;

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

        //findDiagonalOrder(listList);

        System.out.println(Arrays.toString(findDiagonalOrderOptimal(listList)));
    }

    //Runtime: 36 ms, faster than 50.00% of Java
    private static int[] findDiagonalOrderOptimal( List<List<Integer>> nums ) {
        int n = 0, maxKey = 0;

        Map<Integer, List<Integer>> map = new HashMap<>();

        //starting from last row, bcz starting values of each row can be filled easily..
        for (int r = nums.size() - 1; r >= 0; r--) {

            for (int c = 0; c < nums.get(r).size(); c++) {

                map.putIfAbsent(r + c, new ArrayList<>());
                map.get(r + c).add(nums.get(r).get(c));
                maxKey = Math.max(maxKey, r + c);
                n++;
            }
        }

        int[] ans = new int[n];
        int i = 0;

        //now filling according to key index of row and column.
        for (int key = 0; key <= maxKey; key++) {
            List<Integer> list = map.get(key);

            if (list == null)
                continue;

            for (int item : list) {
                ans[i++] = item;
            }
        }

        return ans;
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
