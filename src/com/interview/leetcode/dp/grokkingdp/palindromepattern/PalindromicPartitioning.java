package com.interview.leetcode.dp.grokkingdp.palindromepattern;

public class PalindromicPartitioning {

    //https://leetcode.com/problems/palindrome-partitioning-ii/
    public static void main( String[] args ) {
        PalindromicPartitioning mpp = new PalindromicPartitioning();
        System.out.println(mpp.findMPPCuts("aab"));

        System.out.println(mpp.findMPPCuts_TopDown_DP("aab"));
    }


    //region Recursive
    //TLE
    //26 / 29 test cases passed.
    public int findMPPCuts( String st ) {
        return this.findMPPCutsRecursive(st, 0, st.length() - 1);
    }

    private int findMPPCutsRecursive( String st, int startIndex, int endIndex ) {
        // we don't need to cut the string if it is a palindrome
        if (startIndex >= endIndex || isPalindrome(st, startIndex, endIndex))
            return 0;

        // at max, we need to cut the string into its 'length-1' pieces
        int minimumCuts = endIndex - startIndex; //just assigning max cut value

        for (int i = startIndex; i <= endIndex; i++) {
            if (isPalindrome(st, startIndex, i)) {
                // we can cut here as we have a palindrome from 'startIndex' to 'i'
                minimumCuts = Math.min(minimumCuts, 1 + findMPPCutsRecursive(st, i + 1, endIndex));
            }
        }
        return minimumCuts;
    }

    private boolean isPalindrome( String st, int x, int y ) {
        while (x < y) {
            if (st.charAt(x++) != st.charAt(y--))
                return false;
        }
        return true;
    }
    //endregion

    //region TOP_DOWN DP
    //Runtime: 1499 ms, faster than 6.90% of Java : without Memoizing isPalindrome method

    //Runtime: 21 ms, faster than 39.50% of Java : using Memoization in isPalindrome mathod.
    public int findMPPCuts_TopDown_DP( String st ) {
        Integer dp[][] = new Integer[st.length()][st.length()];
        Boolean dpIsPalindrome[][] = new Boolean[st.length()][st.length()];
        return this.findMPPCutsRecursive(dp, dpIsPalindrome, st, 0, st.length() - 1);
    }

    //this recurrence is same as PalindromePartitioning : com.interview.codechef.ccdsap_2.leetcode.backtracking.medium

    //just that we are counting here with: 1 + fun(,) and finding minimum
    private int findMPPCutsRecursive( Integer dp[][], Boolean dpIsPalindrome[][],
                                      String st, int startIndex, int endIndex ) {

        if (startIndex >= endIndex || isPalindrome(dpIsPalindrome, st, startIndex, endIndex))
            return 0; //we are finding min. as CoinChangeMinCoins, so return zero and +1 later on..

        if (dp[startIndex][endIndex] == null) {

            // at max, we need to cut the string into its 'length-1' pieces
            int minimumCuts = st.length(); //or assign Integer.MAX_VALUE

            for (int i = startIndex; i <= endIndex; i++) {

                //PalindromePartitioning : same as.. :)
                if (isPalindrome(dpIsPalindrome, st, startIndex, i)) {

                    // we can cut here as we have a palindrome from 'startIndex' to 'i'
                    minimumCuts = Math.min(minimumCuts,
                            1 + findMPPCutsRecursive(dp, dpIsPalindrome, st, i + 1, endIndex));
                }
            }

            dp[startIndex][endIndex] = minimumCuts;
        }

        return dp[startIndex][endIndex];
    }

    private boolean isPalindrome( Boolean dpIsPalindrome[][], String st, int x, int y ) {
       /* while (x < y) {
            if (st.charAt(x++) != st.charAt(y--))
                return false;
        }
        return true;*/

        if (dpIsPalindrome[x][y] == null) {
            dpIsPalindrome[x][y] = true;

            int i = x, j = y;

            while (i < j) {
                if (st.charAt(i++) != st.charAt(j--)) {
                    dpIsPalindrome[x][y] = false;
                    break;
                }

                //If below code is commented then Time:
                //Runtime: 581 ms, faster then 28.45% of Java

                // use memoization to find if the remaining string is a palindrome
                if (i < j && dpIsPalindrome[i][j] != null) {
                    dpIsPalindrome[x][y] = dpIsPalindrome[i][j];
                    break;
                }
            }
        }

        return dpIsPalindrome[x][y];
    }
    //endregion


    //region BOTTOM_UP_DP
    //Bottom up DP is little tricky and difficult: read from docs, if you want..
    //endregion

}
