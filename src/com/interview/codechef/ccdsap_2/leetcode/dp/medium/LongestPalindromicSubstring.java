package com.interview.codechef.ccdsap_2.leetcode.dp.medium;

public class LongestPalindromicSubstring {

    //https://leetcode.com/problems/longest-palindromic-substring/
    public static void main( String[] args ) {
        System.out.println(subString("cbbd".toCharArray(), 4));
    }

    //region Brute Force O(N^3)
    private static int subString( char[] str, int n ) {

        int maxLength = Integer.MIN_VALUE;
        String str1 = "";
        for (int i = 0; i < n; i++) {

            StringBuilder c = new StringBuilder("");
            c.append(str[i]);

            for (int k = i + 1; k <= n; k++) {

                if (isPalindrome(c.toString(), 0, c.length() - 1)) {
                    if (c.length() > maxLength) {
                        maxLength = c.length();
                        str1 = c.toString();
                    }
                }

                if (k < n) {
                    c.append(str[k]);
                }
            }
        }

        System.out.println(str1);

        return maxLength;
    }

    private static boolean isPalindrome( String s, int low, int high ) {

        while (low < high) {
            if (s.charAt(low++) != s.charAt(high--)) {
                return false;
            }
        }

        return true;
    }
    //endregion

    //Second solution : Very efficient solution even O(N^2) in the worst case
    //com.interview.codechef.ccdsapfoundation_1.recurse.educativeIO.CountPalindromicSubstrings
}
