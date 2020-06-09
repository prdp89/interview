package com.interview.leetcode.dp.grokkingdp.palindromepattern;

public class LongestPalindromicSubSeq {

    /*
    Input: "abdbca"
    Output: 5
    Explanation: LPS is "abdba".
     */
    public static void main( String[] args ) {
        LongestPalindromicSubSeq lps = new LongestPalindromicSubSeq();
        System.out.println(lps.findLPSLength("abdbca"));

        System.out.println(lps.findLPSLength_2D_DP("abdbca"));
    }

    public int findLPSLength( String st ) {
        Integer[][] dp = new Integer[st.length()][st.length()];
        return findLPSLengthRecursive(dp, st, 0, st.length() - 1);
    }

    private int findLPSLengthRecursive( Integer[][] dp, String st, int startIndex, int endIndex ) {
        if (startIndex > endIndex)
            return 0;

        // every sequence with one element is a palindrome of length 1
        if (startIndex == endIndex)
            return 1;

        if (dp[startIndex][endIndex] == null) {
            //As compare to LongestCommonSubString we use "if else" pattern here..
            // case 1: elements at the beginning and the end are the same
            if (st.charAt(startIndex) == st.charAt(endIndex)) {
                dp[startIndex][endIndex] = 2 + findLPSLengthRecursive(dp, st, startIndex + 1, endIndex - 1);
            } else {
                // case 2: skip one element either from the beginning or the end
                int c1 = findLPSLengthRecursive(dp, st, startIndex + 1, endIndex);
                int c2 = findLPSLengthRecursive(dp, st, startIndex, endIndex - 1);
                dp[startIndex][endIndex] = Math.max(c1, c2);
            }
        }

        return dp[startIndex][endIndex];
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
}
