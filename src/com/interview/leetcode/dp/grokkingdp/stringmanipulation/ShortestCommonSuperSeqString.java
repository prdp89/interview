package com.interview.leetcode.dp.grokkingdp.stringmanipulation;

import java.util.Arrays;

public class ShortestCommonSuperSeqString {

    //https://leetcode.com/problems/shortest-common-supersequence/
    //for example: https://www.youtube.com/watch?v=823Grn4_dCQ

    //Given strings: A = "AGGTAB", B = "GXTXAYB"
    //We have to find that shortest shortest string contains both the content of A & B
    //Let merge above strings : " AGGTAB GXTXAYB ", So we can remove common chars to create a
    //shortest common super seq {that has both sequence present} : " A G G X T X A Y B"
    public static void main( String[] args ) {
        ShortestCommonSuperSeqString scs = new ShortestCommonSuperSeqString();
        System.out.println(scs.shortestCommonSupersequence("AGGTAB", "GXTXAYB"));
    }

    //Runtime: 28 ms, faster than 22.20% of Java o
    public String shortestCommonSupersequence( String str1, String str2 ) {

        //we found Longest common substring berween s & t
        String lcs = findLCSLength_2D_DP(str1, str2);

        //We found the common chars above, only pendings are Chars which is not present is LCS string
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

        if (p1 < str1.length())
            sb.append(str1.substring(p1));

        if (p2 < str2.length())
            sb.append(str2.substring(p2));

        return sb.toString();
    }

    //find LCS string with same Logic
    private String findLCSLength_2D_DP( String str1, String str2 ) {
        String[][] dp = new String[str1.length() + 1][str2.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], "");
        }

        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {

                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + str1.charAt(i - 1);
                } else {
                    dp[i][j] = dp[i - 1][j].length() > dp[i][j - 1].length() ? dp[i - 1][j] : dp[i][j - 1];
                }
            }
        }
        return dp[str1.length()][str2.length()];
    }
}
