package com.interview.codechef.ccdsap_2.leetcode.backtracking.medium;

import java.util.ArrayList;
import java.util.List;

public class SplitArrayFiboSequence {

    //https://leetcode.com/problems/split-array-into-fibonacci-sequence/
    public static void main( String[] args ) {
        splitIntoFibonacci("123456579").forEach(System.out::println);
    }

    //ref: https://leetcode.com/problems/split-array-into-fibonacci-sequence/discuss/133936/short-and-fast-backtracking-solution
    private static List<Integer> splitIntoFibonacci( String S ) {
        List<Integer> ans = new ArrayList<>();
        helper(S, ans, 0);
        return ans;
    }

    //This recursive pattern is different and teaches us How to split String into different lengths.
    //This recursion pattern also teaches, Early termination in case of wrong sequence or overflow numbers.
    private static boolean helper( String s, List<Integer> ans, int idx ) {

        //only returns true when index reach String length and it should be Fibo. sequence
        if (idx == s.length() && ans.size() >= 3) {
            return true;
        }

        for (int i = idx; i < s.length(); i++) {
            //Remove elements with leading zero
            if (s.charAt(idx) == '0' && i > idx) {
                break;
            }

            //getting next num from recursion
            long num = Long.parseLong(s.substring(idx, i + 1));

            //The element in the sequence should be at most Integer.MAX_VALUE
            if (num > Integer.MAX_VALUE) {
                break;
            }

            int size = ans.size();

            // early termination
            //If current number is larger than the sum of previous two elements, stop backtracking
            if (size >= 2 && num > ans.get(size - 1) + ans.get(size - 2)) {
                break;
            }

            //The sequence should has at least 3 elements
            if (size <= 1 || num == ans.get(size - 1) + ans.get(size - 2)) {
                ans.add((int) num);

                // branch pruning. if one branch has found fib seq, return true to upper call
                if (helper(s, ans, i + 1)) {
                    return true;
                }

                //remove elements from List while backtracking..
                ans.remove(ans.size() - 1);
            }
        }

        //return false if previous branch doesn't match a fibo. sequence.
        return false;
    }
}
