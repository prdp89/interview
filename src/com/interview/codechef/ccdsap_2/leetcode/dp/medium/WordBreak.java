package com.interview.codechef.ccdsap_2.leetcode.dp.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

    //https://leetcode.com/problems/word-break/
    public static void main( String[] args ) {
        String sb = "leetcode";

        List<String> listStr = new ArrayList<>();
        listStr.add("leet");
        listStr.add("code");

        Set<String> set = new HashSet<>(listStr);

        System.out.println(recurse(sb, set));

        System.out.println("DP:" + workdBreadDP(sb, set));
    }

    //ref: https://leetcode.com/problems/word-break/discuss/169383/The-Time-Complexity-of-The-Brute-Force-Method-Should-Be-O(2n)-and-Prove-It-Below
    private static boolean recurse( String s, Set<String> set ) {

        int len = s.length();

        if (len == 0) { //if input string reaches zero length means it match with all set values
            return true;
        }

        for (int i = 1; i <= len; ++i) { //recur for Input string for each substrings

            if (set.contains(s.substring(0, i)) && recurse(s.substring(i), set)) {
                return true;
            }
        }
        return false;
    }

    //Runtime: 3 ms, faster than 88.64% of Java o
    //this patter is same as CoinChangeMinCoins OR LongestIncreasingSubsequence
    //https://leetcode.com/problems/word-break/discuss/43790/Java-implementation-using-DP-in-two-ways
    private static boolean workdBreadDP( String s, Set<String> set ) {

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
