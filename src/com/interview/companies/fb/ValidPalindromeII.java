package com.interview.companies.fb;

public class ValidPalindromeII {

    //https://leetcode.com/problems/valid-palindrome-ii/
    public static void main( String[] args ) {
        String str = "aba";

        System.out.println(validPalindromeOPtimal(str));
    }

    //Runtime: 7 ms, faster than 63.92% of Java online
    private static boolean validPalindromeOPtimal( String s ) {

        int low = 0, high = s.length() - 1;

        while (low <= high) {
            if (s.charAt(low) == s.charAt(high)) {
                low++;
                high--;
            } else {
                return isPlaindrome(s, low, high - 1) || isPlaindrome(s, low + 1, high);
            }
        }

        return true;
    }

    private static boolean isPlaindrome( String s, int low, int high ) {

        while (low <= high) {
            if (s.charAt(low++) != s.charAt(high--))
                return false;
        }

        return true;
    }

    //Tried using LCS for palindrome
    //https://leetcode.com/submissions/detail/340672501/
    //370 / 460 test cases passed.
    public boolean validPalindrome( String s ) {
        StringBuilder sb = new StringBuilder(s);

        String t = sb.reverse().toString();

        int[][] dp = new int[s.length() + 1][t.length() + 1];

        for (int i = 1; i <= s.length(); i++) {

            for (int j = 1; j <= t.length(); j++) {

                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return s.length() - dp[s.length()][t.length()] <= 1;
    }
}
