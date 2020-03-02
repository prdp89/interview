package com.interview.companies.MSFT;

public class LongestSemiAlteringString {

    //https://leetcode.com/discuss/interview-question/398037/
    public static void main( String[] args ) {
        System.out.println(longestSemiAlteringSubString("baaabbabbb"));
    }

    //This problem is based on SlidingWindow technique and similar to LongestSubstringWithout3ConsecutiveChar
    private static int longestSemiAlteringSubString( String s ) {
        if (s.length() < 3)
            return s.length();

        int res = 0, left = 0, right = 2;

        while (right < s.length() && left < right) {
            if (s.charAt(right) == s.charAt(right - 1) && s.charAt(right) == s.charAt(right - 2)) {
                left += 2;
            }

            right++;

            if ((right - left) > res)
                res = right - left;
        }

        return res;
    }
}
