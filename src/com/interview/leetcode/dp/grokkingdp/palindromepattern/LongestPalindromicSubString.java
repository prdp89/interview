package com.interview.leetcode.dp.grokkingdp.palindromepattern;

public class LongestPalindromicSubString {

    private static String res = "";

    public static void main( String[] args ) {
        LongestPalindromicSubString lps = new LongestPalindromicSubString();
        System.out.println(lps.findLPSLength("abdbca"));
        System.out.println(res);

        System.out.println(lps.findLPSLength_2D_DP("abdbca"));

    }

    //Runtime: 379 ms, faster than 7.68% of Java online.. by me :)
    //https://leetcode.com/submissions/detail/350873519/
    public int findLPSLength( String st ) {
        /*if(st.length() == 0)
            return "";

        if(st.length() == 1)
            return st.charAt(0) + "";*/

        res = st.charAt(0) + "";

        Integer[][] dp = new Integer[st.length()][st.length()];
        return findLPSLengthRecursive(dp, st, 0, st.length() - 1);
    }

    private int findLPSLengthRecursive( Integer[][] dp, String st, int start, int end ) {

        if (start > end)
            return 0;

        //1 length string is always Palindrome
        if (start == end)
            return 1;

        if (dp[start][end] == null) {

            //include
            if (st.charAt(start) == st.charAt(end)) {
                //in LongestPalindromicSubSeq : we do 2+ fun(,) bcz that is Subseq
                //but in Substring : If start == end then every chars bw start --> end should match

                int charInBetween = end - start - 1; //-1 bcz in bw chars : start --> end

                if (charInBetween == findLPSLengthRecursive(dp, st, start + 1, end - 1)) {
                    //then only return 2+charInBetween
                    dp[start][end] = 2 + charInBetween;

                    //just to calculate output string..
                    if ((end - start + 1 > res.length())) {
                        res = st.substring(start, end + 1);
                    }

                    return dp[start][end];
                }
            }

            //exclude
            int left = findLPSLengthRecursive(dp, st, start + 1, end);
            int right = findLPSLengthRecursive(dp, st, start, end - 1);

            dp[start][end] = Math.max(left, right);
        }

        return dp[start][end];
    }

    public int findLPSLength_2D_DP( String st ) {
        // dp[i][j] stores the length of LPS from index 'i' to index 'j'
        boolean[][] dp = new boolean[st.length()][st.length()];

        // every sequence with one element is a palindrome of length 1
        for (int i = 0; i < st.length(); i++)
            dp[i][i] = true;

        //initially : startIndx = 5 , innerLoop: endIndex = 5 ; not execute
        //Then startIndex= 4; endIndex : 4--5
        //Then startIndex = 3; endIndex : 3 -- 5

        int maxLength = 1;
        for (int startIndex = st.length() - 1; startIndex >= 0; startIndex--) {
            for (int endIndex = startIndex + 1; endIndex < st.length(); endIndex++) {

                //..................did not understood this part properly.................
                if (st.charAt(startIndex) == st.charAt(endIndex)) {
                    // if it's a two character string or if the remaining string is a palindrome too
                    if (endIndex - startIndex == 1 || dp[startIndex + 1][endIndex - 1]) {
                        dp[startIndex][endIndex] = true;
                        maxLength = Math.max(maxLength, endIndex - startIndex + 1);
                    }
                }
                //.......................................................................
            }
        }

        return maxLength;
    }

    //O(N^ 2) solution : LongestPalindromSubstring : com.interview.codechef.ccdsapfoundation_1.DP.educativeIO
}
