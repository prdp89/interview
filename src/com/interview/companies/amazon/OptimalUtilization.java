package com.interview.companies.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OptimalUtilization {

    //https://leetcode.com/discuss/interview-question/373202

    /*
    Given 2 lists a and b. Each element is a pair of integers where the first integer represents
    the unique id and the second integer represents a value.

    Your task is to find an element from a and an element form b such that the sum of their values
    is less or equal to target and as close to target as possible. Return a list of ids of selected elements.

    If no pair is possible, return an empty list.
     */

    /*
    Input:
        a = [[1, 2], [2, 4], [3, 6]]
        b = [[1, 2]]
        target = 7

    Output: [[2, 1]]

        Explanation:
        There are only three combinations [1, 1], [2, 1], and [3, 1], which have a total sum of 4, 6 and 8, respectively.
        Since 6 is the largest sum that does not exceed 7, [2, 1] is the optimal pair.
     */
    public static void main( String[] args ) {

        int[][] a = {{1, 2}, {2, 4}, {3, 6}};
        int[][] b = {{1, 2}};

        List<int[]> list = getPairs(a, b, 7);
        for (int[] arr : list) {
            System.out.println(Arrays.toString(arr));
        }
    }

    //ref: https://leetcode.com/discuss/interview-question/373202
    private static List<int[]> getPairs( int[][] a, int[][] b, int target ) {

        Arrays.sort(a, ( i, j ) -> i[1] - j[1]); //sorting asc order of a[1] element
        Arrays.sort(b, ( i, j ) -> i[1] - j[1]);

        List<int[]> result = new ArrayList<>();

        int max = Integer.MIN_VALUE;
        int m = a.length;

        int n = b.length;
        int i = 0;

        int j = n - 1;

        while (i < m && j >= 0) {
            int sum = a[i][1] + b[j][1];

            if (sum > target) {
                --j;
            } else {
                if (max <= sum) {

                    if (max < sum) {
                        max = sum;
                        result.clear(); //clearing bcz we we get better sum
                    }

                    //need to return index for result..
                    result.add(new int[]{a[i][0], b[j][0]});

                    //If B arr has duplicate elements then pairing every A arr index B array..
                    int index = j - 1;
                    while (index >= 0 && b[index][1] == b[index + 1][1]) {
                        result.add(new int[]{a[i][0], b[index--][0]});
                    }
                }

                ++i;
            }
        }
        return result;
    }
}
