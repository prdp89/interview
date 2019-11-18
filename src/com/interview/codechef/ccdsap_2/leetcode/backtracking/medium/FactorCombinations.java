package com.interview.codechef.ccdsap_2.leetcode.backtracking.medium;

import java.util.ArrayList;
import java.util.List;

public class FactorCombinations {

    /*
    Numbers can be regarded as product of its factors. For example,
    8 = 2 x 2 x 2;
      = 2 x 4.

    Write a function that takes an integer n and return all possible combinations of its factors.
    Note:
    Each combination’s factors must be sorted ascending, for example: The factors of 2 and 6 is [2, 6], not [6, 2].
    You may assume that n is always positive.
    Factors should be greater than 1 and less than n.

    For example:

    Input: 12
    Output: [[2, 2, 3], [2, 6], [3, 4]]

    Input: 15
    Output: [[3, 5]]

    Input: 28
    Output: [[2, 2, 7], [2, 14], [4, 7]]

     */

    public static void main( String[] args ) {
        getFactors(28).forEach(System.out::println);
    }

    private static List<List<Integer>> getFactors( int n ) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        helper(ret, new ArrayList<Integer>(), n, 2);
        return ret;
    }

    private static void helper( List<List<Integer>> ret, List<Integer> item, int n, int start ) {

        //if num reaches 1 means all factor for a combination is generated.
        if (n == 1) {
            if (item.size() > 1) {
                ret.add(new ArrayList<>(item));
            }
            return;
        }

        for (int i = start; i <= n; i++) {

            //if num % i means it is a factor
            if (n % i == 0) {
                item.add(i);

                //chopping off N to generate the next valid factor
                //see we are doing i not i+1 bcz each factor can be part of other combinations.
                helper(ret, item, n / i, i);

                //removing item from list while backtracking
                item.remove(item.size() - 1);
            }
        }
    }

}
