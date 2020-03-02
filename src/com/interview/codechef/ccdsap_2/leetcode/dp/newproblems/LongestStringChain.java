package com.interview.codechef.ccdsap_2.leetcode.dp.newproblems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestStringChain {

    //https://leetcode.com/problems/longest-string-chain/
    public static void main( String[] args ) {
        System.out.println(longestStrChain(new String[]{"a", "b", "ba", "bca", "bda", "bdca"}));
        System.out.println("Using LIS : " + longestStrChainLIS(new String[]{"a", "b", "ba", "bca", "bda", "bdca"}));
    }

    //This is a real tricky implementation on DP
    private static int longestStrChain( String[] words ) {
        Map<String, Integer> dp = new HashMap<>();
        Arrays.sort(words, ( a, b ) -> a.length() - b.length());

        int res = 0;

        for (String word : words) {

            int best = 0;

            //This loops get every sequential combination of word.
            //Ex : bca => { ba, ca, bc}
            for (int i = 0; i < word.length(); ++i) {
                String prev = word.substring(0, i) + word.substring(i + 1);
                best = Math.max(best, dp.getOrDefault(prev, 0) + 1);
            }

            dp.put(word, best);
            res = Math.max(res, best);
        }

        return res;
    }

    //This solution is based on LIS
    private static int longestStrChainLIS( String[] words ) {
        Arrays.sort(words, ( a, b ) -> a.length() - b.length());

        int[] dp = new int[words.length];
        int maxLen = 0;

        for (int i = 0; i < words.length; i++) {

            dp[i] = 1;

            //same as LIS, comparing every string from from 0...i-1
            for (int j = i - 1; j >= 0; j--) {

                if (words[i].length() - words[j].length() == 1) {
                    if (isPredecessor(words[j], words[i])) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
            }

            maxLen = Math.max(maxLen, dp[i]);
        }

        return maxLen;
    }

    //here s2 is bigger than s1, so we are checking if s1 string has one less char than s2
    private static boolean isPredecessor( String s1, String s2 ) {
        if (s2.length() == s1.length())
            return false;
        int diff = 0;

        for (int i = 0, j = 0; i < s1.length(); ) {
            if (s1.charAt(i) == s2.charAt(j)) {
                i++;
                j++;
            } else {
                diff++;
                if (diff > 1) return false;
                j++;
            }
        }
        return true;
    }
}
