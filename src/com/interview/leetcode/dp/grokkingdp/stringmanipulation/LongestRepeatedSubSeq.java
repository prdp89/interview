package com.interview.leetcode.dp.grokkingdp.stringmanipulation;

public class LongestRepeatedSubSeq {

    /*
    A repeating subsequence will be the one that appears at least twice in the
    original sequence and is not overlapping (i.e. none of the corresponding characters
    in the repeating subsequences have the same index).

    Example 1:

    Input: “t o m o r r o w”
    Output: 2
    Explanation: The longest repeating sub-sequence is “or” {tomorrow}.
     */
    public static void main( String[] args ) {
        LongestRepeatedSubSeq lrs = new LongestRepeatedSubSeq();

        System.out.println(lrs.findLRSLength("tomorrow"));
        System.out.println(lrs.findLRSLength_2D_DP("tomorrow"));
    }

    private int findLRSLength( String str ) {
        Integer[][] dp = new Integer[str.length()][str.length()];
        return findLRSLengthRecursive(dp, str, 0, 0);
    }

    //This logic is same as LongestCommonSubSeq
    private int findLRSLengthRecursive( Integer[][] dp, String str, int i1, int i2 ) {
        if (i1 == str.length() || i2 == str.length())
            return 0;

        if (dp[i1][i2] == null) {
            if (i1 != i2 && str.charAt(i1) == str.charAt(i2))
                dp[i1][i2] = 1 + findLRSLengthRecursive(dp, str, i1 + 1, i2 + 1);
            else {
                int c1 = findLRSLengthRecursive(dp, str, i1, i2 + 1);
                int c2 = findLRSLengthRecursive(dp, str, i1 + 1, i2);
                dp[i1][i2] = Math.max(c1, c2);
            }
        }

        return dp[i1][i2];
    }

    public int findLRSLength_2D_DP( String str ) {
        int[][] dp = new int[str.length() + 1][str.length() + 1];
        int maxLength = 0;

        // dp[i1][i2] will be storing the LRS up to str[0..i1-1][0..i2-1]
        // this also means that subsequences of length zero (first row and column of dp[][]),
        // will always have LRS of size zero.
        for (int i1 = 1; i1 <= str.length(); i1++) {

            for (int i2 = 1; i2 <= str.length(); i2++) {

                if (i1 != i2 && str.charAt(i1 - 1) == str.charAt(i2 - 1))
                    dp[i1][i2] = 1 + dp[i1 - 1][i2 - 1];
                else
                    dp[i1][i2] = Math.max(dp[i1 - 1][i2], dp[i1][i2 - 1]);

                maxLength = Math.max(maxLength, dp[i1][i2]);
            }
        }
        return maxLength;
    }

}
