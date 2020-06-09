package com.interview.leetcode.dp.grokkingdp.palindromepattern;

public class MinDeletetionForPalindrome {

    /*
    Given a string, find the minimum number of characters that we can remove to make it a palindrome.

    Example 1:

    Input: "abdbca"
    Output: 1
    Explanation: By removing "c", we get a palindrome "abdba".
     */

    //https://leetcode.com/discuss/interview-question/371677/Google-or-Onsite-or-Min-Deletions-to-Make-Palindrome
    public static void main( String[] args ) {
        MinDeletetionForPalindrome mdsp = new MinDeletetionForPalindrome();

        String str = "abdbca";
        int lonPalSubSeq = mdsp.findLPSLength_2D_DP(str);

        System.out.println(str.length() - lonPalSubSeq);
    }

    public int findLPSLength_2D_DP( String st ) {
        // dp[i][j] stores the length of LPS from index 'i' to index 'j'
        int[][] dp = new int[st.length()][st.length()];

        // every sequence with one element is a palindrome of length 1
        for (int i = 0; i < st.length(); i++)
            dp[i][i] = 1;

        //initially : startIndx = 5 , innerLoop: endIndex = 5 ; not execute
        //Then startIndex= 4; endIndex : 4--5
        //Then startIndex = 3; endIndex : 3 -- 5
        for (int startIndex = st.length() - 1; startIndex >= 0; startIndex--) {

            for (int endIndex = startIndex + 1; endIndex < st.length(); endIndex++) {

                // case 1: elements at the beginning and the end are the same
                if (st.charAt(startIndex) == st.charAt(endIndex)) {
                    dp[startIndex][endIndex] = 2 + dp[startIndex + 1][endIndex - 1];
                } else { // case 2: skip one element either from the beginning or the end
                    dp[startIndex][endIndex] = Math.max(dp[startIndex + 1][endIndex], dp[startIndex][endIndex - 1]);
                }
            }
        }
        return dp[0][st.length() - 1];
    }

    /*
    Follow-Up question:
    2. Find if a string is K-Palindromic #

    Any string will be called K-palindromic if it can be transformed into a palindrome
    by removing at most ‘K’ characters from it.

    This problem can easily be converted to our base problem
    of finding the minimum deletions in a string to make it a palindrome.

    If the “minimum deletion count” is not more than ‘K’, the string will be K-Palindromic.
     */
}
