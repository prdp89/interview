package com.interview.leetcode.contests.contest163;

import java.util.ArrayList;
import java.util.List;

public class Shift2DGrid {

    //https://leetcode.com/contest/weekly-contest-163/problems/shift-2d-grid/
    public static void main( String[] args ) {

        int[][] grid = {
                {3, 8, 1, 9},
                {19, 7, 2, 5},
                {4, 6, 11, 10},
                {12, 0, 21, 13}
        };

        int k = 0;

        List<List<Integer>> listList = shiftGrid(grid, k);
        for (List<Integer> list : listList) {
            list.forEach(System.out::println);
        }
    }

    //104 / 107 test cases passed.
    //check optimal sol. here : https://leetcode.com/problems/shift-2d-grid/discuss/431111/Simple-to-understand-java
    private static List<List<Integer>> shiftGrid( int[][] grid, int k ) {

        List<List<Integer>> res = new ArrayList<>();

        if (k == 0) {

            for (int[] aGrid : grid) {

                List<Integer> list1 = new ArrayList<>();

                for (int j = 0; j < grid[0].length; j++) {
                    list1.add(aGrid[j]);
                }
                res.add(list1);
            }

            return res;
        }


        while (k-- > 0) {

            int last = 0;

            List<List<Integer>> list = new ArrayList<>();

            for (int i = 0; i <= grid.length - 1; i++) {

                List<Integer> list1 = new ArrayList<>();

                if (i == 0)
                    last = grid[grid.length - 1][grid[0].length - 1];

                int first = grid[i][0];
                grid[i][0] = last;

                int temp = -1;

                list1.add(grid[i][0]);

                for (int j = 1; j <= grid[0].length - 1; j++) {
                    temp = grid[i][j];
                    grid[i][j] = first;
                    first = temp;

                    list1.add(grid[i][j]);
                }

                if (temp == -1)
                    temp = grid[i][0];

                last = temp;
                list.add(list1);
            }

            res = new ArrayList<>(list);
        }

        return res;
    }
}
