package com.interview.leetcode.dp.grokkingdp.stringmanipulation;

public class MinDeletionAndInsertion {

    /*
    Input: s1 = "abc"
       s2 = "fbc"

    Output: 1 deletion and 1 insertion.
    Explanation: We need to delete {'a'} and insert {'f'} to s1 to transform it into s2.
     */
    public static void main( String[] args ) {
        MinDeletionAndInsertion mdi = new MinDeletionAndInsertion();
        mdi.findMDI("abc", "fbc");
    }

    public void findMDI( String s1, String s2 ) {
        int c1 = findLCSLength(s1, s2);

        //If c1 is LCS between 2 strings..
        //Then we need s1.length - c1 deletion and,
        //We need s2.length - c1 insertions and,

        System.out.println("Minimum deletions needed: " + (s1.length() - c1));
        System.out.println("Minimum insertions needed: " + (s2.length() - c1));
    }

    //This problem is almost same as LongestCommonSubSequence
    private int findLCSLength( String s1, String s2 ) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        int maxLength = 0;

        for (int i = 1; i <= s1.length(); i++) {

            for (int j = 1; j <= s2.length(); j++) {

                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);

                maxLength = Math.max(maxLength, dp[i][j]);
            }
        }

        return maxLength;
    }

}
