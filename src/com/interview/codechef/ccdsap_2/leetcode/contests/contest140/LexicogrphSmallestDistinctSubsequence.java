package com.interview.codechef.ccdsap_2.leetcode.contests.contest140;

import java.util.*;

public class LexicogrphSmallestDistinctSubsequence {

    //https://leetcode.com/contest/weekly-contest-140/problems/smallest-subsequence-of-distinct-characters/

    //same as : RemoveDuplicateMaintainingOrder or //https://leetcode.com/problems/remove-duplicate-letters/
    /*
    Lexicographical order, i.e which subsequence appears first if these were words in a dictionary.

    "ecbacba"
    ecba
    ebac
    ebca
    eacb

    ^ Those are all subsequences that contains all the distinct characters only once.
    'eacb' is the first one lexicographical because ea.... appears before ec... or eb.... in the dictionary
    so you should return 'eacb' instead of the others.
     */
    public static void main( String[] args ) {
        System.out.println(smallestSubsequence("ecbacba"));
    }

    //This returns wrong result
    private static String usingTreeSet() {
        TreeSet<Character> treeSet = new TreeSet<>();

        char[] str = "cbacdcbc".toCharArray();
        for (Character c : str) {

            if (!treeSet.contains(c))
                treeSet.add(c);
        }

        StringBuilder sb = new StringBuilder();
        while (treeSet.size() > 0) {
            sb.append(treeSet.pollFirst());
        }

        return sb.toString();
    }

    //This problem is similar to RemoveDuplicateMaintainingOrder
    private static String smallestSubsequence( String text ) {
        char[] arr = text.toCharArray();

        Map<Character, Integer> map = new HashMap<>();
        Set<Character> seen = new HashSet<>();

        for (char c : arr) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        Stack<Character> stack = new Stack<>();

        //ecbacba : op: eacb
        for (char c : arr) {
            //we have seen this char
            if (seen.contains(c)) {
                map.put(c, map.get(c) - 1);
                continue;
            }

            // if the top char is larger than current char, we should remove it
            while (!stack.isEmpty() && stack.peek() > c && map.get(stack.peek()) > 1) {
                char temp = stack.pop();
                map.put(temp, map.get(temp) - 1);
                seen.remove(temp);
            }

            //insert the current character in stack. Top char should be lowest
            stack.push(c);

            //insert the current char in seen Set.
            seen.add(c);
        }

        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty())
            sb.append(stack.pop());

        return sb.reverse().toString();
    }
}
