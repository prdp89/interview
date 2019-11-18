package com.interview.codechef.ccdsap_2.leetcode.backtracking.medium;

import java.util.ArrayList;
import java.util.List;

public class CombinationsOfSizeK {

    //https://leetcode.com/problems/combinations/

    //video: https://www.youtube.com/watch?v=sVXUOUmfztM
    //ref: https://github.com/bephrem1/backtobackswe/blob/master/Dynamic%20Programming%2C%20Recursion%2C%20%26%20Backtracking/subsetsOfSizeK.java
    public static void main( String[] args ) {
        int n = 4, k = 2;
        combine(n, k).forEach(System.out::println);
    }

    //This problem recursion is similar to Subsets bcz we have given N = 3 => {1, 2, 3}
    //And we have to choose Size ok K subsets from N.
    //for size K = 2 we have to choose : { {1, 2}, {1, 3}, {2, 3}}
    private static List<List<Integer>> combine( int n, int k ) {

        List<List<Integer>> combinations = new ArrayList<>();
        exploreCombinations(1, n, k, new ArrayList<>(), combinations);
        return combinations;
    }

    private static void exploreCombinations(
            int offset,
            int n,
            int k,
            List<Integer> partialCombination,
            List<List<Integer>> combinations
    ) {

  /*
    If the partial combination we are building reaches the
    maximum size (which is k).
  */
        if (partialCombination.size() == k) {
            combinations.add(new ArrayList<>(partialCombination));
            return; //must include return bcz we have to just generate only K size subsets
        }

  /*
    spaceLeftInSnippet <= n - i + 1:
      This is to assert that we can continue looping as long there are more
      choices left than 'slots' to fill. This is choice abundance. Imagine:
      n = 100
      k = 10

      and our state is:
      [ 95 _ _ _ _ _ _ _ _ _ ]
           ^
      Our for loop will start at 96 when expressing the possibility space for
      this "slot".
      We are now choosing for that slot. But now our possibility space is
      96...100
      spaceLeftInSnippet = 10 - 1 = 9
      n - i + 1 = 100 - 96 + 1 = 5 -> { 96, 97, 98, 99, 100 } which is length 5
      So if we recurse we will waste time. It is impossible to finish the k slots
      from this position, this conditional prunes the recursion.
  */

        //Prdp89 :
        //The above explanation means:
        //Suppose We have spaceLeft in partialCombination = 9 and,
        //We reach 96th index of array, that means we can't fill/complete partialCombination list with 5 elements left,
        //We are 4 elements short.

        final int spaceLeftInSnippet = k - partialCombination.size();

        //on removing spaceLeftInSnippet <= n - i + 1 : Runtime: 24 ms, faster than 59.98% of Java
        //on using below loop without any changes : Runtime: 2 ms, faster than 95.56% of Java

        for (int i = offset; i <= n && spaceLeftInSnippet <= n - i + 1; i++) {

            // 1.) Choose - Add the i'th number in the iteration
            partialCombination.add(i);

            // 2.) Explore - Recurse into our decision
            exploreCombinations(i + 1, n, k, partialCombination, combinations); //i+1 : bcz we cannot reuse same elements; means set = {1,1} is not valid

            // 3.) Un-choose - Remove the item we just explored on
            partialCombination.remove(partialCombination.size() - 1);
        }
    }
}
