package com.interview.codechef.ccdsap_2.leetcode.dp.newproblems;

public class LongestCommonSupersequence {

    //https://leetcode.com/problems/shortest-common-supersequence/

    //check this too : https://leetcode.com/problems/shortest-common-supersequence/discuss/319439/Java-DP-bottom-up-(2D-matrix)

    public static void main( String[] args ) {
        String s = "abac", t = "cab";

        System.out.println(solve(s, t));
    }

    private static String solve( String s, String t ) {
        String lcs = solveBottonUpDP(s, t);

        return findLCSuperSeq(lcs, s, t);
    }

    private static String findLCSuperSeq( String lcs, String str1, String str2 ) {

        int p1 = 0, p2 = 0;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < lcs.length(); i++) {

            while (p1 < str1.length() && str1.charAt(p1) != lcs.charAt(i)) {
                sb.append(str1.charAt(p1++));
            }

            while (p2 < str2.length() && str2.charAt(p2) != lcs.charAt(i)) {
                sb.append(str2.charAt(p2++));
            }

            sb.append(lcs.charAt(i));

            p1++;
            p2++;
        }

        //if (p1 <= str1.length() - 1)
        // sb.append(str1.substring(p1));

        //if (p2 <= str2.length() - 1)
        // sb.append(str2.substring(p2));

        return sb.toString();
    }

    //from: com.interview.codingblocks.week9DynamicProgrammming.LongestCommonSubsequence
    private static String solveBottonUpDP( String s, String t ) {

        String dp[][] = new String[s.length() + 1][t.length() + 1];

        //for 2d DP base case : set first row and column to zero
        for (int i = 0; i <= s.length(); i++) {
            dp[i][0] = ""; //filling first column
        }

        for (int j = 0; j <= t.length(); j++) {
            dp[0][j] = ""; //filling first row
        }

        for (int i = 1; i <= s.length(); i++) {

            for (int j = 1; j <= t.length(); j++) {

                if (s.charAt(i - 1) == t.charAt(j - 1)) //bcz (i,j) may reach upto length+1)
                    dp[i][j] = s.charAt(i - 1) + dp[i - 1][j - 1]; //+1 to include the current char
                else {

                    dp[i][j] = dp[i][j - 1].length() > dp[i - 1][j].length() ? dp[i][j - 1] : dp[i - 1][j];
                }
            }
        }

        return dp[s.length()][t.length()];
    }
}
