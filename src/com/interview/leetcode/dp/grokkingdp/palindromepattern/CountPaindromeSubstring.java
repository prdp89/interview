package com.interview.leetcode.dp.grokkingdp.palindromepattern;

public class CountPaindromeSubstring {

    //https://leetcode.com/problems/palindromic-substrings/
    public static void main( String[] args ) {
        CountPaindromeSubstring cps = new CountPaindromeSubstring();
        System.out.println(cps.findCPS("abc"));
    }

    //Runtime: 15 ms, faster than 21.66% of Java
    //same Recurrence or logic as LongestPalindromicSubString
    public int findCPS( String st ) {
        // dp[i][j] will be 'true' if the string from index 'i' to index 'j' is a
        // palindrome
        boolean[][] dp = new boolean[st.length()][st.length()];
        int count = 0;

        // every string with one character is a palindrome
        for (int i = 0; i < st.length(); i++) {
            dp[i][i] = true;
            count++;
        }

        for (int startIndex = st.length() - 1; startIndex >= 0; startIndex--) {

            for (int endIndex = startIndex + 1; endIndex < st.length(); endIndex++) {

                if (st.charAt(startIndex) == st.charAt(endIndex)) {

                    // if it's a two character {0,1} string or if the remaining string is a palindrome too
                    if (endIndex - startIndex == 1 || dp[startIndex + 1][endIndex - 1]) {
                        dp[startIndex][endIndex] = true;
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
