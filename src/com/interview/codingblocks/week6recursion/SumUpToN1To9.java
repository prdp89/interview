package com.interview.codingblocks.week6recursion;

import java.util.ArrayList;
import java.util.List;

//http://wlcoding.blogspot.com/2015/03/combination-sum-i-ii.html
public class SumUpToN1To9 {

    /*
    Find all possible combinations of k numbers that add up to a number n,
    given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
    Ensure that numbers within the set are sorted in ascending order.

    Example 1:
    Input: k = 3, n = 7
    Output: [[1,2,4]]

    Example 2:
    Input: k = 3, n = 9
    Output: [[1,2,6], [1,3,5], [2,3,4]]
     */

    private static List<List<Integer>> listSet = new ArrayList<List<Integer>>();
    private static List<Integer> list = new ArrayList<Integer>();

    public static void main( String[] args ) {

        combinationSum(3, 7);

        for (List<Integer> list : listSet) {
            for (Integer num : list) {
                System.out.print(num + " ");
            }
            System.out.println("");
        }
    }

    private static void combinationSum( int k, int n ) {
        addUp(1, k, n);
    }

    private static void addUp( int start, int k, int n ) {
        if (k < 0 || n < 0) return;

        else if (k == 0 && n == 0) { //if pair is required and sum required is found

            listSet.add(new ArrayList<Integer>(list));

        } else {
            for (int i = start; i <= 9; i++) {

                list.add(i);

                //i+1 : to genrate unique combination : same as SumItUp : generateWithoutDuplicates
                //k-1 : to generate only set of K numbers
                //n-i : decreasing N at each step
                addUp(i + 1, k - 1, n - i);
                list.remove(list.size() - 1);
            }
        }
    }
}
