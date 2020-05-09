package com.interview.leetcode.contests.biweekly.biweekely18;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class SortMatrixDiagonally {

    //https://leetcode.com/contest/biweekly-contest-18/problems/sort-the-matrix-diagonally/
    public static void main( String[] args ) {
        int[][] arr = {
                {3, 3, 1, 1},
                {2, 2, 1, 2},
                {1, 1, 1, 2}
        };

        System.out.println(Arrays.deepToString(diagonalSort(arr)));
    }

    //similar to DiagonalTraverseII
    private static int[][] diagonalSort( int[][] mat ) {

        int n = mat.length, m = mat[0].length;

        HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>();

        //ONLY DIFF: each diagonal unique can get by i-j
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map.putIfAbsent(i - j, new PriorityQueue<>());
                map.get(i - j).offer(mat[i][j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = map.get(i - j).poll();
            }
        }

        return mat;
    }
}
