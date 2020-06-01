package com.interview.leetcode.dp;

import java.util.*;

public class ConcatenatedWords {

    //https://leetcode.com/problems/concatenated-words/
    public static void main( String[] args ) {
        String[] words = {"cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat"};

        findAllConcatenatedWordsInADict(words).forEach(System.out::println);
    }

    //Almost same as WordBreak
    private static List<String> findAllConcatenatedWordsInADict( String[] words ) {
        List<String> list = new ArrayList<>();

        if (words == null || words.length == 0)
            return list;

        if (words.length == 1 && words[0].length() == 0)
            return list;

        Set<String> set = new HashSet<>();

        //sort such that small words comes first..
        Arrays.sort(words, ( a, b ) -> a.length() - b.length());

        for (String str : words) {
            if (workdBreadDP(str, set))
                list.add(str);

            set.add(str);
        }

        return list;
    }

    private static boolean workdBreadDP( String s, Set<String> set ) {

        if (set.isEmpty())
            return false;

        //If we have wordsDict = ["apple", "pen"] can we make :
        //stringStr = "applepenapple" , yes we can use 2 Apple and 1 pen strings from Dict.

        boolean[] dp = new boolean[s.length() + 1];

        //if string length is zero can we make word? yes
        dp[0] = true;

        //For each String length {1...N}, we are checking if we are able build String of dp[0] length, then
        //is it possible to build the dp[1] length.
        //Slowly, we'll reach till dp[s.length]..

        for (int i = 1; i <= s.length(); i++) {

            //see carefully: This work is almost similar to LIS
            for (int j = i - 1; j >= 0; j--) {
                dp[i] = dp[j] && set.contains(s.substring(j, i));

                //if we can form ith length word, no need to iterate previous index repeatedly..
                if (dp[i])
                    break;
            }
        }

        return dp[s.length()];
    }
}
