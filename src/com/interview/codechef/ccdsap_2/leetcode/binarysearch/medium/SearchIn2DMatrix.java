package com.interview.codechef.ccdsap_2.leetcode.binarysearch.medium;

//https://leetcode.com/problems/search-a-2d-matrix/
public class SearchIn2DMatrix {

    public static void main( String[] args ) {
        int[][] matrix = {{1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}};

        int target = 3;

        System.out.println(searchMatrix(matrix, target));
    }

    //look in this too : https://github.com/bephrem1/backtobackswe/blob/master/Sorting%2C%20Searching%2C%20%26%20Heaps/SearchA2DMatrix/ContinuousSortVariant.java
    private static boolean searchMatrix( int[][] matrix, int target ) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int start = 0, rows = matrix.length, cols = matrix[0].length;
        int end = rows * cols - 1;

        while (start <= end) {

            int mid = (start + end) / 2;

            if (matrix[mid / cols][mid % cols] == target) {
                return true;
            }

            if (matrix[mid / cols][mid % cols] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }
}
