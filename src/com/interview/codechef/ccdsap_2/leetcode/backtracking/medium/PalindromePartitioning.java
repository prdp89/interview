package com.interview.codechef.ccdsap_2.leetcode.backtracking.medium;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    //question: https://leetcode.com/problems/palindrome-partitioning/
    //video : https://www.youtube.com/watch?v=4ykBXGbonlA

    public static void main( String[] args ) {
        List<List<String>> res = partition("aab");

        for (List<String> l : res) {
            l.forEach(System.out::println);

            System.out.println();
        }
    }

    private static List<List<String>> partition( String s ) {
        ArrayList validDecompositions = new ArrayList();
        List<String> deCompInProgress = new ArrayList<>();

        decomposeString(s, 0, deCompInProgress, validDecompositions); // Kick off the recursion
        return validDecompositions;
    }

    /*
      1.) Take all palindrome snippets from where we are
      2.) Recurse on them
      3.) When base case is hit, we add the answer and backtrack to keep going
    */
    private static void decomposeString( String s
            , int buildPointer, List<String> deCompInProgress
            , List<List<String>> validDecompositions ) {

        //it means , if start == end
        if (buildPointer == s.length()) {
            validDecompositions.add(new ArrayList<>(deCompInProgress)); // deep copy the list. this is key.
        } else {


            //Look carefully: isn't this loop same as PartitionEqualSubsetSum :P
            for (int i = buildPointer; i < s.length(); i++) {

      /*
        Only recurse if the snippet we COULD take is a palindrome
      */
                if (isPalindrome(s, buildPointer, i)) {

        /*
          Take the snippet now that we know it will be palindromic.
          WATCH OUT FOR OFF BY 1! We add 1 to i for the upper bound
          since substring() in the Java API EXCLUDES the right bound.
        */
                    String palindromicSnippet = s.substring(buildPointer, i + 1);

                    // Add the snippet to our decomposition that we are working on
                    deCompInProgress.add(palindromicSnippet);

                    // Recurse and advance progress; see its not buildPointer + 1 as Permutations...
                    decomposeString(s, i + 1, deCompInProgress, validDecompositions);

        /*
          We are done searching, remove the snippet from our progress. Next
          loop iteration continues our progress in this stack frame
        */
                    deCompInProgress.remove(deCompInProgress.size() - 1);
                }

            }

        }
    }

    private static boolean isPalindrome( String s, int low, int high ) {

        while (low < high) {
            if (s.charAt(low++) != s.charAt(high--)) {
                return false;
            }
        }

        return true;
    }
}
