package com.interview.leetcode.dp.grokkingdp.stringmanipulation;

public class ShortestCommonSuperSeq {

    //https://leetcode.com/problems/shortest-common-supersequence/
    //for example: https://www.youtube.com/watch?v=823Grn4_dCQ

    //Given strings: A = "AGGTAB", B = "GXTXAYB"
    //We have to find that shortest shortest string contains both the content of A & B
    //Let merge above strings : " AGGTAB GXTXAYB ", So we can remove common chars to create a
    //shortest common super seq {that has both sequence present} : " A G G X T X A Y B" == 10 length
    public static void main( String[] args ) {
        ShortestCommonSuperSeq scs = new ShortestCommonSuperSeq();
        System.out.println(scs.findSCSLength("AGGTAB", "GXTXAYB"));
    }

    public int findSCSLength( String s1, String s2 ) {
        Integer[][] dp = new Integer[s1.length()][s2.length()];
        return findLCSLengthRecursive(dp, s1, s2, 0, 0);
    }

    private int findLCSLengthRecursive( Integer[][] dp, String s1, String s2, int i1, int i2 ) {
        //if any string reach to end, we have to append other String remaining chars
        // ,bcz we already appended the common chars of S1 and S2
        if (i1 == s1.length())
            return s2.length() - i2; //first diff from LCS

        if (i2 == s2.length())
            return s1.length() - i1; //second diff from LCS

        if (dp[i1][i2] == null) {
            if (s1.charAt(i1) == s2.charAt(i2))
                dp[i1][i2] = 1 + findLCSLengthRecursive(dp, s1, s2, i1 + 1, i2 + 1);
            else {
                int c1 = 1 + findLCSLengthRecursive(dp, s1, s2, i1, i2 + 1); //third diff. : +1 bcz we have to take other string length into consideration, incase not common
                int c2 = 1 + findLCSLengthRecursive(dp, s1, s2, i1 + 1, i2);
                dp[i1][i2] = Math.min(c1, c2); //one diff from LCS
            }
        }

        return dp[i1][i2];
    }


}
