package com.interview.codechef.ccdsap_2.leetcode.backtracking.medium;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {

    private static List<List<Integer>> lists = null;

    public static void main( String[] args ) {
        int n = 9, k = 3;
        lists = new ArrayList<>();

        backtrack(new ArrayList<>(), n, 9, 1, k);

        lists.forEach(System.out::println);
    }

    //Almost similar to CombinationsOfSizeK
    //I can able to pass only 12 cases
    //12 / 18 test cases passed.

    //But after below modification :
    //1. removing lists.contains condition
    //2. Removing base condition of target < 0 || offset > end
    //It is passing all test cases..

    private static void backtrack( List<Integer> tempList, int target, int end, int offset, int k ) {

        //not needed here..
       /* if (target < 0 || offset > end)
            return;*/

        if (target == 0 && k == tempList.size()) {
            // if (!lists.contains(tempList)) //not needed here..
            lists.add(new ArrayList<>(tempList));

            return;
        }

        //This logic idea I got from CombinationsOfSizeK
        for (int i = offset; i <= end; i++) {

            tempList.add(i);

            backtrack(tempList, target - i, end, i + 1, k); // i + 1 because we cannot reuse same elements

            tempList.remove(tempList.size() - 1);
        }
    }

}
