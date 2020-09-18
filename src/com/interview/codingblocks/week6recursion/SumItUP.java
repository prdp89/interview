package com.interview.codingblocks.week6recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumItUP {

    /*
    You are given an array of numbers and a target number(T) , print all unique combinations in the array whose sum equals the target number T.
    Note that each number in the array may only be used once in the combination.
    Note:

    All numbers (including target) will be positive integers
    Elements in the combination must be in non-descending order
    There should be no duplicate combinations
     */
    // since we need all the combinations,no dp
    // think of backtrack and recursion.

    private static List<List<Integer>> listSet = new ArrayList<List<Integer>>();
    private static List<Integer> list = new ArrayList<Integer>();

    public static void main( String[] args ) {

        // int arr[] = {2, 4, 6, 8 }; //linked with target  = 8
        int arr[] = {10, 1, 2, 7, 6, 1, 5};
        combinationSum(arr, 8);

        /*
        Input to check combination without duplicates
        10 1 2 7 6 1 5
        8

        output:
        1 1 6
        1 2 5
        1 7
        2 6
         */

        for (List<Integer> list : listSet) {
            for (Integer num : list) {
                System.out.print(num + " ");
            }
            System.out.println("");
        }
    }

    private static void combinationSum( int[] candidates, int target ) {
        Arrays.sort(candidates);

        //generateCombinationWithDuplicates(candidates, 0, target);

        generateCombinationWithOutDuplicates(candidates, 0, target);
    }

    //This calculate combination sum with picking duplicates values from array
    //https://www.geeksforgeeks.org/combinational-sum/
    private static void generateCombinationWithDuplicates( int[] candidates, int start, int target ) {
        if (target < 0) return;

        else if (target == 0) {
            // No need to check duplicate lists!!
            //if (!listSet.contains(list)) //// No need to check duplicate lists!!

            listSet.add(new ArrayList<Integer>(list));
        } else {
            for (int i = start; i < candidates.length && candidates[i] <= target; i++) {

                if (i > start && candidates[i] == candidates[i - 1])
                    continue;  // avoid duplicated list: another alternative (command the 3rd line above)

                list.add(candidates[i]);

                generateCombinationWithDuplicates(candidates, i, target - candidates[i]);

                //done for backtracking
                list.remove(list.size() - 1);
            }
        }
    }

    private static void generateCombinationWithOutDuplicates( int[] candidates, int start, int target ) {
        if (target < 0) return;

        else if (target == 0) {
            // if (!listSet.contains(list))    // No need to check duplicate lists!!
            listSet.add(new ArrayList<Integer>(list));

        } else {
            for (int i = start; i < candidates.length && candidates[i] <= target; i++) {

                if (i > start && candidates[i] == candidates[i - 1])
                    continue;  // avoid duplicated list: another alternative (command the 3rd line above)

                list.add(candidates[i]);

                //only this line differs from above algorithm
                generateCombinationWithOutDuplicates(candidates, i + 1, target - candidates[i]);   // only modification
                list.remove(list.size() - 1);
            }
        }
    }
}
