package com.interview.codechef.ccdsap_2.leetcode.backtracking.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LetterCasePermutation {

    //https://leetcode.com/problems/letter-case-permutation/
    public static void main( String[] args ) {
        List<String> list = new ArrayList<>();

        String str = "po".toLowerCase();

        list.add(str);

        letterCasePermutation(str.toCharArray(), list, 0);

        list.forEach(System.out::println);

        List<String> listStr = letterCasePermutationBFS(str);

        listStr.forEach(System.out::println);
    }

    //passing only 14 / 63 test cases passed.
    //Trying with PalindromePartitioning logic, but partially solved.

    //why not working : You don't need a for loop here. i+1 is already controlling the index change during the recursion.
    private static void letterCasePermutation( char[] S, List<String> list, int index ) {

        if (index >= S.length && !list.contains(new String(S))) {
            list.add(new String(S));
        } else {
            for (int i = index; i < S.length; i++) {

                if (Character.isDigit(S[i])) {
                    letterCasePermutation(S, list, i + 1);
                }

                if (Character.isLetter(S[i])) {
                    S[i] = Character.toUpperCase(S[i]);

                    letterCasePermutation(S, list, i + 1);

                    S[i] = Character.toLowerCase(S[i]);
                }
            }
        }
    }

    //ref: https://leetcode.com/problems/letter-case-permutation/discuss/115485/Java-Easy-BFS-DFS-solution-with-explanation
    //same as Level order traversal
    private static List<String> letterCasePermutationBFS( String S ) {
        if (S == null) {
            return new LinkedList<>();
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(S);

        for (int i = 0; i < S.length(); i++) {

            if (Character.isDigit(S.charAt(i)))
                continue;

            int size = queue.size();

            //This loop only execute when character found
            for (int j = 0; j < size; j++) {
                String cur = queue.poll();
                char[] chs = cur.toCharArray();

                //Then we stored one uppercase and a lowerCase case variant of same character.
                chs[i] = Character.toUpperCase(chs[i]);
                queue.offer(String.valueOf(chs));

                chs[i] = Character.toLowerCase(chs[i]);
                queue.offer(String.valueOf(chs));
            }
        }

        return new LinkedList<>(queue);
    }

    //https://leetcode.com/problems/letter-case-permutation/discuss/115508/Java-solution-using-recursion
    private static void computeRecursive( List<String> ans, char[] chars, int index ) {
        if (index == chars.length)
            ans.add(new String(chars));
        else {

            if (Character.isLetter(chars[index])) {
                chars[index] = Character.toLowerCase(chars[index]);
                computeRecursive(ans, chars, index + 1);
                chars[index] = Character.toUpperCase(chars[index]);
            }

            computeRecursive(ans, chars, index + 1);
        }
    }
}
