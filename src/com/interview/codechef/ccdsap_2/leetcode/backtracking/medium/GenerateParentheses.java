package com.interview.codechef.ccdsap_2.leetcode.backtracking.medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    //https://leetcode.com/problems/generate-parentheses/

    //same as BalancedParanthesis
    public static void main( String[] args ) {
        generateParenthesis(3).forEach(System.out::println);
    }

    private static List<String> generateParenthesis( int numPairs ) {
        List<String> result = new ArrayList<>();
        directedGenerateBalancedParentheses(numPairs, numPairs, "", result); // kick off the recursion
        return result;
    }

    private static void directedGenerateBalancedParentheses( int numLeftParensNeeded, int numRightParensNeeded,
                                                             String parenStringInProgress, List<String> result ) {
        //if both left and right parenthesis are valid
        if (numLeftParensNeeded == 0 && numRightParensNeeded == 0) {
            result.add(parenStringInProgress);

            //this helps to goto previous stack/tree hierarchy, and generate next possible balance parentheses.
            return;
        }

  /*
    Can we insert a left parenthesis? Only if we have lefts remaining to insert
    at this point in the recursion
  */
        if (numLeftParensNeeded > 0) {
            directedGenerateBalancedParentheses(numLeftParensNeeded - 1, numRightParensNeeded,
                    parenStringInProgress + "(", result);
        }

  /*
    Can we insert a right parenthesis? Only if the number of left parens needed
    is less than then number of right parens needed.
  */
        if (numLeftParensNeeded < numRightParensNeeded) {
            directedGenerateBalancedParentheses(numLeftParensNeeded, numRightParensNeeded - 1,
                    parenStringInProgress + ")", result);
        }

    }
}
