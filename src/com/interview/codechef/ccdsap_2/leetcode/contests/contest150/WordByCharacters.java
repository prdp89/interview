package com.interview.codechef.ccdsap_2.leetcode.contests.contest150;

public class WordByCharacters {

    //https://leetcode.com/contest/weekly-contest-150/problems/find-words-that-can-be-formed-by-characters/
    public static void main( String[] args ) {
        String[] str = {"cat", "bt", "hat", "tree"};
        String chars = "atach";

        System.out.println(countCharacters(str, chars));
    }

    private static int countCharacters( String[] words, String chars ) {

        int count = 0;
        int[] charsCharacCount = new int[26];

        for (char c : chars.toCharArray())
            charsCharacCount[c - 'a']++;

        // Comparing each word in words
        for (String word : words) {

            // simple making copy of seen arr; copy doesn't change the original arr
            int[] tSeen = charsCharacCount.clone();

            int totalCount = 0;

            for (char c : word.toCharArray()) {
                if (tSeen[c - 'a'] > 0) {
                    tSeen[c - 'a']--;
                    totalCount++;
                }
            }

            //counting only when number of chars of word is equals to number of chars found from 'chars' string
            if (totalCount == word.length())
                count += totalCount;
        }

        return count;
    }
}
