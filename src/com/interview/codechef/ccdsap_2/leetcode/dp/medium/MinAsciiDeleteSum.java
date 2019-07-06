package com.interview.codechef.ccdsap_2.leetcode.dp.medium;

import java.util.Arrays;

public class MinAsciiDeleteSum {

    //https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/

    //This problem is similar to Longest Common Subsequence
    public static void main( String[] args ) {
        String str1 = "sea", str2 = "eat";
        System.out.println(minimumDeleteSum(str1, str2));
    }

    private static int minimumDeleteSum( String s1, String s2 ) {

        if (s2.length() == 0)
            return rest(0, s1);

        if (s1.length() == 0)
            return rest(0, s2);

        int[][] cache = new int[s1.length() + 1][s2.length() + 1];

        for (int[] row : cache) {
            Arrays.fill(row, -1);
        }

        return helper(0, 0, s1, s2, cache);
    }

    private static int helper( int i, int j, String s1, String s2, int[][] cache ) {

        //if first string finish then Longest common Between S1 and S2 are already found
        //so, remaining from S2 are pending character and has to be deleted
        if (i == s1.length()) {
            return rest(j, s2);
        }

        if (j == s2.length()) {
            return rest(i, s1);
        }

        //for dp scenario
        if (cache[i][j] != -1) {
            return cache[i][j];
        }

        //same logic as LCS
        if (s1.charAt(i) == s2.charAt(j)) {
            cache[i][j] = helper(i + 1, j + 1, s1, s2, cache);
            return cache[i][j];
        }

        //include first string and exclude second + adding current character considering it deleted
        int left = (int) s1.charAt(i) + helper(i + 1, j, s1, s2, cache);

        int right = (int) s2.charAt(j) + helper(i, j + 1, s1, s2, cache);

        //finding lowest ASCII sum of deleted characters
        cache[i][j] = Math.min(left, right);

        return cache[i][j];
    }

    //calculating character which should be deleted from String
    private static int rest( int index, String s ) {
        int summation = 0;

        for (int sum = index; sum < s.length(); sum++) {
            summation += (int) s.charAt(sum); //getting ascii value by typecasting
        }

        return summation;
    }
}
