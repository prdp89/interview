package com.interview.codechef.ccdsap_2.leetcode.dp.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle {

    //https://leetcode.com/problems/triangle
    public static void main( String[] args ) {

        List<List<Integer>> listList = new ArrayList<>();

        List<Integer> list = new ArrayList<>();
        list.add(2);

        listList.add(list);

        List<Integer> list1 = new ArrayList<>();

        list1.add(3);
        list1.add(4);

        listList.add(list1);

        List<Integer> list2 = new ArrayList<>();

        list2.add(6);
        list2.add(5);
        list2.add(7);

        listList.add(list2);

        List<Integer> list3 = new ArrayList<>();

        list3.add(4);
        list3.add(1);
        list3.add(8);
        list3.add(3);

        listList.add(list3);

        System.out.println(minimumTotal(listList));

        System.out.println(bottonUPDp(listList));
    }

    private static int bottonUPDp( List<List<Integer>> listList ) {

        int rowNum = listList.size();
        int[] dp = new int[rowNum];

        //moving in bottom up manner; storing last row values..
        for (int i = 0; i < listList.get(rowNum - 1).size(); i++) {
            dp[i] = listList.get(rowNum - 1).get(i);
        }

        //for each row..
        for (int row = rowNum - 2; row >= 0; row--) {// for each layer

            //if we select : listList.get(row).get(col) or list[i][j]
            //then we have option to pick list[i+1][j] list[i+1][j+1]
            //These options are already calculated and present in dp[] array.
            for (int col = 0; col <= row; col++) {

                dp[col] = Math.min(dp[col], dp[col + 1])
                        + listList.get(row).get(col);
            }
        }

        //min will be present at dp[0]
        return dp[0];
    }

    private static int minimumTotal( List<List<Integer>> triangle ) {

        /*List<Integer> list = new ArrayList<>();

        list.add(triangle.get(0).get(0));
        int sum = recurse(triangle, 0, 0);*/

        int[][] memo = new int[triangle.size()][triangle.size()];

        for (int[] mem : memo) {
            Arrays.fill(mem, -1);
        }

        return getMemo(0, 0, triangle, memo);
    }

    //Almost solved it
    private static int recurse( List<List<Integer>> triangle, int i, int jIndex ) {

        if (i == triangle.size() && jIndex + 1 < triangle.get(i - 1).size()) {
            return Math.min(triangle.get(i - 1).get(jIndex), triangle.get(i - 1).get(jIndex + 1));
        }

        if (i > triangle.size())
            return 0;

        int value = Math.min(recurse(triangle, i + 1, jIndex), recurse(triangle, i + 1, jIndex + 1));

        //int value = Math.min(triangle.get(i + 1).get(jIndex), triangle.get(i + 1).get(jIndex + 1));
        //list.add(value);
        return value;
    }

    //working and passing all test cases
    private static int getMemo( int x, int y, List<List<Integer>> triangle, int[][] memo ) {
        if (x >= triangle.size() || y >= triangle.get(x).size())
            return 0;

        // Key point
        if (memo[x][y] != -1)
            return memo[x][y];

        int self = triangle.get(x).get(y); //this is current element
        int left = getMemo(x + 1, y, triangle, memo) + self; //below element
        int right = getMemo(x + 1, y + 1, triangle, memo) + self; //below right element

        return memo[x][y] = Math.min(left, right);
    }
}
